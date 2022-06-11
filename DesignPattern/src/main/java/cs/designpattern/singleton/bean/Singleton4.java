package cs.designpattern.singleton.bean;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

/**
 * 饿汉模式
 * 运用enum来创建单例，类加载时就创建单例对象
 */
public enum Singleton4 {
    INSTANCE("instance",1),
    INSTANCE1("instance",2);

    private String name;
    private int id;

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    private Singleton4(String name ,int id){
        this.name = name;
        this.id = id;
    }

    public Singleton4 getEnumFromId(int id){
        for (Singleton4 singleton4 : values()){
            if(singleton4.getId() == id){
                return singleton4;
            }
        }
        return null;
    }



}