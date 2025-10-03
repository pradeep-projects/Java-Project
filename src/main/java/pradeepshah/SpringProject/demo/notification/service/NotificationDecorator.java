package pradeepshah.SpringProject.demo.notification.service;

class NotificationDecorator implements Notification {
    protected Notification wrappee;
    NotificationDecorator(Notification wrappee) { this.wrappee = wrappee; }
    public void send(String message) { wrappee.send(message); }

}

class LoggingDecorator extends NotificationDecorator {
    LoggingDecorator(Notification wrappee) { super(wrappee); }
    public void send(String message) {
        System.out.println("[LOG] Sending: " + message);
        super.send(message);
    }
}

class EncryptionDecorator extends NotificationDecorator {
    EncryptionDecorator(Notification wrappee) { super(wrappee); }
    public void send(String message) {
        message = "Encrypted(" + message + ")";
        super.send(message);
    }
}