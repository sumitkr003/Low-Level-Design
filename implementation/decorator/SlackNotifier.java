package implementation.decorator;

public class SlackNotifier implements Notifier {
    private Notifier notifier;
    SlackNotifier(Notifier n) {
        this.notifier = n;
    }
    @Override
    public void sendNotification() {
        notifier.sendNotification();
        System.out.println("Sending Slack Notification");
    }
}
