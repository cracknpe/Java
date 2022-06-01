package cs.designpattern.singleton.bean;

/**
 * 饿汉模式
 * 类加载时直接创建单例对象
 */
public class Singleton1 {
    private static Singleton1 singleton = new Singleton1();

    private Singleton1(){

    }

    public Singleton1 getInstance(){
        return singleton;
    }
}
