#!/usr/bin/env bash
# Script de gestión e interacción con el conversor PDF → Markdown
# Compatible con entornos de agentes (CI/copilots): salida en vivo y logs visibles.

set -Eeuo pipefail

# --- Modo debug opcional (DEBUG=1) ---
[ "${DEBUG:-0}" = "1" ] && set -x

# --- Asegurar que PDM instalado vía pip --user esté en PATH ---
export PATH="${HOME}/.local/bin:${PATH}"

# --- Desbufferizar Python para ver logs en vivo incluso sin TTY ---
export PYTHONUNBUFFERED=1

# --- Obligar a PDM a crear el entorno dentro del proyecto ---
export PDM_USE_VENV=1
export PDM_VENV_IN_PROJECT=1

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

# --- Wrapper Python vía PDM en modo unbuffered ---
pdm_py() {
  pdm run python -u "$@"
}

ensure_pdm() {
  if ! command -v pdm >/dev/null 2>&1; then
    log "❌ PDM no está instalado en el sistema."
    log "   Instálalo: https://pdm.fming.dev/latest/"
    exit 1
  fi
}

install_environment() {
  ensure_pdm
  say "📦 Instalando dependencias con PDM..." "Instalando dependencias con PDM..."
  pdm install
}

ensure_environment() {
  ensure_pdm
  if [ ! -d ".venv" ]; then
    say "⚙️  No se encontró el entorno .venv. Creándolo con PDM..." "No se encontró el entorno .venv. Creándolo con PDM..."
    install_environment
  else
    pdm use -f .venv >/dev/null 2>&1 || true
  fi
}

update_environment() {
  ensure_environment
  say "🔄 Actualizando dependencias con PDM..." "Actualizando dependencias con PDM..."
  pdm update
}

reinstall_environment() {
  ensure_pdm
  if [ -d ".venv" ]; then
    say "🧹 Eliminando entorno virtual actual..." "Eliminando entorno virtual actual..."
    rm -rf .venv
  fi
  install_environment
}

verify_dependencies() {
  ensure_environment
  say "🔍 Verificando dependencias principales..." "Verificando dependencias principales..."
  pdm_py - <<'PYCODE'
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
  ensure_environment
  verify_dependencies
  log "📁 Directorio actual: $(pwd)"
  log "🐍 Python: $(pdm info --python 2>/dev/null || true)"
  printf "\n" | tee /dev/stderr
  say "🔄 Ejecutando conversión PDF → Markdown..." "Ejecutando conversión PDF → Markdown..."
  # Pasar argumentos tal cual al conversor
  pdm_py simple_converter.py "$@"
}

print_usage() {
  cat <<'USAGE'
Uso del script:
  ./run_pdf2md.sh install                    # Crear/actualizar el entorno con PDM
  ./run_pdf2md.sh update                     # Actualizar dependencias al último lock
  ./run_pdf2md.sh reinstall                  # Regenerar el entorno desde cero
  ./run_pdf2md.sh convert [opciones]         # Ejecutar el conversor PDF → Markdown
  ./run_pdf2md.sh help                       # Mostrar la ayuda del conversor

Nota: Si no se especifica -f ni -d, se convierten todos los PDFs encontrados en base_de_conocimiento

Sugerencias para agentes/CI:
  - Ejecuta con:      NO_EMOJI=1 DEBUG=1 bash ./run_pdf2md.sh convert ...
  - Python en vivo:   PYTHONUNBUFFERED=1 (ya activado por defecto)

Opciones de conversión disponibles:

USAGE
  ensure_environment
  pdm run python simple_converter.py -h
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
    print_usage
    ;;
  *)
    print_usage
    exit 1
    ;;
esac
