
public class UsingJavapToInspectBytecode {
    public static void sayHello() {
        System.out.println("Hello from bytecode!");
    }

    public static void main(String[] args) {
        sayHello();
    }
}
// Compile: javac UsingJavapToInspectBytecode.java
// Inspect: javap -c UsingJavapToInspectBytecode
