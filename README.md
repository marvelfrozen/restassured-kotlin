# REST Assured Kotlin Tutorial

## Description

This project provides a REST Assured testing written in Kotlin to perform functional testing.

## Table of Contents

1. [Getting Started](#getting-started)
    - [Installation](#installation)
    - [Quick Start](#quick-start)
2. [Example Test Flows](#example-test-flows)
3. [Acknowledgement](#acknowledgment)
4. [Contact](#contact)

## Getting Started

### Installation

To run this project, you will need the following tools:

- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) - An integrated development environment.
- [Gradle](https://gradle.org/install/) - A build automation tool.

### Quick Start

1. Clone the project repository:

    ```shell
    git clone https://github.com/marvelfrozen/restassured-kotlin.git
    ```

2. Open the project in IntelliJ IDEA.

3. Use the following command to run the example test scenario:

    ```shell
    gradle test --tests "resreq.users.TestGetUsersList.Check Get Users List"
    ```

4. The test results will be generated in the `build/reports/tests/test` folder.

## Example Test Flows

This section describes the ReqRes Get Users List flows included in this project. The test consists of module class in `src/main/kotlin/resreq` and test class in `src/test/kotlin/resreq/users`.

### Module Class

Check the module class and function `resreq.Users.getUsersList`. 

A module class is used here so we can reuse the api call more easily rather than construct it in the test class every time we want to call it.

### Test Class

Test class can be found here `resreq.users.TestGetUsersList`

This test class demonstrates on how to use the module class to call the api.

- **Scenario:** Check Get Users List
- **Steps:**
   1. Call get users list api with parameter `page=2` 
   2. Assert the response body json

## Acknowledgment

This project uses the ReqRes.in service for the example simulation. We appreciate their contribution to the developer community.

## Contact

For any questions or assistance related to this project, feel free to reach out to me:

- **Name:** Gavril
- **Email:** [marvelfrozen@gmail.com](mailto:marvelfrozen@gmail.com)
- **LinkedIn:** [linkedin.com/in/gavrilafb](https://www.linkedin.com/in/gavrilafb)