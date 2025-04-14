# Java Conditions Practice

## Assignment Overview
In this assignment, you will practice working with Java conditions, comparison operators, and type conversions. You'll be working with a set of predefined variables and need to complete several if statement conditions to make all the tests pass.

## Your Task
You need to complete the conditions in the `runConditions()` method of the `Assignment` class. The class contains four predefined variables:
- `number1`: An integer with value 42
- `number2`: An integer with value 7
- `decimal`: A double with value 3.14
- `text`: A String containing "123"

### Requirements
1. You must only modify the conditions inside the if statements
2. You cannot add any new variables
3. You cannot modify the print statements
4. You cannot add any additional code outside of the if statement conditions

### What You Need to Know
- How to use comparison operators (`>`, `<`, `>=`, `<=`, `==`, `!=`)
- How to convert between different data types (String to int, int to double)
- How to use the logical AND operator (`&&`)
- How to use `Integer.parseInt()` for String to int conversion

## Running the Tests
The tests will verify that:
1. All five conditions evaluate to true and print their success messages
2. No additional print statements have been added
3. The initial values of the variables haven't been modified

To run the tests locally:
```bash
mvn test
```

## Submission
Push your changes to GitHub. The autograder will automatically run the tests and provide feedback on your submission.

## Hints
- Remember that you can convert a String to an integer using `Integer.parseInt()`
- When comparing doubles, consider type conversion of other numbers
- Think about the relationship between the given numbers
- The fifth condition should use the AND operator (`&&`) to combine multiple comparisons

Good luck!
