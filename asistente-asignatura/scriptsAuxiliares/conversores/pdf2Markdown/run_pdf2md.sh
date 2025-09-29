#!/usr/bin/env bash
# Script de gestión e interacción con el conversor PDF → Markdown
# Compatible con entornos de agentes (CI/copilots): salida en vivo y logs visibles.

set -Eeuo pipefail

# --- Modo debug opcional (DEBUG=1) ---
[ "${DEBUG:-0}" = "1" ] && set -x

# --- Desbufferizar Python para ver logs en vivo incluso sin TTY ---
export PYTHONUNBUFFERED=1

# --- Detectar TTY y decidir si usar emojis ---
if [ -t 1 ]; then
  USE_TTY=1
else
  USE_TTY=0
fi
NO_EMOJI=${NO_EMOJI:-$((1 - ${USE_TTY}))}

# --- Helpers de logging (duplican a stderr para UIs que muestran sólo stderr) ---
say() {
  # usage: say "con_emoji" "sin_emoji"
  if [ "${NO_EMOJI}" = "1" ]; then
    printf "%s\n" "$2" | tee /dev/stderr
  else
    printf "%s\n" "$1" | tee /dev/stderr
  fi
}
log() { printf "%s\n" "$1" | tee /dev/stderr; }  # alias simple

# --- Asegurar ejecución desde la carpeta del script ---
cd "$(dirname "$0")"

# --- Poetry dentro del proyecto ---
export POETRY_VIRTUALENVS_IN_PROJECT=1

# --- Wrapper Python vía Poetry en modo unbuffered ---
poetry_py() {
  poetry run python -u "$@"
}

ensure_poetry() {
    if ! command -v poetry >/dev/null 2>&1; then
        log "❌ Poetry no está instalado en el sistema."
        log "   Instálalo: https://python-poetry.org/docs/"
        exit 1
    fi
}

install_environment() {
    ensure_poetry
    say "📦 Instalando dependencias con Poetry..." "Instalando dependencias con Poetry..."
    poetry install
}

ensure_environment() {
    if [ ! -d ".venv" ]; then
        say "⚙️  No se encontró el entorno .venv. Creándolo con Poetry..." "No se encontró el entorno .venv. Creándolo con Poetry..."
        install_environment
    fi
}

update_environment() {
    ensure_poetry
    say "🔄 Actualizando dependencias con Poetry..." "Actualizando dependencias con Poetry..."
    poetry update
}

reinstall_environment() {
    ensure_poetry
    if [ -d ".venv" ]; then
        say "🧹 Eliminando entorno virtual actual..." "Eliminando entorno virtual actual..."
        rm -rf .venv
    fi
    install_environment
}

verify_dependencies() {
    ensure_poetry
    ensure_environment
    say "🔍 Verificando dependencias principales..." "Verificando dependencias principales..."
    poetry_py - <<'PYCODE'
try:
    from docling.document_converter import DocumentConverter  # noqa: F401
    print("✅ Docling verificado correctamente", flush=True)
except Exception as exc:
    import sys
    print(f"❌ Error al verificar dependencias: {exc}. Usa la opción update para arreglarlo!", file=sys.stderr, flush=True)
    raise SystemExit(1)
PYCODE
}

run_converter() {
    ensure_poetry
    ensure_environment
    verify_dependencies
    log "📁 Directorio actual: $(pwd)"
    log "🐍 Python: $(poetry run which python)"
    printf "\n" | tee /dev/stderr
    say "🔄 Ejecutando conversión PDF → Markdown..." "Ejecutando conversión PDF → Markdown..."
    # Pasar argumentos tal cual al conversor
    poetry_py simple_converter.py "$@"
}

print_usage() {
    cat <<'EOF'
Uso del script:
  ./run_pdf2md.sh install                    # Crear/actualizar el entorno con Poetry
  ./run_pdf2md.sh update                     # Actualizar dependencias al último lock
  ./run_pdf2md.sh reinstall                  # Regenerar el entorno desde cero
  ./run_pdf2md.sh convert [opciones]         # Ejecutar el conversor PDF → Markdown
  ./run_pdf2md.sh help                       # Mostrar la ayuda del conversor

Opciones de conversión disponibles:
  ./run_pdf2md.sh convert                    # Convierte todos los PDFs en base_de_conocimiento (por defecto)
  ./run_pdf2md.sh convert -f documento.pdf   # Convierte un archivo PDF específico
  ./run_pdf2md.sh convert -d carpeta         # Convierte todos los PDFs de una carpeta (incluye subdirectorios)

Argumentos del conversor:
  -f FILE, --file FILE         Convierte un archivo PDF específico
  -d DIRECTORY, --directory    Convierte todos los PDFs en el directorio especificado (incluye subdirectorios)

Ejemplos prácticos:
  ./run_pdf2md.sh convert -f ../../../base_de_conocimiento/enunciados/documento.pdf
  ./run_pdf2md.sh convert -d ../../../base_de_conocimiento/enunciados
  ./run_pdf2md.sh convert -d /ruta/completa/a/directorio

Nota: Si no se especifica -f ni -d, se convierten todos los PDFs encontrados en base_de_conocimiento

Sugerencias para agentes/CI:
  - Ejecuta con:      bash ./run_pdf2md.sh convert ...   (evita invocarlo vía 'sh')
  - Forzar logs:      NO_EMOJI=1 DEBUG=1 bash ./run_pdf2md.sh convert ...
  - Python en vivo:   PYTHONUNBUFFERED=1 (ya activado por defecto)
EOF
}

# --- Entrada principal ---
if [ $# -eq 0 ]; then
    print_usage
    exit 0
fi

case "$1" in
    install)
        install_environment
        ;;
    update)
        update_environment
        ;;
    reinstall)
        reinstall_environment
        ;;
    convert)
        shift
        run_converter "$@"
        ;;
    help|-h|--help)
        ensure_poetry
        ensure_environment
        poetry_py -- simple_converter.py --help
        ;;
    *)
        print_usage
        exit 1
        ;;
esac
