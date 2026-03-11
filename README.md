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
- **Ofrecer apoyo guiado** sin dar soluciones directas
- **Mantener un banco de ejercicios** categorizado por dificultad

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

### 📚 Gestión de Conocimiento
- Base de conocimiento organizada por temas y dificultad

### 🎯 Enfoque Pedagógico
- **Aprendizaje guiado**: Proporciona pistas, no soluciones
- **Metodología activa**: Fomenta el descubrimiento autónomo
- **Evaluación formativa**: Feedback constructivo y personalizado

## 📁 Estructura del Proyecto

```
aedi-agent/
├── README.md                          # Este archivo
├── AGENTS.md                          # Configuración de agentes
├── asistente-asignatura/              # Núcleo del sistema educativo
│   ├── base_de_conocimiento/          # Repositorio de materiales
│   │   ├── asignatura/               # Información académica oficial
│   │   ├── enunciados/               # Ejercicios originales
├   │   ├── librerías/                # Librerías con TADs de la asignatura
│   │   └── restricciones/            # Reglas del sistema
│   ├── ejercicios/                   # Banco de ejercicios
│   │   ├── alumno/                   # Área de trabajo estudiantil
│   │   └── enunciados_sinteticos/    # Ejercicios generados por IA

```

### 🔍 Descripción de Carpetas Clave

#### 📖 `/asistente-asignatura/base_de_conocimiento`
Repositorio central de materiales educativos:
- **`/asignatura`**: Guía docente y información académica oficial
- **`/enunciados`**: Ejercicios originales y ejemplos de referencia
- **`/restricciones`**: Reglas de comportamiento del sistema

#### 🎯 `/asistente-asignatura/ejercicios`
Gestión del banco de ejercicios:
- **`/enunciados_sinteticos`**: Ejercicios generados automáticamente
- **`/alumno`**: Espacio de trabajo con pistas y esqueletos de código 


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

- **🔗 Estructuras Dinámicas**: Listas enlazadas, nodos centinela
- **📚 TADs Lineales**: Pilas, colas, listas
- **🔍 Algoritmos de Búsqueda**: Lineal, binaria, hashing
- **🔄 Recursividad**: Diseño y análisis de algoritmos recursivos
- **📋 Algoritmos de Ordenación**: Inserción, selección, quicksort, mergesort

