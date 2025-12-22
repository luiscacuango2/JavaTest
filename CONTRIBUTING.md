# **Guía de Contribución**

¡Hola! Primero que nada, gracias por tomarte el tiempo de visitar este proyecto.

**javatest** nació como un espacio para dominar el desarrollo robusto en Java mediante pruebas unitarias y código limpio. Creemos que la mejor forma de aprender es colaborando, por lo que cualquier mejora, por pequeña que sea (incluso corregir un error ortográfico en la documentación), es sumamente valiosa.

> "El buen código no se escribe a la primera, se refina en comunidad."

---

### **Cómo empezar**
No necesitas ser un experto para contribuir. Aquí tienes algunas ideas:
1.  **Reportar Errores:** Si encuentras un bug, por favor abre un *Issue* describiendo el problema, los pasos para reproducirlo y el comportamiento esperado.
2.  **Sugerir Funcionalidades:** Las nuevas ideas son bienvenidas. Abre un *Issue* para discutir la propuesta antes de empezar a programar.
3. **Añadir nuevos tests:** ¿Crees que nos faltó algún caso extremo en `DateUtil` o `FizzBuzz`? ¡Añádelo!
4. **Mejorar algoritmos:** Si ves una forma más eficiente o legible de resolver un problema, cuéntanosla.
5. **Documentación:** Ayúdanos a que el README o los comentarios sean más claros para quienes están empezando.

---

### **Proceso de Desarrollo**

Para contribuir con código, sigue este flujo de trabajo:

1.  **Fork del Proyecto:** Crea tu propia copia del repositorio en tu cuenta de GitHub.
2.  **Crear una Rama:** Crea una rama para tu mejora siguiendo la convención:
    * `feature/nombre-de-la-mejora` para nuevas utilidades.
    * `fix/descripcion-del-error` para correcciones.
3.  **Desarrollo y Testing:** * Escribe código limpio y modular.
    * **Obligatorio:** Cada nueva funcionalidad debe incluir sus respectivas pruebas unitarias en **JUnit 5**.
    * Asegúrate de que todos los tests pasen ejecutando `mvn test`.
4.  **Commits:** Usa mensajes descriptivos (preferiblemente siguiendo [Conventional Commits](https://www.conventionalcommits.org/)).

---

### **Requisitos de Pull Request (PR)**

Al enviar un PR, asegúrate de:

* La rama debe estar actualizada con el `master` original.
* El código debe compilar correctamente mediante `mvn clean package`.
* No debe haber advertencias críticas en el análisis de código.
* Describe detalladamente los cambios realizados en la descripción del PR.

---

### **Código de Conducta**

Se espera un trato respetuoso y profesional en todos los comentarios y discusiones del repositorio.

---

¡Gracias por ayudar a mejorar este proyecto!
**Luis Cacuango** - [luiscacuango2084@gmail.com](mailto:luiscacuango2084@gmail.com)