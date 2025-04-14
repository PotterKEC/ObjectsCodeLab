# Assignment: Java Quiz Question Class

**Course:** Grade 12 Computer Science
**Due Date:** Friday, April 18, 2025

## Objective

The goal of this assignment is to practice object-oriented programming in Java by creating a reusable `Question` class. This class will encapsulate the data and behavior needed to represent a single question in a simple quiz application.

## Your Task: Create the `Question` Class

You need to create a Java class named `Question` within the `src/main/java/` directory.

**File:** `src/main/java/Question.java`

*(Please ensure your class is not placed inside any specific package unless instructed otherwise - it should use the default package for this assignment based on the project structure).*

Your `Question` class must have the following components:

### 1. Attributes (Instance Variables)

These variables should store the state of each Question object:

* `String question`: Stores the actual text of the question (e.g., "What is the capital of Manitoba?").
* `int totalMarks`: Stores the integer number of marks this question is worth (e.g., `5`).
* `String answer`: Stores the exact, correct answer for the question (e.g., "Winnipeg").
* `String studentAnswer`: Stores the answer provided by the user. It's good practice to initialize this to an empty string (`""`) or `null` in the constructor.

### 2. Constructor

You must provide a public constructor with the following signature:

```java
public Question(String question, int totalMarks, String answer)
```

This constructor should:
* Accept the question text, the total marks, and the correct answer as arguments.
* Initialize the corresponding instance variables (question, totalMarks, answer) with the values passed in.
* It should also initialize the studentAnswer variable (e.g., to "").

### 3. Methods

Your class must implement the following public methods:

```java
public void AskQuestion(Scanner scanner)
```

This method handles the interaction with the user for asking the question.
* It must first print the question text, followed by the totalMarks in parentheses. For example: `What is the capital of Manitoba? (5 marks)`
* Then, it should print a prompt for the user, like `Your answer: ` (Note: use System.out.print for the prompt so the user types on the same line).
* It must use the Scanner object passed into the method as an argument to read the user's input. Read the entire line of input provided by the user.
* Store the input read from the scanner into the studentAnswer instance variable.

```java
public int CheckAnswer()
```

This method compares the stored studentAnswer with the correct answer.
* The comparison must be case-sensitive. For example, "Winnipeg" is not the same as "winnipeg".
* If studentAnswer exactly matches answer, the method should return the value stored in totalMarks.
* If studentAnswer does not match answer (or if studentAnswer hasn't been set), the method should return 0. No partial marks are awarded.

## Provided Files

Your repository contains the following files to help you:

* `src/main/java/Assignment.java`: A simple main application that demonstrates how your Question class could be used. You can run this file to manually test your class, but do not modify it.
* `src/test/java/AssignmentTest.java`: Contains automated JUnit tests that will be used for grading. Do not modify this file. The tests check if your Question class meets all the requirements specified above.
* `pom.xml`: The configuration file for Maven, which manages project dependencies (like JUnit) and the build process. Do not modify this file.
* `.gitignore`: Specifies files that Git should ignore.
* `README.md`: This file (or the one you are creating based on this content).

## How to Test Your Code

**Manual Testing**: Write your Question.java class. You can then compile and run the provided Assignment.java file through the GitHub Codespaces interface. This will let you interact with your Question objects manually.

**Automated Testing**: The official grading will be based on the tests in AssignmentTest.java. You can (and should!) run these tests yourself before submitting:
* In GitHub Codespaces: Open a terminal in Codespaces and run the command: `mvn test`. Maven will compile your code and run the tests, reporting any failures.
* You can open the terminal in Codespaces by clicking on the Terminal menu and selecting "New Terminal" or by using the keyboard shortcut (Ctrl+` on Windows/Linux or ⌃` on Mac).

Make sure your code compiles and all tests pass before submitting.

## Submission

1. Write your Question.java class in the specified location (src/main/java/).
2. Use the GitHub Codespaces GUI for Git operations:
   * Click on the Source Control icon in the left sidebar (looks like a branch)
   * Stage your changes by clicking the "+" next to the modified files
   * Enter a commit message like "Implemented Question class" in the text box
   * Click the checkmark icon to commit
   * Click the "..." menu and select "Push" to push your changes to GitHub

Your assignment will be collected automatically via GitHub Classroom after the deadline.