# PDF to Markdown Converter

Un conversor Python específico para el proyecto que convierte archivos PDF a formato Markdown utilizando [Docling](https://github.com/DS4SD/docling). Este proyecto utiliza [Poetry](https://python-poetry.org/) para gestionar un entorno virtual autocontenido dentro de la carpeta `pdf2Markdown`.

## ✅ Estado de Conversión Verificado

**Successfully converted all 3 PDF files:**
- `guia_docente_asignatura.pdf` → `guia_docente_asignatura.md`
- `Ejercicios de TADs.pdf` → `Ejercicios de TADs.md`  
- `Ejercicios Ordenación y Búsqueda.pdf` → `Ejercicios Ordenación y Búsqueda.md`

## 🚀 Uso Rápido

### Preparar el entorno (una sola vez)
```bash
cd asistente-asignatura/scriptsAuxiliares/conversores/pdf2Markdown
./run_pdf2md.sh install
```

### Actualizar dependencias según `poetry.lock`
```bash
./run_pdf2md.sh update
```

### Reconstruir el entorno desde cero
```bash
./run_pdf2md.sh reinstall
```

### Ejecutar la conversión
```bash
# Convierte todos los PDFs en base_de_conocimiento (modo por defecto)
./run_pdf2md.sh convert

# Convierte un archivo específico
./run_pdf2md.sh convert -f documento.pdf

# Convierte todos los PDFs de una carpeta (incluye subdirectorios)
./run_pdf2md.sh convert -d /ruta/a/carpeta
```

## 📁 Estructura del Proyecto

```
pdf2Markdown/
├── .venv/               # Entorno Poetry (generado automáticamente)
├── simple_converter.py  # Conversor principal usando Docling
├── run_pdf2md.sh        # Script de gestión y ejecución
├── requirements.txt     # Compatibilidad legacy (no es necesario con Poetry)
├── pyproject.toml       # Configuración del proyecto (Poetry)
├── poetry.lock          # Versionado exacto de dependencias
└── README.md            # Esta documentación
```

## 🔧 Entorno gestionado con Poetry

Este proyecto incluye su propio entorno virtual (`.venv/`) gestionado con Poetry:
- **Es autocontenido** - No interfiere con otros proyectos Python.
- **Se crea y mantiene** mediante los comandos `install`, `update` y `reinstall` del script.
- **Incluye dependencias oficiales de Docling** para garantizar la conversión estable de PDF a Markdown.

## ⚙️ Características Avanzadas

### Detección Automática de Código
- **Reconocimiento inteligente** de bloques de código en múltiples lenguajes
- **Lenguajes soportados**: Java, Python, C++, C, JavaScript, SQL, y más
- **Formateo automático** con bloques de código delimitados (```)
- **Preservación de estructura** e indentación del código original

### Modos de Conversión
1. **Modo por defecto**: Convierte recursivamente todos los PDFs en `base_de_conocimiento/`
2. **Archivo único**: Convierte un PDF específico con `-f archivo.pdf`
3. **Directorio específico**: Convierte todos los PDFs de una carpeta con `-d carpeta/`

### Funcionalidades Técnicas
- **Descubrimiento recursivo** de PDFs en directorios y subdirectorios
- **Conversión por lotes** de múltiples archivos
- **Preserva estructura** - outputs `.md` en las mismas carpetas que los PDFs origen
- **Detección inteligente de lenguajes** basada en patrones y palabras clave
- **Manejo robusto de errores** con reportes detallados
- **Environment aislado** que no afecta otras instalaciones Python

## 📄 Ejemplos de Uso

```bash
# Conversión básica (todos los PDFs en base_de_conocimiento)
./run_pdf2md.sh convert

# Convertir un archivo específico
./run_pdf2md.sh convert -f ../../../base_de_conocimiento/enunciados/ejercicio1.pdf

# Convertir todos los PDFs de una carpeta
./run_pdf2md.sh convert -d ../../../base_de_conocimiento/enunciados

# Obtener ayuda del conversor
./run_pdf2md.sh help
```

## 📄 Salida

El conversor crea archivos `.md` en los mismos directorios que los PDFs fuente, con el mismo nombre pero extensión `.md`.

**Ejemplo:**
- Input: `base_de_conocimiento/asignatura/guia_docente_asignatura.pdf`
- Output: `base_de_conocimiento/asignatura/guia_docente_asignatura.md`

## 🔍 Detección de Código

El conversor incluye patrones avanzados para detectar y formatear código:

### Java
- Detecta clases, interfaces, métodos, imports
- Reconoce palabras clave: `public`, `private`, `extends`, `implements`
- Identifica estructuras: `ArrayList`, `HashMap`, `System.out.println`

### Python  
- Detecta funciones, clases, imports, control de flujo
- Reconoce palabras clave: `def`, `class`, `import`, `for`, `while`
- Identifica estructuras específicas de Python

### C/C++
- Detecta includes, namespaces, funciones main
- Reconoce palabras clave: `#include`, `using namespace`, `cout`, `cin`
- Identifica estructuras de memoria y tipos

## ✨ Completamente Funcional

Este environment ha sido probado y verificado como completamente funcional para el proyecto aedi-agent, proporcionando conversiones precisas y manteniendo la estructura del código fuente en los documentos convertidos.
