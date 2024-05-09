package stackOverflow.notifications;

public class SmsNotification extends Notification{
    private String mobile;
    public SmsNotification(String content, String mobile) {
        super(content);
        this.mobile = mobile;
    }

    @Override
    public void sendNotification() {
        System.out.println("Sms Notification : " + this.content);
    }
}
