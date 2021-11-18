### Hello!

Here is a simple Kotlin/JVM project.

Inside, you will find a `SimpleCalc` object that can do 3 operations:
* Add integers
* Multiply doubles
* Calculate the sum of even numbers in an array

### Tasks

1. Implement unit tests for `SimpleCalc` with a framework of your choice (JUnit, TestNG, etc.)
2. Create behavior scenarios and implement them with a framework of your choice (Cucumber, Serenity, etc.)
3. Write a Python wrapper to run your tests
4. Write GitHub Actions automation that will use your Python wrapper to run tests

### BDD scenarios requirements

Try to imagine basic and advances use cases to cover as much as possible.
Imagine it's your project and you really care about its quality.
Try to demonstrate the deep knowledge of a BDD framework you choose.

### Python wrapper requirements

Yes, shell scripts are good enough in this case, but this is a testing exercise, so...

Python wrapper should be capable of:
1. Separately run unit tests and BDD scenarios
2. Save reports in parametrized `reports` directory
3. Save stdout and stderr logs in `logs` directory

```shell
# Run unit tests
simple-calc-test-runner --run unittests --reports-dir unit-test-reports
# Run BDD scenarios
simple-calc-test-runner --run scenarios
```
