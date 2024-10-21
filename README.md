# Sistema de Administración de Exámenes

## Descripción
Este proyecto implementa un sistema de administración de exámenes basado en consola, desarrollado en Java. Permite crear, cargar, y realizar exámenes con diferentes tipos de preguntas: Verdadero/Falso, Selección Múltiple, y Respuesta Corta.

## Características
- Creación de exámenes personalizados
- Carga de exámenes desde archivos
- Tres tipos de preguntas: Verdadero/Falso, Selección Múltiple, y Respuesta Corta
- Interfaz de consola intuitiva
- Cálculo automático de resultados y porcentajes

## Requisitos del Sistema
- Java JDK 8 o superior
- Cualquier sistema operativo compatible con Java

## Instalación
1. Clona este repositorio:
   ```
   git clone https://github.com/tu-usuario/sistema-administracion-examenes.git
   ```
2. Navega al directorio del proyecto:
   ```
   cd sistema-administracion-examenes
   ```
3. Compila el proyecto:
   ```
   javac *.java
   ```

## Uso
Para ejecutar el programa, usa el siguiente comando en la terminal:
```
java ExamDemo
```

Sigue las instrucciones en pantalla para navegar por el menú y utilizar las diferentes funcionalidades del sistema.

## Estructura del Proyecto
El proyecto está organizado en varios archivos Java, cada uno con una responsabilidad específica:

- `ExamDemo.java`: 
  - Punto de entrada principal del programa.
  - Contiene el método `main()` que inicia la aplicación.

- `InterfazConsola.java`: 
  - Maneja la interfaz de usuario en consola.
  - Implementa el menú principal y submenús.
  - Coordina la interacción entre el usuario y las demás clases del sistema.

- `CreadorExamen.java`: 
  - Facilita la creación de nuevos exámenes.
  - Permite al usuario añadir diferentes tipos de preguntas al examen.
  - Maneja la lógica para crear cada tipo de pregunta.

- `Exam.java`: 
  - Representa un examen completo.
  - Almacena y gestiona una colección de preguntas.
  - Implementa métodos para agregar preguntas, dar el examen y calcular resultados.
  - Proporciona funcionalidad para guardar y cargar exámenes desde archivos.

- `Pregunta.java`: 
  - Clase abstracta base para todos los tipos de preguntas.
  - Define la estructura común para todas las preguntas (texto, peso).
  - Declara el método abstracto `buscar()` que cada tipo de pregunta debe implementar.

- `TFpregunta.java`: 
  - Implementa preguntas de Verdadero/Falso.
  - Extiende la clase `Pregunta`.
  - Implementa la lógica específica para preguntas de Verdadero/Falso en el método `buscar()`.

- `Selec_Mul_Pregunta.java`: 
  - Implementa preguntas de Selección Múltiple.
  - Extiende la clase `Pregunta`.
  - Maneja múltiples opciones y la lógica para seleccionar una respuesta.

- `Resp_Cortas_Pregunta.java`: 
  - Implementa preguntas de Respuesta Corta.
  - Extiende la clase `Pregunta`.
  - Permite al usuario ingresar una respuesta textual corta.

Esta estructura sigue los principios de la Programación Orientada a Objetos, utilizando herencia (`Pregunta` como clase base) y encapsulación (cada clase con sus responsabilidades específicas). La separación de responsabilidades facilita el mantenimiento y la extensión del sistema en el futuro.

## Autores
- Ignacia Miranda
- Adolfo Toledo

## Agradecimientos
- Universidad de La Serena
- Mg. Gonzalo Honores, profesor del curso de Programación Orientada a Objetos con Java
