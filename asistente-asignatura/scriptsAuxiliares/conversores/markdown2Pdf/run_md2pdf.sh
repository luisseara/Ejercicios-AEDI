#!/usr/bin/env bash
# Script de gestión e interacción con el conversor Markdown → PDF/DOCX
# Amigable para entornos de agentes/CI: salida en vivo y logs visibles.

set -Eeuo pipefail
[ "${DEBUG:-0}" = "1" ] && set -x

# --- Asegurar que PDM instalado vía pip --user esté en PATH ---
export PATH="${HOME}/.local/bin:${PATH}"

# --- Python sin buffering para ver prints en tiempo real ---
export PYTHONUNBUFFERED=1

# --- Obligar a PDM a crear el entorno dentro del proyecto ---
export PDM_USE_VENV=1
export PDM_VENV_IN_PROJECT=1

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

# --- Wrapper Python vía PDM ---
pdm_py() { pdm run python -u "$@"; }

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

  if ! command -v pandoc >/dev/null 2>&1; then
    log "❌ Pandoc no está instalado o no está en el PATH."
    log "   Instálalo: https://pandoc.org/installing.html"
    exit 1
  fi
  local pandoc_version
  pandoc_version="$(pandoc --version | head -n 1 || true)"
  log "   - ${pandoc_version}"

  local weasy_version
  if ! weasy_version="$(pdm run weasyprint --version 2>&1 | head -n 1)"; then
    log "❌ No se pudo ejecutar WeasyPrint desde el entorno PDM."
    log "   Ejecuta ./run_md2pdf.sh install para reinstalar dependencias."
    exit 1
  fi
  log "   - ${weasy_version}"

  log "✅ Dependencias verificadas correctamente"
}

run_converter() {
  ensure_environment
  verify_dependencies
  log "📁 Directorio actual: $(pwd)"
  log "🐍 Python: $(pdm info --python 2>/dev/null || true)"
  printf "\n" | tee /dev/stderr
  say "🔄 Ejecutando conversión Markdown → PDF/DOCX..." "Ejecutando conversión Markdown → PDF/DOCX..."
  pdm_py simple_converter.py "$@"
}

print_usage() {
  cat <<'USAGE'
Uso del script:
  ./run_md2pdf.sh install                           # Crear/actualizar el entorno con PDM
  ./run_md2pdf.sh update                            # Actualizar dependencias al último lock
  ./run_md2pdf.sh reinstall                         # Regenerar el entorno desde cero
  ./run_md2pdf.sh convert [opciones]                # Ejecutar el conversor Markdown → PDF/DOCX
  ./run_md2pdf.sh help                              # Mostrar la ayuda del conversor

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
