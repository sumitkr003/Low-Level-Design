package stackOverflow.notifications;

public class EmailNotification extends Notification{
    private String emailId;

    public EmailNotification(String content, String emailId) {
        super(content);
        this.emailId = emailId;
    }

    @Override
    public void sendNotification() {
        System.out.println("Email Notification : " + this.content);
    }
}
