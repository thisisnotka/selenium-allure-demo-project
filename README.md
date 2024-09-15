# Selenium TestNG Project with Allure Reporting

This repository contains a demo project showcasing Selenium WebDriver with the Page Object Model (POM) and Allure reporting for visualization of test results.

## Prerequisites

Before you start, make sure you have the following installed:

- **Java Development Kit (JDK)**: [Download and install JDK](https://www.azul.com/downloads/#downloads-table-zulu)
- **Maven**: [Download and install Maven](https://maven.apache.org/install.html)
- **Allure**: [Install Allure](https://allurereport.org/docs/#_installing_a_commandline)
- **IntelliJ IDEA**: [Download and install IntelliJ IDEA](https://www.jetbrains.com/idea/)

## Setup and Execution

Follow these steps to set up and run the project:

1. **Clone the Repository**

2. **Open the Project**

   Launch IntelliJ IDEA. Open the project by selecting the cloned repository directory.

3. **Run Tests**

   Type command to execute testSuite.xml
```
mvn clean install
``` 

4. **Open Allure Report on localhost**

   Open the terminal in IntelliJ IDEA. Navigate to the project directory if not already there. Execute the following command to serve the Allure report:
``` 
allure serve allure-results
``` 

This will start a local server on a random port and open the Allure report in your default browser.

## Additional information
* TestNG: This project uses TestNG for test management.
* Allure: The Allure reporting tool is integrated for generating detailed and interactive reports.
* Page Object Model: The Page Object Model design pattern is used to create an object repository for web UI elements.