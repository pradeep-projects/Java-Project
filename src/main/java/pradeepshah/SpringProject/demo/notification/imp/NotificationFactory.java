package pradeepshah.SpringProject.demo.notification.imp;

import org.springframework.stereotype.Component;
import pradeepshah.SpringProject.demo.notification.service.Notification;

@Component
// factory design pattern
public class NotificationFactory {
    public static Notification createNotification(String type){
        return switch (type){
            case "Email" -> new EmailNotification();
            case "SMS" -> new SmsNotification();
            case "PUSH" -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown type");
        };
    }
}
