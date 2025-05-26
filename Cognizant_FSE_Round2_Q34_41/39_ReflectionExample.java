
import java.lang.reflect.Method;

class SampleClass {
    public void display(String msg) {
        System.out.println("Message: " + msg);
    }
}

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("SampleClass");
        Object obj = cls.getDeclaredConstructor().newInstance();
        Method method = cls.getDeclaredMethod("display", String.class);
        method.invoke(obj, "Hello using Reflection");
    }
}
