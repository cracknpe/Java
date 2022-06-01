package cs.designpattern.singleton.bean;

/**
 * 饿汉模式
 * 运用enum来创建单例，类加载时就创建单例对象
 */
public enum Singleton4 {
    INSTANCE;
}
