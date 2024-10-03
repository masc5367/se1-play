# Project: *se1-play* - branch: *libs*

The `libs` branch contains libraries needed by the project.

This includes libraries for:

- `jackson`: processing JSON data in Java

- `jacoco`: code coverage library for Java

- `junit`: libraries for JUnit tests

- `logging`: *log4j2* logging library for Java

- `junit-platform-console-standalone-1.9.2.jar`: JUnit test runner


Libraries are organized in folders:

```sh
<se1-play>              # project directory
 |
 +-<jackson>                    # library for processing JSON data in Java
 |  +--jackson-annotations-2.13.0.jar
 |  +--jackson-core-2.13.0.jar
 |  +--jackson-databind-2.13.0.jar
 |
 +-<jacoco>                     # code coverage library for Java
 |  +--jacocoagent.jar
 |  +--jacococli.jar
 |
 +-<junit>                      # libraries for JUnit tests
 |  +--apiguardian-api-1.1.2.jar
 |  +--junit-jupiter-api-5.9.3.jar
 |  +--junit-platform-commons-1.9.3.jar
 |  +--opentest4j-1.2.0.jar
 |                              # JUnit test runner
 +--junit-platform-console-standalone-1.9.2.jar
 |
 +-<logging>                    # log4j2 logging library for Java
    +--log4j-api-2.23.1.jar
    +--log4j-core-2.23.1.jar
    +--log4j-slf4j2-impl-2.23.1.jar
    +--slf4j-api-2.0.16.jar
```
