import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class AssignmentTest {
    @Test
    public void testConditions() {
        Assignment assignment = new Assignment();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        assignment.runConditions();
        String output = outContent.toString();
        
        // Test that all conditions were met and printed their success messages
        assertTrue(output.contains("First condition passed!"), "First condition should pass");
        assertTrue(output.contains("Second condition passed!"), "Second condition should pass");
        assertTrue(output.contains("Third condition passed!"), "Third condition should pass");
        assertTrue(output.contains("Fourth condition passed!"), "Fourth condition should pass");
        assertTrue(output.contains("Fifth condition passed!"), "Fifth condition should pass");
        
        // Test that no additional print statements were added
        assertEquals(5, output.split("\n").length, "There should be exactly 5 print statements");
    }

    @Test
    public void testInitialValues() {
        Assignment assignment = new Assignment();
        
        // Verify initial values haven't been changed
        assertEquals(42, assignment.getNumber1(), "number1 should be 42");
        assertEquals(7, assignment.getNumber2(), "number2 should be 7");
        assertEquals(3.14, assignment.getDecimal(), 0.001, "decimal should be 3.14");
        assertEquals("123", assignment.getText(), "text should be \"123\"");
    }
}
