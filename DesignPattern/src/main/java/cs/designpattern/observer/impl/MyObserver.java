package cs.designpattern.observer.impl;

import cs.designpattern.observer.action.ObserverAction;

public class MyObserver implements ObserverAction {

    private String name;

    public MyObserver(String name){
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(this.name + "订阅了一份报纸");
    }
}
