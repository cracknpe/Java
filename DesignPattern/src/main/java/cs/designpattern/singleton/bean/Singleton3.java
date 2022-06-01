package cs.designpattern.singleton.bean;

/**
 * 懒汉模式
 * 运用内部类写法，做到使用时创建单例对象
 */
public class Singleton3 {

    static {
        System.out.println("外部类初始化....");
    }

    private Singleton3() {
    }

    private static class SingletonHolder {
        static {
            System.out.println("内部类初始化");
        }

        private static final Singleton3 INSTANCE = new Singleton3();
    }

    public static final Singleton3 getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void test(){
        System.out.println("test....");
    }
}