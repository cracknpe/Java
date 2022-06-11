package cs.designpattern.singleton.bean;


/**
 * 懒汉模式
 * 使用时创建单例对象
 */
public class Singleton2 {
    private static volatile  Singleton2 singleton;

    private Singleton2(){
    }

    public static Singleton2 getInstance(){
        Singleton2 temp = singleton;
        if (temp == null){
            synchronized (Singleton2.class){
                if(temp == null)
                    singleton = new Singleton2();
            }
        }
        return singleton;
    }
}
