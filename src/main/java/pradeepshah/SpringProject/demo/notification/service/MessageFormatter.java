package pradeepshah.SpringProject.demo.notification.service;

interface MessageFormatter {
    String format(String message);
}


class UpperCaseFormatter implements MessageFormatter {
    public String format(String message) { return message.toUpperCase(); }
}

class LowerCaseFormatter implements MessageFormatter {
    public String format(String message) { return message.toLowerCase(); }
}