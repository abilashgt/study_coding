/*
** http://www.tutorialspoint.com/java/java_generics.htm
*/

public class GenericClassTest<T> {

    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        GenericClassTest<Integer> integerObject = new GenericClassTest<Integer>();
        GenericClassTest<String> stringObject = new GenericClassTest<String>();

        integerObject.add(new Integer(10));
        stringObject.add(new String("Hello World"));

        System.out.printf("Integer Value :%d\n\n", integerObject.get());
        System.out.printf("String Value :%s\n", stringObject.get());
    }
}