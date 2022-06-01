package cs.designpattern.singleton.example;

public class Earth1 {

    /**
     * 饿汉模式
     */
    private static final Earth1 earth = new Earth1();

    private Earth1(){
        System.out.println("构造函数");
    }


    public static Earth1 getInstance(String threadName){
        return earth;
    }
}