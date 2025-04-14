// src/test/java/AssignmentTest.java

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach; // Import AfterEach
import org.junit.jupiter.api.DisplayName;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

// import com.example.Question; // If using packages

class AssignmentTest {

    private Question sampleQuestion;
    private final String TEST_QUESTION = "What is the primary color?";
    private final int TEST_MARKS = 3;
    private final String TEST_ANSWER = "Blue";

    // Keep track of original streams
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    // Declare the output stream here to be accessible in @AfterEach
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        try {
             sampleQuestion = new Question(TEST_QUESTION, TEST_MARKS, TEST_ANSWER);
        } catch (Exception e) {
            // Using fail() here ensures the test stops immediately if setup fails
            fail("SETUP FAILED: Could not instantiate Question object. Ensure constructor Question(String, int, String) exists.", e);
        }

        // Reset and redirect System.out for THIS test
        outContent = new ByteArrayOutputStream(); // Create fresh stream for each test
        System.setOut(new PrintStream(outContent));

        // Reset System.in (though provideInput will usually overwrite)
        System.setIn(originalIn);
    }

    // Use @AfterEach to guarantee streams are restored after EACH test method
    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
         // Optional: print captured output for debugging if needed
         // if (outContent.size() > 0) {
         //    originalOut.println("--- Captured output for test ---");
         //    originalOut.println(outContent.toString());
         //    originalOut.println("------------------------------");
         // }
    }

     // Helper method to provide simulated input to System.in
    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    @DisplayName("Test Question Constructor and Attribute Initialization (via AskQuestion output)")
    void testConstructor() {
        assertNotNull(sampleQuestion, "Question object should not be null after construction.");

        // Provide minimal input needed for AskQuestion to proceed
        provideInput("\n"); // Simulate user pressing Enter

        String capturedOutput = ""; // To store output

        try (Scanner scanner = new Scanner(System.in)) {
            // Action: Call the method that should print to System.out
            sampleQuestion.AskQuestion(scanner);

            // Crucial: Flush the PrintStream to ensure data is written to the underlying ByteArrayOutputStream
            System.out.flush();

            // Capture: Get the content AFTER flushing
            capturedOutput = outContent.toString();

        } catch (Exception e) {
             // If AskQuestion throws an error, fail the test clearly
             fail("AskQuestion method threw an unexpected exception during testConstructor execution.", e);
        }
        // No finally block needed here for restoreStreams because @AfterEach handles it

        // --- Assertions ---
        // Optional: Print captured output for debugging test failures
        // originalOut.println("DEBUG: Captured output in testConstructor:\n" + capturedOutput);
        // originalOut.println("DEBUG: Expected to contain: " + TEST_QUESTION);
        // originalOut.println("DEBUG: Expected to contain: " + "(" + TEST_MARKS + " marks)");


        // Assertion 1: Check if the captured output contains the question text
        assertTrue(capturedOutput.contains(TEST_QUESTION),
                   "AskQuestion should print the question text. Captured: \"" + capturedOutput.replace("\n", "\\n").replace("\r", "\\r") + "\"");

        // Assertion 2: Check if the captured output contains the marks indicator
        String expectedMarksString = "(" + TEST_MARKS + " marks)";
        assertTrue(capturedOutput.contains(expectedMarksString),
                   "AskQuestion should print the marks. Captured: \"" + capturedOutput.replace("\n", "\\n").replace("\r", "\\r") + "\"");
    }

    // ... other test methods remain largely the same, but ensure provideInput
    // is called correctly before AskQuestion, and rely on @AfterEach for cleanup.

    @Test
    @DisplayName("Test AskQuestion Method - Input Reading and Storage")
    void testAskQuestionInput() {
        String simulatedInput = "Red";
        provideInput(simulatedInput + "\n");

        try (Scanner testScanner = new Scanner(System.in)) {
            sampleQuestion.AskQuestion(testScanner);
             System.out.flush(); // Flush after method call
        } catch (Exception e) {
             fail("AskQuestion method threw an unexpected exception during input.", e);
        }
        // @AfterEach handles stream restoration

        // Assuming a getter getStudentAnswer() exists or test indirectly:
         Question q = new Question("Input Test", 1, "ExpectedInput");
         provideInput("ExpectedInput\n");
         try (Scanner s = new Scanner(System.in)) { q.AskQuestion(s); System.out.flush();} catch (Exception e) {fail(e);}
         assertEquals(1, q.CheckAnswer(), "CheckAnswer should return full marks if AskQuestion stored the correct input.");

         provideInput("WrongInput\n");
         try (Scanner s = new Scanner(System.in)) { q.AskQuestion(s); System.out.flush();} catch (Exception e) {fail(e);}
         assertEquals(0, q.CheckAnswer(), "CheckAnswer should return 0 if AskQuestion stored incorrect input.");
    }

     @Test
    @DisplayName("Test CheckAnswer Method - Correct Answer")
    void testCheckAnswerCorrect() {
        provideInput(TEST_ANSWER + "\n");
         try (Scanner testScanner = new Scanner(System.in)) {
            sampleQuestion.AskQuestion(testScanner);
             System.out.flush();
        } catch (Exception e) {
             fail("AskQuestion method failed during setup for CheckAnswer test.", e);
        }
         // @AfterEach handles stream restoration

        int score = sampleQuestion.CheckAnswer();
        assertEquals(TEST_MARKS, score, "CheckAnswer should return full marks for the correct answer.");
    }

    @Test
    @DisplayName("Test CheckAnswer Method - Incorrect Answer")
    void testCheckAnswerIncorrect() {
        String incorrectAnswer = "Green";
         provideInput(incorrectAnswer + "\n");
         try (Scanner testScanner = new Scanner(System.in)) {
            sampleQuestion.AskQuestion(testScanner);
             System.out.flush();
        } catch (Exception e) {
            fail("AskQuestion method failed during setup for CheckAnswer test.", e);
        }
         // @AfterEach handles stream restoration

        int score = sampleQuestion.CheckAnswer();
        assertEquals(0, score, "CheckAnswer should return 0 for an incorrect answer.");
    }

     @Test
    @DisplayName("Test CheckAnswer Method - Case Sensitivity (Optional)")
    void testCheckAnswerCaseSensitivity() {
        String caseDifferentAnswer = "blue";
         provideInput(caseDifferentAnswer + "\n");
         try (Scanner testScanner = new Scanner(System.in)) {
            sampleQuestion.AskQuestion(testScanner);
             System.out.flush();
        } catch (Exception e) {
            fail("AskQuestion method failed during setup for CheckAnswer test.", e);
        }
         // @AfterEach handles stream restoration

        int score = sampleQuestion.CheckAnswer();
        assertEquals(0, score, "CheckAnswer should be case-sensitive by default (e.g., 'Blue' != 'blue').");
    }

     @Test
    @DisplayName("Test CheckAnswer Method - Empty Input")
    void testCheckAnswerEmpty() {
         provideInput("\n");
         try (Scanner testScanner = new Scanner(System.in)) {
            sampleQuestion.AskQuestion(testScanner);
             System.out.flush();
        } catch (Exception e) {
            fail("AskQuestion method failed during setup for CheckAnswer test.", e);
        }
         // @AfterEach handles stream restoration

        int score = sampleQuestion.CheckAnswer();
        assertEquals(0, score, "CheckAnswer should return 0 for empty input.");
    }
}