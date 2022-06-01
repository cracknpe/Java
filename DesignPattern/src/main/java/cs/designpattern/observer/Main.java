package cs.designpattern.observer;

import cs.designpattern.observer.action.ObserverAction;
import cs.designpattern.observer.action.SubjectAction;
import cs.designpattern.observer.impl.MyObserver;
import cs.designpattern.observer.impl.MySubject;

public class Main {
    public static void main(String[] args) {
        ObserverAction observer1 = new MyObserver("订阅者1号");
        ObserverAction observer2 = new MyObserver("订阅者2号");
        ObserverAction observer3 = new MyObserver("订阅者3号");
        ObserverAction observer4 = new MyObserver("订阅者4号");

        SubjectAction subject = new MySubject();

        System.out.println("报社新开张，订阅者门纷纷来订阅报纸");

        //订阅者1号 -> 订阅报纸
        subject.subscribe(observer1);
        //订阅者2号 -> 订阅报纸
        subject.subscribe(observer2);
        //订阅者3号 -> 订阅报纸
        subject.subscribe(observer3);
        //订阅者4号 -> 订阅报纸
        subject.subscribe(observer4);
        //报社通知：新报纸已经到了
        subject.notifyObservers();

        System.out.println("一段时间后，订阅者2号、3号两人觉得报纸看起来不方便，于是就退订了");

        //订阅者2号 -> 退订报纸
        subject.cancel(observer2);
        //订阅者3号 -> 退订报纸
        subject.cancel(observer3);
        subject.notifyObservers();
    }
}
