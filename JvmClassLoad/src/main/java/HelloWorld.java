public class HelloWorld {

    private static int i = 3;

    static {
        System.out.println("init");
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    public void test(){
        System.out.println("test");
    }
}

