package cs.designpattern.singleton.bean;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        testSingle3();
    }

    public static void testSingle1()  throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        //直接获取单例对象，输出
        System.out.println(Singleton1.getInstance());

        //反射获取单例对象，输出
        Class clazz = Class.forName("cs.designpattern.singleton.bean.Singleton1");
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton1 singleton1 = (Singleton1) constructor.newInstance(null);
        System.out.println(singleton1);
    }

    public static void testSingle2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println(Singleton2.getInstance());
        //反射获取单例对象，输出
        Class clazz = Class.forName("cs.designpattern.singleton.bean.Singleton2");
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton2 singleton2 = (Singleton2) constructor.newInstance(null);
        System.out.println(singleton2);
    }

    public static void testSingle3() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        System.out.println(Singleton3.getInstance());
        //反射获取单例对象，输出
        Class clazz = Class.forName("cs.designpattern.singleton.bean.Singleton3");
        Constructor constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton3 singleton3 = (Singleton3) constructor.newInstance(null);
        System.out.println(singleton3);
    }

    public static void testSingle4()  throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        //直接获取单例对象，输出
        System.out.println(Singleton4.INSTANCE);

        //反射获取单例对象，输出
        Class clazz = Class.forName("cs.designpattern.singleton.bean.Singleton4");
        Constructor[] constructors = clazz.getDeclaredConstructors();
        Constructor constructor = constructors[0];
        constructor.setAccessible(true);
        Singleton4 singleton4 = (Singleton4) constructor.newInstance("INSTANCE",0,"instance",1);
        System.out.println(singleton4);
    }
}
