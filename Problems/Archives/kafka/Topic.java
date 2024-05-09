package kafka;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Topic {
    private String topicId;
    private String topicName;
    private List<Message> messages;
    private List<TopicSubscriber> topicSubscribers;
    private Map<String, SubscriberWorker> subscriberWorkers;

    public Topic(String topicName) {
        this.topicId = UUID.randomUUID().toString();
        this.topicName = topicName;
        this.messages = new ArrayList<>();
        this.topicSubscribers = new ArrayList<>();
        this.subscriberWorkers = new HashMap<>();
    }

    public String getTopicId() {
        return this.topicId;
    }
    public String getTopicName() {
        return this.topicName;
    }
    public List<Message> getMessages() {
        return this.messages;
    }
    public List<TopicSubscriber> getTopicSubscriberList() {
        return this.topicSubscribers;
    }

    public synchronized void addMessage(Message message) {
        System.out.println("Published message to topic : " + this.topicName);
        this.messages.add(message);
    }

    public void subscribe(TopicSubscriber topicSubscriber) {
        this.topicSubscribers.add(topicSubscriber);
        return;
    }

    public void publish() {
        for (TopicSubscriber topicSubscriber:this.getTopicSubscriberList()) {
            startSubscriberWorker(topicSubscriber);
        }
    }

    public void startSubscriberWorker(TopicSubscriber topicSubscriber) {
        final String subscriberId = topicSubscriber.getSubscriber().getId();
        if (!subscriberWorkers.containsKey(subscriberId)) {
            final SubscriberWorker subscriberWorker = new SubscriberWorker(this, topicSubscriber);
            subscriberWorkers.put(subscriberId, subscriberWorker);
            new Thread(subscriberWorker).start();
        }
        final SubscriberWorker subscriberWorker = subscriberWorkers.get(subscriberId);
        subscriberWorker.wakeUpIfNeeded();
    }
}
