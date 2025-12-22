# **javatest**

![Java](https://img.shields.io/badge/Java-25%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-3.8.7%2B-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![JUnit 5](https://img.shields.io/badge/JUnit-5.12.2-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)

## **Descripción**
Este repositorio es un ecosistema de aprendizaje y desarrollo en Java. Contiene implementaciones de algoritmos clásicos, gestión de lógica de negocio y pruebas de integración, sirviendo como base sólida para despliegue de componentes escalables.

---

### **Utilidades y Cobertura de Tests**

El proyecto implementa **TDD (Test Driven Development)** y asegura la calidad mediante los siguientes módulos:

| Componente | Clase | Casos de Prueba | Core |
| :--- | :--- | :--- | :--- |
| **Validación de Passwords** | `PasswordUtil` | Niveles de seguridad y longitud. | JUnit 5 |
| **Fechas Bisiestas** | `DateUtil` | Lógica de divisibilidad 4/100/400. | JUnit 5 |
| **Números Romanos** | `RomanNumerals` | Conversión y casos sustractivos (IV, IX). | JUnit 5 |
| **Procesador de Pagos** | `PaymentProcessor` | Simulación de pasarelas con Mocks. | Mockito |
| **Algoritmos Clásicos** | `FizzBuzz` | Divisibilidad múltiple y lógica condicional. | JUnit 5 |
| **Cálculo de Precios** | `PriceCalculator` | Acumulación y descuentos porcentuales. | JUnit 5 |
| **Lógica de Strings** | `StringUtil` | Manipulación, repetición y manejo de `null`. | JUnit 5 |

---

### **Stack Técnico**
* **Lenguaje:** Java 25 (utilizando las últimas funciones de la JVM).
* **Build Tool:** Maven 3.8.7+.
* **Testing:** JUnit 5 (Jupiter) & Mockito 5.
* **IDE:** `IntelliJ IDEA 2025.2.5`.

### **Instalación y Uso**

1. **Clonar y navegar:**
   ```bash
   git clone https://github.com/luiscacuango2/JavaTest.git
   cd javatest
    ```
2. **Ciclo de vida de Maven:**
   ```bash
    mvn clean package  # Compilar y empaquetar
    mvn test           # Ejecutar suite de pruebas unitarias
    ```
3. **Ejecutar la aplicación**
    ```bash
    java -jar target/javatest-1.0-SNAPSHOT.jar
    ```
> **Nota técnica (Java 25):** Para evitar advertencias de carga dinámica durante los tests, el proyecto está configurado para habilitar `-XX:+EnableDynamicAgentLoading` en el entorno de pruebas.

### **Estructura del proyecto**
```
javatest/
├── src/main/java/         # Lógica de negocio (Utilidades, Pagos, etc.)
├── src/main/resources/    # Configuraciones (application.properties)
├── src/test/java/         # Suites de JUnit 5 y configuraciones de Mockito
└── pom.xml                # Gestión de dependencias y plugins de compilación
```
### **Dependencias**

- **org.mockito:mockito-core:5.21.0** (scope: `test`)  
  Biblioteca para crear mocks y stubs en pruebas. En este `pom.xml` además se referencia como `-javaagent` en la configuración de `maven-surefire-plugin` (revisa la ruta si hay problemas).

- **org.junit.jupiter:junit-jupiter:5.12.2** (scope: `test`)  
  JUnit 5 (Jupiter) — API moderna para pruebas. Para ejecutarlo correctamente se recomienda usar `maven-surefire-plugin` versión compatible (ya configurado en el `pom.xml`).

---

### **Buenas Prácticas Implementadas**

#### **Calidad de Código**
* **Clean Code:** Uso de nombres de métodos descriptivos y anotaciones `@DisplayName` en tests para reportes legibles.
* **Modularidad:** Separación clara de responsabilidades en paquetes específicos: `util`, `discounts` y `payments`.
* **Documentación:** Implementación de **Swagger/OpenAPI** para la capa de servicios y uso de **Javadoc** para la lógica interna del negocio.

#### **Infraestructura y Git**
* **Gitflow:** Estructura de trabajo basada en ramas `feature/*` y `hotfix/*` para asegurar un desarrollo organizado y estable.
* **CI/CD:** Pipeline configurado en **GitHub Actions** para validar la compilación y ejecución de tests en cada *Pull Request*.
* **Seguridad:** Monitoreo y escaneo automático de vulnerabilidades en dependencias mediante **Dependabot**.

---

### **Contribuciones y Licencia**
¡Las contribuciones son lo que hacen a la comunidad increíble! Si deseas colaborar, sigue estos pasos:

1. **Haz un Fork** del proyecto.
2. **Crea tu rama de características**:
   ```bash
   git checkout -b feature/CaracteristicaAsombrosa
   ```
3. **Haz Commit de tus cambios**:
   ```bash
   git commit -m 'Se añade una característica sorprendente'
   ```
4. **Haz Push a la rama:**
   ```bash
   git push origin feature/CaracteristicaAsombrosa
   ```
5. **Abre un Pull Request**

### **🤝 Contribución**
¡Las contribuciones son bienvenidas! Por favor, lee nuestro archivo [CONTRIBUTING.md](CONTRIBUTING.md) para conocer los detalles sobre nuestro código de conducta y el proceso para enviarnos pull requests.

### **Licencia**
Este proyecto está bajo la licencia MIT. Consulta el archivo [Licencia MIT](LICENSE) para más detalles.

### **Contacto**
Para preguntas o soporte, por favor contacta a **Luis Cacuango** - [luiscacuango2084@gmail.com](mailto:luiscacuango2084@gmail.com).