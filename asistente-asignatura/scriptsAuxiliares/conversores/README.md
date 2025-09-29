# Converters

Este directorio contiene diversas utilidades de conversión para el proyecto asistente educativo. Cada conversor está diseñado como una herramienta independiente con su propio entorno Python y dependencias.

## Requisitos de Documentación

**Todos los conversores deben estar documentados en este archivo README** con la siguiente información:
- **Propósito**: Descripción clara de lo que hace el conversor
- **Casos de uso**: Cuándo y por qué usar este conversor
- **Ejemplos de uso**: Ejemplos de línea de comandos con escenarios comunes
- **Entrada/Salida**: Formatos de archivo soportados y resultados esperados

## Estructura

Cada subdirectorio de conversor contiene:
- Un proyecto Python completo con su propio `pyproject.toml`
- Un entorno virtual aislado (`.venv/`)
- Un script shell para ejecución fácil (`run_*.sh`)
- Sección de documentación en este README

## Conversores Disponibles

### pdf2Markdown/
**Propósito**: Convierte archivos PDF a formato Markdown con detección inteligente de bloques de código utilizando Docling para análisis y procesamiento de contenido educativo.

**Casos de uso**:
- Convertir materiales de estudio en PDF a formato Markdown editable
- Extraer contenido de documentos académicos para integración en base de conocimiento
- Procesar PDFs de ejercicios de programación con formateo de código adecuado
- Preparar contenido PDF para análisis digital y búsqueda
- Migrar documentación existente de PDF a formato colaborativo


**Ejemplos de uso**:
```bash
./run_pdf2md.sh help       # Mostrar ayuda
```

### markdown2Pdf/
**Propósito**: Convierte archivos Markdown a formato PDF y/o DOCX usando Pandoc y WeasyPrint para crear materiales educativos profesionales y documentación distribuible.

**Casos de uso**:
- Generar versiones PDF de enunciados de ejercicios para distribución
- Crear materiales de estudio imprimibles desde contenido Markdown
- Producir documentación formal desde notas Markdown
- Generar documentos Word editables para colaboración
- Exportar contenido web a formatos de documento tradicionales

**Ejemplos de uso**:
```bash
./run_md2pdf.sh help       # Mostrar ayuda
```
