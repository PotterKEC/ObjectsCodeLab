// src/main/java/Assignment.java

import java.util.Scanner;
// If students create Question.java in a package (e.g., com.example), uncomment the line below
// import com.example.Question;

/**
 * A simple class to demonstrate the usage of the Question class.
 * Students should create the Question.java file.
 */
public class Assignment {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner inputScanner = new Scanner(System.in);
        int totalScore = 0;
        int maxScore = 0;

        System.out.println("--- Simple Quiz ---");

        // --- Question 1 ---
        // Assuming the Question class has a constructor:
        // Question(String questionText, int marks, String correctAnswer)
        try {
            Question q1 = new Question("What is the capital of Canada?", 5, "Ottawa");
            maxScore += q1.totalMarks; // Add question's marks to max score

            q1.AskQuestion(inputScanner); // Ask the question and get the student's answer
            int score1 = q1.CheckAnswer(); // Check the answer
            totalScore += score1; // Add the score obtained to the total

            System.out.println("Your score for this question: " + score1 + "/" + q1.totalMarks);
            System.out.println("--------------------");


            // --- Question 2 ---
            Question q2 = new Question("What is 2 + 2?", 2, "4");
            maxScore += q2.totalMarks;

            q2.AskQuestion(inputScanner);
            int score2 = q2.CheckAnswer();
            totalScore += score2;

            System.out.println("Your score for this question: " + score2 + "/" + q2.totalMarks);
            System.out.println("--------------------");

            // Add more questions as needed...

        }  catch (NoSuchMethodError e) {
             System.err.println("Error: A required method or constructor in the Question class is missing or has the wrong signature.");
             System.err.println("Please check the requirements for the Question class constructor and methods.");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the scanner
             if (inputScanner != null) {
                inputScanner.close();
             }
        }


        System.out.println("--- Quiz Finished ---");
        System.out.println("Your final score: " + totalScore + "/" + maxScore);
    }
}
