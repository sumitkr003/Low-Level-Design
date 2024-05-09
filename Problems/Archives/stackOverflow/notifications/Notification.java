package stackOverflow.notifications;

public abstract class Notification {
    protected String content;

    public Notification(String content) {
        this.content = content;
    }

    public abstract void sendNotification();
}
