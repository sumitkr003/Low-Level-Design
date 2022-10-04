package implementation.decorator;

public class Client {

	public static void main(String[] args) {
		Notifier decorator = new BaseDecorator();
		decorator = new FacebookDecorator(decorator);
		decorator = new SlackNotifier(decorator);
		decorator.sendNotification();
	}
}
