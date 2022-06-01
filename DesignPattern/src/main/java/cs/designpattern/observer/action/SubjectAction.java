package cs.designpattern.observer.action;

import cs.designpattern.observer.action.ObserverAction;

public interface SubjectAction {
   void subscribe(ObserverAction observerAction);
   void cancel(ObserverAction observerAction);
   void notifyObservers();
}
