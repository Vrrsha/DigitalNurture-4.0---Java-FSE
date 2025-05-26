public class TypeCastingExample {
    public static void main(String[] args) {
        double doubleVal = 9.99;
        int intVal = (int) doubleVal;

        int originalInt = 10;
        double castedDouble = originalInt;

        System.out.println("Double to Int: " + intVal);
        System.out.println("Int to Double: " + castedDouble);
    }
}
