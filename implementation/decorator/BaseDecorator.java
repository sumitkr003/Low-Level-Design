package implementation.decorator;

public class BaseDecorator implements  Notifier {
    @Override
    public void sendNotification() {
        System.out.println("Sending Email Notification");
    }
}
