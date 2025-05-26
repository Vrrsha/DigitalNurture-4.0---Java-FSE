public class OperatorPrecedence {
    public static void main(String[] args) {
        int result = 10 + 5 * 2;
        int result2 = (10 + 5) * 2;

        System.out.println("Without parentheses (10 + 5 * 2): " + result);
        System.out.println("With parentheses ((10 + 5) * 2): " + result2);
    }
}
