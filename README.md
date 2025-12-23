# **javatest**

![Java](https://img.shields.io/badge/Java-25%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-3.5.4-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![JUnit 5](https://img.shields.io/badge/JUnit-5.13.4-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)
![Mockito](https://img.shields.io/badge/Mockito-5.21.0-6bba46?style=for-the-badge&logo=mockito&logoColor=white)
![H2](https://img.shields.io/badge/H2_Database-004B8D?style=for-the-badge&logo=sqlite&logoColor=white)
![Spring](https://img.shields.io/badge/Spring_JDBC-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Tests](https://img.shields.io/badge/Tests-100%25%20Passed-brightgreen?style=for-the-badge&logo=checkmarx&logoColor=white)
![Build Status](https://img.shields.io/github/actions/workflow/status/luiscacuango2/JavaTest/maven.yml?style=for-the-badge&logo=github&label=CI%20Build)
![Java CI](https://github.com/luiscacuango2/javatest/actions/workflows/maven.yml/badge.svg)

## **Descripción**
Este repositorio es un ecosistema de aprendizaje y desarrollo en Java. Contiene implementaciones de algoritmos clásicos, gestión de lógica de negocio y pruebas de integración, sirviendo como base sólida para despliegue de componentes escalables.

---
### Funcionalidades Principales
- ✅ **Búsqueda Inteligente:** Filtro de películas por nombre (parcial y case-insensitive).
- ✅ **Gestión de Catálogo:** Búsqueda avanzada por género y director.
- ✅ **Persistencia Robusta:** Repositorio implementado con `JdbcTemplate` y soporte para bases de datos SQL.
- ✅ **Calidad de Código:** Cobertura de pruebas unitarias con Mockito e integración con base de datos H2.

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
| **Buscador de Cine** | `MovieService` | Filtrado por nombre, género y director. | Mockito |
| **Persistencia SQL** | `MovieRepository` | Pruebas de integración con scripts H2. | Spring JDBC |
| **Seguridad** | `PasswordUtil` | Niveles de seguridad y longitud de claves. | JUnit 5 |
---

### **Estrategia de Testing**

Para asegurar la robustez del sistema, empleamos una **pirámide de pruebas** equilibrada:

1.  **Unit Tests (JUnit 5):** Validamos la lógica pura de algoritmos y utilidades en aislamiento total.
2.  **Doubles & Mocks (Mockito):** Aislamos las dependencias externas (servicios, repositorios) para probar el comportamiento de la capa de negocio sin efectos colaterales.
3.  **Integration Tests (H2 Database):** Verificamos la comunicación real con la base de datos, ejecutando scripts SQL (`test-data.sql`) en entornos de memoria controlados.
---

### **Stack Técnico**
* **Lenguaje:** Java 25 (utilizando las últimas funciones de la JVM).
* **Build Tool:** Maven 3.5.4+.
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

### **Estructura del Proyecto**

El proyecto sigue una arquitectura modular y por capas (Interfaz, Negocio y Datos), organizada de la siguiente manera:

```text
javatest/
├── src/
│   ├── main/
│   │   ├── java/com/luigi/javatest/
│   │   │   ├── discounts/      # Lógica para gestión de descuentos
│   │   │   ├── movies/         # Dominio principal de Películas
│   │   │   │   ├── data/       # Capa de Datos (Repositorios con JdbcTemplate)
│   │   │   │   ├── model/      # Entidades y modelos de datos (POJOs)
│   │   │   │   └── service/    # Capa de Negocio (Lógica de filtrado y búsqueda)
│   │   │   ├── payments/       # Simulación de pasarela de pagos
│   │   │   ├── player/         # Lógica del reproductor
│   │   │   └── util/           # Clases de utilidad generales
│   │   └── resources/
│   │       └── sql-scripts/    # Scripts SQL para inicialización y pruebas
│   │           └── test-data.sql
│   └── test/
│       └── java/com/luigi/javatest/ # Espejo de src/main para pruebas unitarias e integración
├── pom.xml                     # Configuración de Maven y dependencias
└── README.md                   # Documentación del proyecto
```
### **Dependencias**

- **org.mockito:mockito-core:5.21.0** (scope: `test`)
  Biblioteca principal para crear mocks y stubs en pruebas. Se utiliza junto con **mockito-junit-jupiter** (5.21.0) para una integración fluida con JUnit 5.
  *Nota técnica:* Para Java 25+, se ha configurado el `javaagent` y la flag `-XX:+EnableDynamicAgentLoading` en el `maven-surefire-plugin` para permitir la carga dinámica de Mockito.

- **org.junit.jupiter:junit-jupiter:5.13.4** (scope: `test`)
  JUnit 5 (Jupiter) — API moderna para pruebas. La versión se gestiona centralizadamente mediante el `junit-bom` (5.13.4) definido en la sección `dependencyManagement`.

- **org.springframework:spring-jdbc:6.2.11**
  Proporciona utilidades como `JdbcTemplate` para simplificar las operaciones con la base de datos y el mapeo de resultados.

- **com.h2database:h2:2.4.240**
  Base de datos SQL en memoria, utilizada para ejecutar tests de integración rápidos sin necesidad de un servidor de base de datos externo.

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
### **Configuración de Ejecución (Surefire)**

El proyecto utiliza **maven-surefire-plugin (3.5.4)** con una configuración personalizada para soportar las últimas características de la JVM:

1. **Patrones de nombres:** Se ejecutan automáticamente los archivos que terminan en:
    - `*Test.java`
    - `*Should.java` (estilo BDD).

2. **JVM Arguments:**
    - `-XX:+EnableDynamicAgentLoading`: Necesario en versiones modernas de Java para que Mockito pueda interceptar llamadas.
    - `-javaagent`: Apunta directamente al jar de Mockito en el repositorio local para asegurar su inicialización.
---

### **Cómo ejecutar los tests**

Para ejecutar todas las pruebas desde la terminal, usa:
   ```bash
   mvn test
   ```
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

### **Contribución**
¡Las contribuciones son bienvenidas! Por favor, lee nuestro archivo [CONTRIBUTING.md](CONTRIBUTING.md) para conocer los detalles sobre nuestro código de conducta y el proceso para enviarnos pull requests.

### **Licencia**
Este proyecto está bajo la licencia MIT. Consulta el archivo [Licencia MIT](LICENSE) para más detalles.

### **Contacto**
Para preguntas o soporte, por favor contacta a **Luis Cacuango** - [luiscacuango2084@gmail.com](mailto:luiscacuango2084@gmail.com).