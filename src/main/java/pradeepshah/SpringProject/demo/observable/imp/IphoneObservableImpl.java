package pradeepshah.SpringProject.demo.observable.imp;

import pradeepshah.SpringProject.demo.observable.service.StockObservable;
import pradeepshah.SpringProject.demo.observer.service.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable {
    public List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public int getStockCount() {
        return stockCount;
    }

    @Override
    public void notifySubscribers() {
        for (NotificationAlertObserver observer : observerList) {
            observer.update();
        }
    }

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void setStockCount(int newStockAdd) {
        if (stockCount == 0) {
            notifySubscribers();
        }
        stockCount = stockCount + newStockAdd;
    }
}
