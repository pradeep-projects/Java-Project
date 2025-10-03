package pradeepshah.SpringProject.demo.observer.impl;

import pradeepshah.SpringProject.demo.observable.service.StockObservable;
import pradeepshah.SpringProject.demo.observer.service.NotificationAlertObserver;

public class MobileAlertObserverImpl implements NotificationAlertObserver {
    String emailId;
    StockObservable observable;
    public MobileAlertObserverImpl(String emailId, StockObservable observable){
        this.emailId = emailId;
        this.observable = observable;
    }
    @Override
    public void update(){
        sendSmsOnMobile(emailId, "product is in stock, hurry up");
    }
    void sendSmsOnMobile(String userName, String msg){
        System.out.println(msg);
    }

}
