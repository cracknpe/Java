package cs.designpattern.singleton.example;

public class Earth2 {

    private static Earth2 earth;

    private Earth2(){
        System.out.println("构造函数");
    }

    /**
     * 懒汉模式
     */
    public static Earth2 getInstance(String threadName){
        if(earth == null){
            synchronized (Earth2.class){
                if(earth == null){
                    earth = new Earth2();
                }
            }
        }
        return earth;
    }
}
