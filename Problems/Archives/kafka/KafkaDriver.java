package kafka;

public class KafkaDriver {

    public static void main(String[] args) throws InterruptedException {
        final Queue queue = new Queue();
        final Topic topic1 = queue.addTopic("t1");
        final Topic topic2 = queue.addTopic("t2");
        final Subscriber sub1 = new Subscriber("sub1", 10000);
        final Subscriber sub2 = new Subscriber("sub2", 10000);
        queue.addSubscriber(topic1.getTopicName(), sub1);
        queue.addSubscriber(topic1.getTopicName(), sub2);

        final Subscriber sub3 = new Subscriber("sub3", 5000);
        queue.addSubscriber(topic2.getTopicName(), sub3);

        queue.publish(topic1, new Message("m1"));
        queue.publish(topic1, new Message("m2"));

        queue.publish(topic2, new Message("m3"));

        Thread.sleep(15000);
        queue.publish(topic2, new Message("m4"));
        queue.publish(topic1, new Message("m5"));

        queue.resetOffset(topic1, sub1, 0);
    }
}
