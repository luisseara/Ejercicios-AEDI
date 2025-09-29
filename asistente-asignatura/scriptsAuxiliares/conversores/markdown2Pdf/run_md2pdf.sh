#!/usr/bin/env bash
# Script de gestión e interacción con el conversor Markdown → PDF/DOCX
# Amigable para entornos de agentes/CI: salida en vivo y logs visibles.

set -Eeuo pipefail
[ "${DEBUG:-0}" = "1" ] && set -x

# --- Python sin buffering para ver prints en tiempo real ---
export PYTHONUNBUFFERED=1

# --- Emojis automáticos sólo si hay TTY ---
if [ -t 1 ]; then USE_TTY=1; else USE_TTY=0; fi
NO_EMOJI=${NO_EMOJI:-$((1 - ${USE_TTY}))}

# --- Helpers de logging (duplican a stderr) ---
say() { # usage: say "con_emoji" "sin_emoji"
  if [ "${NO_EMOJI}" = "1" ]; then printf "%s\n" "$2" | tee /dev/stderr
  else printf "%s\n" "$1" | tee /dev/stderr
  fi
}
log() { printf "%s\n" "$1" | tee /dev/stderr; }

# --- Ejecutar siempre desde la carpeta del script ---
cd "$(dirname "$0")"

# --- Poetry dentro del proyecto ---
export POETRY_VIRTUALENVS_IN_PROJECT=1
poetry_py() { poetry run python -u "$@"; }

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

  if ! command -v pandoc >/dev/null 2>&1; then
    log "❌ Pandoc no está instalado o no está en el PATH."
    log "   Instálalo: https://pandoc.org/installing.html"
    exit 1
  fi
  local pandoc_version
  pandoc_version="$(pandoc --version | head -n 1 || true)"
  log "   - ${pandoc_version}"

  local weasy_version
  if ! weasy_version="$(poetry run weasyprint --version 2>&1 | head -n 1)"; then
    log "❌ No se pudo ejecutar WeasyPrint desde el entorno Poetry."
    log "   Ejecuta ./run_md2pdf.sh install para reinstalar dependencias."
    exit 1
  fi
  log "   - ${weasy_version}"

  log "✅ Dependencias verificadas correctamente"
}

run_converter() {
  ensure_poetry
  ensure_environment
  verify_dependencies
  log "📁 Directorio actual: $(pwd)"
  log "🐍 Python: $(poetry run which python)"
  printf "\n" | tee /dev/stderr
  say "🔄 Ejecutando conversión Markdown → PDF/DOCX..." "Ejecutando conversión Markdown → PDF/DOCX..."
  poetry_py simple_converter.py "$@"
}

print_usage() {
  cat <<'EOF'
Uso del script:
  ./run_md2pdf.sh install                 # Crear/actualizar el entorno con Poetry
  ./run_md2pdf.sh update                  # Actualizar dependencias al último lock
  ./run_md2pdf.sh reinstall               # Regenerar el entorno desde cero
  ./run_md2pdf.sh convert [opciones]      # Ejecutar el conversor Markdown → PDF/DOCX
                                          #   Ejemplo: ./run_md2pdf.sh convert --docx
  ./run_md2pdf.sh help                    # Mostrar la ayuda del conversor

Sugerencias para agentes/CI:
  - Invoca con:     bash ./run_md2pdf.sh convert ...
  - Forzar logs:    NO_EMOJI=1 DEBUG=1 bash ./run_md2pdf.sh convert ...
  - Python en vivo: PYTHONUNBUFFERED=1 (ya activado por defecto)
EOF
}

# --- Entrada principal ---
if [ $# -eq 0 ]; then
  print_usage
  exit 0
fi

case "$1" in
  install)   install_environment ;;
  update)    update_environment ;;
  reinstall) reinstall_environment ;;
  convert)   shift; run_converter "$@" ;;
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
