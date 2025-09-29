## Normas generales
- No debes gastar muchas palabeas en explicarme un resumen amplio sobre de que van los ejercicios. Simplemente ve al grano y genera el contenido que te han pedido. Lo que si necesito es una descripcion paso a paso de lo que vas haciendo y lo que queda por hacer para no perder el hilo

-  En **/base_de_conocimiento/enunciados**: Habrá ejercicios originales y ejemplos de enunciados que puedes tomar como referencia para crear nuevos ejercicios en la carpeta **/ejercicios/enunciados_sinteticos**. No debes copiar ejemplos concretos y exactos de estos materiales, pero si puedes basarte en su estilo y estructura para generar nuevos enunciados.
-  En **/base_de_conocimiento/enunciados** si hay PDFs que quieras consultar puedes usar los conversores de la carpeta **/ScriptsAuxiliares/conversores** para convertirlos a markdown y así poder leerlos. NUNCA continuarás con los siguientes pasos si no puedes leer los ficheros de esta carpeta en markdown. Primero lo arreglas luego continúas con la tarea.
-  En **/ejercicios_resueltos**: Soluciones completas de referencia hechas por los docentes. Los ejercicios deben seguir el estilo de estos ficheros, pero nunca reutilizarlos como ejemplos concretos. Pero si para inspirarte con ideas o para extraer pistas


## Conversion a PDF, DOCX u otros formatos

- En **/ScriptsAuxiliares**: Tiene utilidades de apoyo. Herramientas como conversores PDF to Markdown o PDF to Markdown. Debes usarlas cuando haya un PDF que quieras consultar. Estos conversores tienen su propio entorno .venv python gestionado con poetry. En caso de que no existan los entornos o haya un problema con alguna dependencia debes crearlos con los scripts de instalación sh existentes. 
- Consulta siempre como funcionan para hacer la tarea bien. Usa los scripts sin ningun argumento sh para ver las opciones disponibles. Da preferencia a convertir todos los ficheros de una carpeta que a convertir uno a uno.

## Normas obligatorias del asistente

- En **/ejercicios/enunciados_sinteticos**: Generarás una carpeta con el enunciado en formato markdown y además generarás el PDF correspondiente con alguno de los conversores existentes que lo permita. Aquí la IA solo genera enunciados, nunca soluciones ni pistas. Si hay ficheros markdown md vacíos elimínalos. No elimines los ficheros empty necesarios para git.
- NUNCA revisaras que hay en **/ejercicios/enunciados_sinteticos/*** para recoger ideas o ejemplos. Siempre seguirás únicamente los ejemplos en *asistente-asignatura/base_de_conocimiento/enunciados*. 
- En **/ejercicios/alumno**: SIEMPRE crearás una carpeta para el ejercicio propuesto con los esqueletos de clases y funciones que el alumno debe completar. No debes proponer el código de la solución. Simplemente un esqueleto con comentarios TODOs de lo que el alumno debe hacer en cada parte del código.
- NUNCA debes hacer esto si el conversor no está funcionando correctamente. NUNCA vas a proceder directamente a crear el ejercicio basándome en las reglas establecidas y  NUNCA vas a usar tu conocimiento sobre recursividad y estructuras lineales. En caso de que falle el conversor o no esté disponible, siempre debes intentarlo arreglar tratando de priorizar la conversion de la fuente de conocimiento para continuar con la tarea. 

## Atencion!
- Tu trabajo no acaba hasta que tengas estas 3 salidas completas:
  1. Enunciado en markdown
  2. PDF del enunciado
  3. Esqueleto de solución en la carpeta alumno