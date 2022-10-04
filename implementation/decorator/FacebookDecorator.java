package implementation.decorator;

public class FacebookDecorator implements Notifier {
    private Notifier notifier;
    FacebookDecorator(Notifier n) {
        this.notifier = n;
    }
    @Override
    public void sendNotification() {
        notifier.sendNotification();
        System.out.println("Sending Facebook Notification");
    }
}
