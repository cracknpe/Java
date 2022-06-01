package cs.designpattern.observer.impl;

import cs.designpattern.observer.action.ObserverAction;
import cs.designpattern.observer.action.SubjectAction;

import java.util.ArrayList;
import java.util.List;

public class MySubject implements SubjectAction {

    List<ObserverAction> observerActionList = new ArrayList<>();

    @Override
    public void subscribe(ObserverAction observerAction) {
        observerActionList.add(observerAction);
    }

    @Override
    public void cancel(ObserverAction observerAction) {
        observerActionList.remove(observerAction);
    }

    @Override
    public void notifyObservers() {
        for(ObserverAction observerAction : observerActionList){
            observerAction.update();
        }
    }


}
