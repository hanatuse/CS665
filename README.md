| CS-665       | Software Design & Patterns |
| ------------ | -------------------------- |
| Name         | YINGTONG ZHOU              |
| Date         | 12/06/2024                 |
| Course       | Fall                       |
| Assignment # | 6                          |

# Assignment Overview

I chose Assignment 1. Fully Automatic Beverage Vending Machine as an example to improve.

# GitHub Repository Link:

https://github.com/hanatuse/cs-665-assignment-1

# Implementation Description

I identified 3 opportunities for code improvement:

## 1. Simplify the Condiment Management

• The Condiment class is currently generic, with methods like getExtraCost() being overridden. It could benefit from a factory pattern to create condiments dynamically, avoiding repetitive code for instantiation.
• Improvement: Introduce a CondimentFactory class. This can help avoid hardcoding the creation logic and make it easier to add new condiments in the future without modifying existing code.

Explanation of Changes:

1. Enum Separation:
   o Created a new CondimentType enum to define condiment types (MILK, CREAM, SUGAR).
   o This allows better separation between types and the condiment details (e.g., cost).
2. Encapsulation of Creation Logic:
   o Added a Condiment class with a private constructor to encapsulate properties like type and extraCost.
   o Introduced a static factory method createCondiment(CondimentType type) to create condiment objects dynamically.
3. Flexibility for Extension:
   o The factory approach makes it easier to add new condiments in the future without modifying existing logic.

## 2. Enhance the BeverageVendor Interface

• The interface has both methods for creation (createBeverage) and direct operations like getCost or getRecipe. Mixing creation logic and behavior logic in the same interface violates the Single Responsibility Principle.
• Improvement: Separate the responsibilities into two interfaces: one for beverage creation (e.g., BeverageFactory) and another for operations (e.g., BeverageService).

Explanation of Changes:

1. Single Responsibility Principle:
   a. The BeverageFactory interface focuses solely on the creation of beverages.
   b. The BeverageService interface handles operational methods like cost calculation and recipe retrieval.
2. Flexibility:
   a. These interfaces can be implemented independently, allowing vendors to focus on creation, operations, or both.
   b. Different vendors (e.g., CoffeeVendor, TeaVendor) can have specialized implementations for creating or operating on beverages.
3. Scalability:
   a. Adding new responsibilities (e.g., beverage customization or discounting) becomes simpler by introducing new interfaces rather than modifying existing ones.

## 3. Abstract Common Logic in Coffee and Tea

• Both Coffee and Tea have a similar structure, with shared properties like size, baseBeverage, and otherCondiments. There's also redundancy in methods like getCost and addOtherCondiments.
• Improvement: Create an abstract base class (e.g., BeverageBase) that encapsulates shared logic and properties. This reduces duplication in Coffee and Tea and improves maintainability.

Explanation of Changes:

1. Create Abstract Class BeverageBase:
   o Encapsulate shared properties like size, baseBeverage, and otherCondiments.
   o Provide common methods such as getCost(), addOtherCondiments(), and toString().
2. Refactor Coffee.java and Tea.java:
   o Both classes will extend the BeverageBase class, reducing duplication by inheriting shared properties and methods.
   o Focus only on type-specific details (e.g., constructors or tea/coffee-specific logic).

# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/) on your system.

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains information about the project, such as its dependencies, the build configuration, and the plugins used for building and packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports, and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile

Type on the command line:

```bash
mvn clean compile
```

## JUnit Tests

JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:

```bash
mvn clean test
```

## Spotbugs

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui
```

For more info see
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.

## Checkstyle

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on any issues or violations of the coding standards defined in its configuration. This includes issues like code style, code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices, making it easier for other developers to read and maintain. It can also help to identify potential issues before the code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser.

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`
