package kafka;

import java.util.HashMap;
import java.util.Map;

public class Queue {
    private Map<String, Topic> topicMap;

    public Queue() {
        this.topicMap = new HashMap<>();
    }

    public Topic addTopic(String topicName) {
        Topic topic = new Topic(topicName);
        this.topicMap.put(topic.getTopicName(), topic);
        return topic;
    }

    public void addSubscriber(String topicName, ISubscriber subscriber) {
        topicMap.get(topicName).subscribe(new TopicSubscriber(subscriber));
    }

    public void publish(Topic topic, Message message) {
        topic.addMessage(message);
        System.out.println(message.getMessage() + " published to topic: " + topic.getTopicName());
        new Thread(() -> topicMap.get(topic.getTopicName()).publish()).start();
    }

    public void resetOffset(Topic topic, ISubscriber subscriber, Integer newOffset) {
        for (TopicSubscriber topicSubscriber : topic.getTopicSubscriberList()) {
            if (topicSubscriber.getSubscriber().equals(subscriber)) {
                topicSubscriber.getOffset().set(newOffset);
                System.out.println(topicSubscriber.getSubscriber().getId() + " offset reset to: " + newOffset);
                new Thread(() -> topicMap.get(topic.getTopicName()).startSubscriberWorker(topicSubscriber)).start();
                break;
            }
        }
    }
}
