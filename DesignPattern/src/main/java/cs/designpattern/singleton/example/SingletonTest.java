package cs.designpattern.singleton.example;

import java.util.ArrayList;
import java.util.List;

public class SingletonTest{
    /*
     *多线程测试
     */
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Earth2.getInstance(Thread.currentThread().getName());
            }
        };

        List<Thread> list = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            Thread thread = new Thread(runnable);
            list.add(thread);
        }

        for(int i = 0; i < 20; i++){
            list.get(i).start();
        }

    }
}