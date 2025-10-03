package pradeepshah.SpringProject.demo.notification.service;

//

import java.util.ArrayList;
import java.util.List;

public interface Observer {
    public void update(String message);
}

class UserSubscriber implements Observer {
    private String name;
    UserSubscriber(String name) { this.name = name; }
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

class NotificationPublisher {
    private List<Observer> observers = new ArrayList<>();
    void subscribe(Observer o) { observers.add(o); }
    void unsubscribe(Observer o) { observers.remove(o); }
    void notifyAllObservers(String msg) {
        for (Observer o : observers) o.update(msg);
    }
}
