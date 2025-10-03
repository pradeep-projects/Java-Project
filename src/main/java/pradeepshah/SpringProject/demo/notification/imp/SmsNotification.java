package pradeepshah.SpringProject.demo.notification.imp;

import org.springframework.stereotype.Component;
import pradeepshah.SpringProject.demo.notification.service.Notification;

@Component
// single responsibility principle
public class SmsNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("sms message sent: "  + message);
    }
}
