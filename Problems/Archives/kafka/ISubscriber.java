package kafka;

public interface ISubscriber {
    String getId();
    void consume(Message message) throws InterruptedException;
}
