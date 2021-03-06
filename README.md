# AlationTest

## Getting Started

### Pre requisites
	- Install Java 8+
	- Install maven and set M2_HOME in env variables
	- Chrome version should be 67+

### Steps
Clone the repository in local

Open command prompt and navigate to respository directory

Install maven dependencies by running 

```
mvn clean install
```

Run test script using 

```
mvn test
```

- Reports will be saved in target/surefire-reports

## Assumptions:
- Framework is developed on maven project using testng.
- Java version 1.8 is used for writing test scripts.
- Selenium 3.13 is used
- Currently framework will support execution only in chrome browser (v 67 or above) but can be extended to different browsers

## Design Decisions:
- Framework folder structure is as follows

### resources: resources contains lib and output folders
- lib contains external library files like chromedriver
- output contains the output files generated by scripts

### java: contains component, pages and tests folders with testng file
 
 Pages folder have all the pages related to script.

 * All locators of a particular page will be stored page wise

 * Wrapper methods for the functionalities will be stored which call the selenium commands from components

 Component folder have keywords for the framework

* Selenium keywords are wrapped in user defined keywords which are easy to use and can be used to perform multiple actions
* Reporting can also be added to the keywords in component class
*  Currently only one component class is created as there are not many pages in script. however it can be extended to different component classes based on type of actions.

 Tests folder contains the test scripts
 
 * Test scripts are written in testng classes
 * Pages methods are called in test methods
 
