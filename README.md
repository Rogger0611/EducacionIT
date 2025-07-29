
Proyecto de Automatización de Pruebas con Java + TestNG + POM
============================================================

Este proyecto es un framework de automatización de pruebas desarrollado en Java, utilizando TestNG como framework de pruebas y estructurado bajo el patrón de diseño Page Object Model (POM). El objetivo es crear una base escalable, mantenible y reutilizable para pruebas automatizadas de aplicaciones web.

------------------------------------------------------------

🧰 Tecnologías y Herramientas Utilizadas

- Java 17+
- Selenium WebDriver
- TestNG
- Maven (gestor de dependencias)
- Page Object Model (POM)
- Google ChromeDriver / GeckoDriver / EdgeDriver

------------------------------------------------------------

🗂️ Estructura del Proyecto

proyecto-automatizacion/
├── src/
│   └── test/
│       └── java/
│           ├── pruebas/           → Clases de prueba (TestNG)
│           ├── paginas/           → Page Objects
│           └── utils/             → Utilidades generales
│
├── testng.xml                     → Suite de TestNG
├── pom.xml                        → Configuración Maven
├── capturas/                      → Capturas de pantalla ante errores
├── README.md                      → Documentación del proyecto


------------------------------------------------------------

🧱 Patrón de Diseño: Page Object Model (POM)

Cada página de la aplicación web se representa con una clase Java que contiene:

- Localizadores (WebElements)
- Métodos que interactúan con los elementos
- Acciones específicas de la página

Esto facilita la reutilización de código y mejora el mantenimiento.

------------------------------------------------------------

🚀 Cómo Ejecutar el Proyecto

1. Clonar el Repositorio

git clone https://github.com/tu-usuario/proyecto-automatizacion.git
cd proyecto-automatizacion

2. Importar en tu IDE

- Abrir con IntelliJ IDEA o Eclipse
- Importar como proyecto Maven

3. Ejecutar Pruebas

Usando línea de comandos:
mvn clean test

Usando TestNG:
- Abrir testng.xml
- Clic derecho > Run 'testng.xml'

------------------------------------------------------------

✨ Mejores Prácticas

- Separar lógica de prueba y lógica de UI (POM)
- Usar anotaciones de TestNG: @BeforeClass, @AfterClass, @DataProvider, etc.
- Utilizar Listeners para capturar fallos o generar reportes
- Añadir validaciones claras (Assert o SoftAssert)
- Incluir configuración de entornos y credenciales de forma externa

------------------------------------------------------------

📋 Requisitos Previos

- Java 17 o superior
- Maven instalado
- Navegador (Chrome o Firefox)
- IDE compatible (IntelliJ, Eclipse)

------------------------------------------------------------

📦 Dependencias Principales (pom.xml)

<dependencies>
  <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.28.1</version>
  </dependency>
  <dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>6.10</version>
    <scope>test</scope>
  </dependency>
  <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.27</version>
     </dependency>
  <!-- ExtentReports o Allure si se desea -->
</dependencies>

------------------------------------------------------------

📄 Licencia

Este proyecto es de código abierto y se distribuye bajo la licencia MIT.

------------------------------------------------------------

🤝 Contribuciones

¡Contribuciones, mejoras y sugerencias son bienvenidas! Por favor, crea un Pull Request o abre un Issue.
