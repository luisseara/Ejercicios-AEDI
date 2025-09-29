# AEDI Agent 🤖

**Asistente educativo inteligente para la asignatura Algoritmos y Estructuras de Datos I**

Un sistema de IA especializado diseñado para apoyar el proceso de enseñanza-aprendizaje en la asignatura de Algoritmos y Estructuras de Datos I del Grado en Ingeniería Informática.

[![Universidad de Vigo](https://img.shields.io/badge/Universidad-Vigo-blue.svg)]()
[![Curso](https://img.shields.io/badge/Curso-1º%20Grado%20Informática-green.svg)]()
[![Cuatrimestre](https://img.shields.io/badge/Cuatrimestre-2º-orange.svg)]()

## 📋 Tabla de Contenidos

- [Descripción](#descripción)
- [Características](#características)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Instalación](#instalación)
- [Uso](#uso)
- [Metodología Pedagógica](#metodología-pedagógica)
- [Herramientas Auxiliares](#herramientas-auxiliares)
- [Contribuir](#contribuir)
- [Licencia](#licencia)

## 🎯 Descripción

AEDI Agent es un asistente educativo especializado que **NO es un proyecto de software tradicional**, sino una herramienta pedagógica diseñada para:

- **Generar ejercicios personalizados** de algoritmos y estructuras de datos
- **Proporcionar materiales de estudio** organizados por temas
- **Ofrecer apoyo guiado** sin dar soluciones directas
- **Mantener un banco de ejercicios** categorizado por dificultad
- **Facilitar la conversión** entre formatos de documentos educativos

### 🎓 Contexto Académico

- **Asignatura**: Algoritmos y Estructuras de Datos I (O06G151V01107)
- **Titulación**: Grado en Ingeniería Informática
- **Universidad**: Universidad de Vigo
- **Créditos**: 6 ECTS
- **Curso**: 1º, 2º Cuatrimestre

## ✨ Características

### 🧠 Generación Inteligente de Contenido
- Creación automática de ejercicios basados en patrones pedagógicos
- Adaptación del nivel de dificultad según el progreso del estudiante
- Generación de enunciados en formato Markdown y PDF

### 📚 Gestión de Conocimiento
- Base de conocimiento organizada por temas y dificultad
- Materiales teóricos estructurados
- Ejercicios resueltos de referencia (solo para docentes)

### 🎯 Enfoque Pedagógico
- **Aprendizaje guiado**: Proporciona pistas, no soluciones
- **Metodología activa**: Fomenta el descubrimiento autónomo
- **Evaluación formativa**: Feedback constructivo y personalizado

### 🛠️ Herramientas de Conversión
- **PDF → Markdown**: Conversión inteligente de documentos
- **Markdown → PDF**: Generación de documentos profesionales
- Detección automática de bloques de código

## 📁 Estructura del Proyecto

```
aedi-agent/
├── README.md                          # Este archivo
├── AGENTS.md                          # Configuración de agentes
├── asistente-asignatura/              # Núcleo del sistema educativo
│   ├── README.md                      # Guía de uso del asistente
│   ├── agent_scripts/                 # Scripts de automatización
│   ├── base_de_conocimiento/          # Repositorio de materiales
│   │   ├── asignatura/               # Información académica oficial
│   │   ├── diagramas/                # Esquemas y gráficos
│   │   ├── ejercicios_resueltos/     # Soluciones de referencia
│   │   ├── enunciados/               # Ejercicios originales
│   │   ├── restricciones/            # Reglas del sistema
│   │   └── teoria/                   # Contenidos teóricos
│   ├── ejercicios/                   # Banco de ejercicios
│   │   ├── alumno/                   # Área de trabajo estudiantil
│   │   ├── enunciados_sinteticos/    # Ejercicios generados por IA
│   │   └── resueltos/                # Soluciones estudiantiles
│   └── scriptsAuxiliares/            # Utilidades de apoyo
│       └── conversores/              # Herramientas de conversión
│           ├── pdf2Markdown/         # Conversor PDF → MD
│           └── markdown2Pdf/         # Conversor MD → PDF
```

### 🔍 Descripción de Carpetas Clave

#### 📖 `/base_de_conocimiento`
Repositorio central de materiales educativos:
- **`/asignatura`**: Guía docente y información académica oficial
- **`/teoria`**: Apuntes y contenidos teóricos organizados
- **`/enunciados`**: Ejercicios originales y ejemplos de referencia
- **`/ejercicios_resueltos`**: Soluciones modelo (solo consulta docente)
- **`/restricciones`**: Reglas de comportamiento del sistema

#### 🎯 `/ejercicios`
Gestión del banco de ejercicios:
- **`/enunciados_sinteticos`**: Ejercicios generados automáticamente
- **`/alumno`**: Espacio de trabajo con pistas y esqueletos de código
- **`/resueltos`**: Soluciones desarrolladas por estudiantes

## 🚀 Instalación

### Prerrequisitos
- Python 3.9+
- Poetry (gestión de dependencias)
- Pandoc (conversión de documentos)

### Configuración Inicial

1. **Clonar el repositorio**:
```bash
git clone https://dev.sing-group.org/gitlab/maped/aedi-agent.git
cd aedi-agent
```

2. **Configurar herramientas de conversión**:
```bash
# Instalar conversor PDF → Markdown
cd asistente-asignatura/scriptsAuxiliares/conversores/pdf2Markdown
poetry install

# Instalar conversor Markdown → PDF  
cd ../markdown2Pdf
poetry install
```

3. **Verificar instalación**:
```bash
# Probar conversores
./run_pdf2md.sh --help
./run_md2pdf.sh --help
```

## 💡 Uso

### Para Estudiantes

#### 🎓 Obtener Ejercicios Personalizados
```bash
# El asistente genera automáticamente ejercicios basados en tu progreso
# Los ejercicios aparecerán en /ejercicios/enunciados_sinteticos/
```

#### 🔍 Obtener Ayuda con Ejercicios
```bash
# Consulta la carpeta /ejercicios/alumno/ para:
# - Esqueletos de código con TODOs
# - Pistas y preguntas guía
# - Descomposición de problemas complejos
```

### Para Docentes

#### 📝 Generar Nuevos Ejercicios
El sistema utiliza la base de conocimiento para crear ejercicios únicos que mantienen el rigor pedagógico pero evitan la repetición exacta de ejemplos existentes.

#### 🔄 Convertir Materiales
```bash
# Convertir PDFs a Markdown para análisis
cd scriptsAuxiliares/conversores/pdf2Markdown
./run_pdf2md.sh /ruta/al/archivo.pdf

# Generar PDFs desde Markdown
cd ../markdown2Pdf  
./run_md2pdf.sh /ruta/al/archivo.md
```

## 🎓 Metodología Pedagógica

### Principios Fundamentales

1. **🚫 No Soluciones Directas**
   - El sistema proporciona pistas, no respuestas completas
   - Fomenta el pensamiento crítico y la resolución autónoma

2. **📈 Aprendizaje Progresivo**
   - Ejercicios adaptados al nivel de conocimiento actual
   - Incremento gradual de la complejidad

3. **🔄 Feedback Constructivo**
   - Análisis de errores comunes
   - Sugerencias de mejora personalizadas

4. **🎯 Enfoque en Competencias**
   - Desarrollo de habilidades de abstracción
   - Fortalecimiento del razonamiento algorítmico

### Temas Cubiertos

- **📊 Análisis de Complejidad**: Notaciones asintóticas y eficiencia
- **🔗 Estructuras Dinámicas**: Listas enlazadas, nodos centinela
- **📚 TADs Lineales**: Pilas, colas, listas
- **🔍 Algoritmos de Búsqueda**: Lineal, binaria, hashing
- **🔄 Recursividad**: Diseño y análisis de algoritmos recursivos
- **📋 Algoritmos de Ordenación**: Inserción, selección, quicksort, mergesort
- **🧪 Verificación**: Fundamentos de testing con JUnit

## 🛠️ Herramientas Auxiliares

### Conversores de Documentos

#### PDF → Markdown
- **Tecnología**: Docling para análisis inteligente
- **Características**: Detección automática de bloques de código
- **Uso**: Migración de materiales existentes

#### Markdown → PDF
- **Tecnología**: Pandoc con templates personalizados
- **Características**: Formato profesional para entrega
- **Uso**: Generación de ejercicios para exámenes

### Gestión de Entornos
- Cada herramienta tiene su propio entorno Python aislado
- Gestión de dependencias con Poetry
- Scripts de instalación automatizados

## 📋 Reglas de Programación

### Estándares de Código Java
- **Idioma**: Código y comentarios en inglés
- **Modificadores**: Acceso explícito en todos los métodos y atributos
- **Encapsulación**: Atributos siempre privados con getters/setters
- **Restricciones**: No usar `break` (excepto switch) ni `return void`
- **Versión**: Java 21 (API estándar únicamente)

### Estructura de Clases
```java
public class ExampleClass {
    private int privateAttribute;
    
    public int getPrivateAttribute() {
        return this.privateAttribute;
    }
    
    public void setPrivateAttribute(int privateAttribute) {
        this.privateAttribute = privateAttribute;
    }
}
```

## 🤝 Contribuir

### Para Educadores
1. **Añadir Materiales**: Contribuir con nuevos ejercicios o teoría
2. **Mejorar Restricciones**: Actualizar reglas pedagógicas
3. **Reportar Issues**: Identificar problemas en la generación de contenido

### Para Desarrolladores
1. **Mejorar Herramientas**: Optimizar conversores y scripts
2. **Añadir Funcionalidades**: Nuevas utilidades educativas
3. **Documentación**: Mantener y mejorar la documentación

### Proceso de Contribución
```bash
# 1. Fork del repositorio
# 2. Crear rama feature
git checkout -b feature/nueva-funcionalidad

# 3. Desarrollar y commitear
git commit -m "feat: descripción de la nueva funcionalidad"

# 4. Push y merge request
git push origin feature/nueva-funcionalidad
```

## 📞 Soporte

- **Coordinadora**: Rosalía Laza Fidalgo (rlaza@uvigo.es)
- **Plataforma**: [Moovi - Universidad de Vigo](http://moovi.uvigo.gal)
- **Issues**: Usar el sistema de issues de GitLab para reportar problemas

## 🛣️ Roadmap

### Versión Actual (v1.0)
- ✅ Sistema base de generación de ejercicios
- ✅ Conversores PDF/Markdown
- ✅ Base de conocimiento inicial

### Próximas Funcionalidades
- 🔄 Integración con sistemas de evaluación automática
- 📊 Dashboard de progreso estudiantil
- 🤖 IA más avanzada para personalización
- 📱 Interfaz web responsive

## 📄 Licencia

Este proyecto está desarrollado para uso educativo en el contexto de la Universidad de Vigo. 

## 🏆 Reconocimientos

- **Universidad de Vigo** - Departamento de Informática
- **Equipo Docente** - Por la definición de requisitos pedagógicos
- **SING Group** - Por el soporte técnico y metodológico

---

**🎓 AEDI Agent - Transformando la educación en algoritmos y estructuras de datos**

*Desarrollado con ❤️ para estudiantes de Ingeniería Informática*
