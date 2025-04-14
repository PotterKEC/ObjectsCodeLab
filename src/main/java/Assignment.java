public class Assignment {
    // These variables will be used in the conditions
    private int number1 = 42;
    private int number2 = 7;
    private double decimal = 3.14;
    private String text = "123";

    public void runConditions() {
        // Condition 1: Use comparison between number1 and number2
        if ( /* Your condition here */ ) {
            System.out.println("First condition passed!");
        }

        // Condition 2: Convert text to integer and compare with number1
        if ( /* Your condition here */ ) {
            System.out.println("Second condition passed!");
        }

        // Condition 3: Use decimal in a comparison
        if ( /* Your condition here */ ) {
            System.out.println("Third condition passed!");
        }

        // Condition 4: Compare number2 cast to double with decimal
        if ( /* Your condition here */ ) {
            System.out.println("Fourth condition passed!");
        }

        // Condition 5: Use multiple comparisons with AND operator
        if ( /* Your condition here */ ) {
            System.out.println("Fifth condition passed!");
        }
    }

    // Getter methods for testing
    public int getNumber1() { return number1; }
    public int getNumber2() { return number2; }
    public double getDecimal() { return decimal; }
    public String getText() { return text; }
}
