package pradeepshah.SpringProject.demo.notification.imp;

import org.springframework.stereotype.Component;
import org.w3c.dom.Notation;
import pradeepshah.SpringProject.demo.notification.service.Notification;

@Component
// single responsibility principle
public class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("push message sent: "  + message);
    }
}
