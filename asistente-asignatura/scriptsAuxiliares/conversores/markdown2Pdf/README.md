# Markdown to PDF/DOCX Converter

Herramienta Python para el proyecto aedi-agent que utiliza [Pandoc](https://pandoc.org/) para convertir archivos Markdown a formato PDF y/o DOCX. El proyecto utiliza [Poetry](https://python-poetry.org/) para gestionar un entorno virtual aislado dentro de la carpeta `markdown2Pdf` y así disponer de WeasyPrint necesario para la exportación a PDF de alta calidad.

> 💡 **Requisito del sistema**: Instala Pandoc en tu sistema. En distribuciones Debian/Ubuntu: `sudo apt install pandoc`

## 🚀 Uso Rápido

### Preparar el entorno (una sola vez)
```bash
cd asistente-asignatura/scriptsAuxiliares/conversores/markdown2Pdf
./run_md2pdf.sh install
```

### Actualizar dependencias según `poetry.lock`
```bash
./run_md2pdf.sh update
```

### Reconstruir el entorno desde cero
```bash
./run_md2pdf.sh reinstall
```

### Ejecutar conversiones

```bash
# Conversión básica (todos los Markdown a PDF por defecto)
./run_md2pdf.sh convert

# Convertir archivo específico a PDF
./run_md2pdf.sh convert -f documento.md

# Convertir archivo específico a DOCX
./run_md2pdf.sh convert -f documento.md --docx

# Generar ambos formatos (PDF y DOCX)
./run_md2pdf.sh convert -f documento.md --pdf --docx

# Convertir todos los Markdown de una carpeta
./run_md2pdf.sh convert -d /ruta/a/carpeta

# Convertir directorio completo a ambos formatos
./run_md2pdf.sh convert -d /ruta/a/carpeta --pdf --docx
```

## 📁 Estructura del Proyecto

```
markdown2Pdf/
├── .venv/                    # Entorno Poetry (generado automáticamente)
├── simple_converter.py       # Conversor Markdown → PDF/DOCX usando Pandoc
├── run_md2pdf.sh             # Script de gestión y ejecución
├── pandoc-highlight.theme    # Tema de resaltado de código personalizado
├── requirements.txt          # Compatibilidad legacy (no necesario con Poetry)
├── pyproject.toml            # Configuración del proyecto (Poetry)
├── poetry.lock               # Versionado exacto de dependencias
└── README.md                 # Esta documentación
```

## ⚙️ Características Avanzadas

### Conversión Múltiple de Formatos
- **PDF con WeasyPrint**: Salida profesional usando el motor WeasyPrint vía Pandoc
- **DOCX nativo**: Documentos de Word completamente editables
- **Generación simultánea**: Crea PDF y DOCX en una sola ejecución
- **Formato por defecto**: PDF si no se especifica otro formato

### Procesamiento Inteligente
- **Conversión recursiva** de todos los Markdown en un directorio y subdirectorios
- **Modo archivo único** para convertir solo un `.md` específico
- **Detección automática** de archivos Markdown (extensiones `.md`, `.markdown`)
- **Preservación de estructura** de carpetas en la salida

### Resaltado de Código Avanzado
- **Tema personalizado** administrado por Pandoc (`pandoc-highlight.theme`)
- **Resaltado de sintaxis** automático para múltiples lenguajes
- **Compatibilidad con bloques de código** delimitados y con indentación
- **Exportación consistente** entre PDF y DOCX

### Gestión de Dependencias
- **Environment aislado con Poetry** que no interfiere con otras instalaciones Python
- **WeasyPrint integrado** para renderizado PDF de alta calidad
- **Pandoc como motor principal** para máxima compatibilidad y calidad

## 📄 Ejemplos de Uso Específicos

### Conversiones Básicas
```bash
# Convertir todos los Markdown encontrados (modo por defecto)
./run_md2pdf.sh convert

# Solo generar PDFs de todos los archivos
./run_md2pdf.sh convert --pdf

# Solo generar DOCX de todos los archivos  
./run_md2pdf.sh convert --docx
```

### Conversiones de Archivos Específicos
```bash
# Un archivo a PDF
./run_md2pdf.sh convert -f ejercicio1.md

# Un archivo a DOCX
./run_md2pdf.sh convert -f ejercicio1.md --docx

# Un archivo a ambos formatos
./run_md2pdf.sh convert -f ejercicio1.md --pdf --docx
```

### Conversiones de Directorios
```bash
# Todos los Markdown de una carpeta a PDF
./run_md2pdf.sh convert -d ../../../ejercicios/enunciados_sinteticos

# Todos los Markdown de una carpeta a ambos formatos
./run_md2pdf.sh convert -d ../../../ejercicios/enunciados_sinteticos --pdf --docx

# Procesar carpeta específica con ruta absoluta
./run_md2pdf.sh convert -d /home/usuario/documentos/markdown --docx
```

## 📄 Salida y Organización

Cada archivo `*.md` genera los formatos solicitados (`.pdf`, `.docx`) en el mismo directorio que el original, manteniendo la estructura de carpetas:

**Ejemplos de salida:**
- Input: `ejercicios/enunciados_sinteticos/tema1.md`
- Output PDF: `ejercicios/enunciados_sinteticos/tema1.pdf`
- Output DOCX: `ejercicios/enunciados_sinteticos/tema1.docx`

**Estructura preservada:**
```
ejercicios/
├── enunciados_sinteticos/
│   ├── tema1.md
│   ├── tema1.pdf          # ← Generado
│   ├── tema1.docx         # ← Generado
│   ├── tema2.md
│   ├── tema2.pdf          # ← Generado
│   └── tema2.docx         # ← Generado
```

## 🔧 Verificación y Troubleshooting

### Verificar instalación
```bash
# Verificar dependencias del sistema y Poetry
./run_md2pdf.sh install

# Mostrar ayuda completa del conversor
./run_md2pdf.sh help
```

### Dependencias del sistema
El script verifica automáticamente:
- **Pandoc**: Motor principal de conversión
- **WeasyPrint**: Motor PDF (instalado vía Poetry)
- **Python**: Entorno de ejecución (gestionado por Poetry)

## ✨ Estado del Proyecto

Proyecto completamente funcional y listo para usar como herramienta de producción en el flujo de trabajo del proyecto aedi-agent. Ideal para generar documentación final, ejercicios para distribución, y materiales de estudio en formatos profesionales.
