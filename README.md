# TestNG Automation Framework

## Introduction
This Test Automation Framework is built using **Java**, **Selenium WebDriver**, and **TestNG**. It is designed for automating various web-based applications and includes reusable, application-independent keyword components. These components minimize repetitive development and ensure faster implementation for new projects.

The framework provides features such as reporting, logging, and screenshot capturing, making it easier to debug and analyze test executions.

---

## Prerequisites

Ensure you have the following installed on your machine:
- **Java Development Kit (JDK)**: Version 1.8 or higher  
  [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Apache Maven**: Version 3 or higher  
  [Maven Installation Guide](http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
- **IDE**: IntelliJ IDEA or any Java-supported IDE.
- **TestNG Plugin**: Ensure the TestNG plugin is installed in your IDE for effective test execution.

---

## Framework Structure

### Key Folders and Files
- **`src/main/java/Com`**
    - `ER`: Contains ExtentReports configuration and listeners.
    - `qa/base`: Includes the `TestBase` class for WebDriver initialization, configurations, and utilities.
    - `qa/config`: Stores `config.properties` for environment-specific settings.
    - `qa/pages`: Page Object Model (POM) classes for different modules (e.g., `Dashboard`, `Login`).
    - `qa/utility`: Utility classes like `TestUtil` for reusable functions.

- **`src/test/java/demo_qa`**
    - Contains test classes (e.g., `Login`, `Verify_Dashboard`) for application validation.

- **`resources`**
    - `log4j2.properties`: Configures logging.

- **`Screenshots`**
    - Stores screenshots of failed test cases.

- **`report`**
    - Contains the generated `index.html` report for test execution results.

- **`TestData`**
    - Placeholder for storing test data files (e.g., Excel, JSON, or CSV).

- **`pom.xml`**
    - Maven project configuration for dependency management.

---

## Installation

Follow these steps to set up the framework:

1. Clone this repository:
   ```bash
   git clone <repository-url>
   cd Automation-Demo
   ```

2. Import the project into your IDE as a Maven project.

3. Download the required dependencies:
   ```bash
   mvn clean install
   ```

4. Update the `config.properties` file under `src/main/java/Com/qa/config` to configure the required environment.

---

## Execution

### Running Tests
1. Navigate to the project directory.
2. To execute all tests, run:
   ```bash
   mvn clean test
   ```

3. To execute a specific TestNG XML suite:
   ```bash
   mvn clean test -DsuiteXmlFile=TestRun.xml
   ```

4. To run tests with specific profiles:
   ```bash
   mvn clean test -P<profile-name>
   ```
   Replace `<profile-name>` with the appropriate profile (e.g., `dev`, `test`, `prod`).

---

## Reporting

- **ExtentReports**:  
  The framework generates an `index.html` report located in the `report` folder. Open it in a browser to view detailed results.

- **Location**:  
  `Automation-Demo/report/index.html`

---

## Screenshots

- Screenshots are automatically captured for failed test cases.
- **Location**:  
  `Automation-Demo/Screenshots`

---

## Logging

- Logging is configured using **Log4j2**.
- Configuration file location: `src/main/resources/log4j2.properties`.

---

## Framework Highlights

1. **Reusability**: Predefined methods and utilities reduce duplication.
2. **Modular Design**: Uses the Page Object Model (POM) for maintainability.
3. **Reporting**: Integrated ExtentReports for detailed test results.
4. **Error Handling**: Captures screenshots for failed test cases.
5. **Logging**: Centralized logging for better traceability.

---

## Java and Framework Versions

- **Java Version**: JDK 1.8 or higher
- **Selenium Version**: 4.x
- **TestNG Version**: 7.x
- **Maven Version**: 3.6.x or higher

---

## Future Enhancements

- Integration with Continuous Integration/Continuous Deployment (CI/CD) tools like Jenkins.
- Support for parallel execution and cross-browser testing.
- Incorporation of API testing modules.

---

