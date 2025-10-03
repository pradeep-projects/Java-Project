package pradeepshah.SpringProject.demo.notification.service;

import pradeepshah.SpringProject.demo.notification.imp.NotificationFactory;

// combining patterns
public class NotificationService {
    private MessageFormatter formatter;

    NotificationService(MessageFormatter formatter){
        this.formatter = formatter;
    }

    public void sendNotification(String type, String message){
        Notification notification = NotificationFactory.createNotification(type);

        notification = new LoggingDecorator(notification);
        notification  = new EncryptionDecorator(notification);

        // Apply formatting (Strategy)
        String formattedMessage = formatter.format(message);

        // Send
        notification.send(formattedMessage);
    }
}
