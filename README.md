
Introduction

This Test Automation Framework is created using Java + Selenium Web Driver + TestNG. Which can be used across different web based applications. In this approach, the endeavor is to build a lot of applications independent reusable keyword components so that they can
directly used for another web application without spending any extra effort. With this framework in place, whenever we need to automate a web based application, we would not need to start from scratch, but use the application independent keyword components to the extent
possible and create application specific components for the specific needs.


Execution

* Clone the repository.
* Open command prompt and go to web-test directory.
* To run on local environment use command .....\Java-Selenium-TestNG-Automation-Framework> mvn clean test -Pdev





Features
* Page Object Model (POM): Improves code structure by separating UI elements and actions from test logic.
Maven: Dependency management and build automation.
TestNG: Manages test execution, annotations, and parallel test execution.
HTML Reporting: Generates detailed reports after test execution.
Screenshot Capture: Takes screenshots on test failures.
Log4j Integration: Provides logging for better debugging and monitoring.
Base Class with Generic Methods: Handles common actions like browser initialization, element interactions, and teardown.
