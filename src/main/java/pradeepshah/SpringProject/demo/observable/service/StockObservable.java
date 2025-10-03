package pradeepshah.SpringProject.demo.observable.service;

import pradeepshah.SpringProject.demo.observer.service.NotificationAlertObserver;

public interface StockObservable {
    public void add(NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);
    public void notifySubscribers();
    public void setStockCount(int newStockAdd);
    public int getStockCount();
}
