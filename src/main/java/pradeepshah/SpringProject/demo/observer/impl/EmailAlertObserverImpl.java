package pradeepshah.SpringProject.demo.observer.impl;

import pradeepshah.SpringProject.demo.observable.service.StockObservable;
import pradeepshah.SpringProject.demo.observer.service.NotificationAlertObserver;

public class EmailAlertObserverImpl implements NotificationAlertObserver {
    String userName;
    StockObservable observable;
    public EmailAlertObserverImpl(String userName, StockObservable observable){
        this.userName=userName;
        this.observable = observable;
    }
    @Override
    public void update(){
        sendEmail(userName, " : product is in stock, hurry up");
    }
    void sendEmail(String userName, String msg){
        System.out.println(userName + msg);
    }
}
