package kafka;

import java.util.concurrent.atomic.AtomicInteger;

public class TopicSubscriber {
    private AtomicInteger offset;
    private ISubscriber iSubscriber;

    public TopicSubscriber(ISubscriber iSubscriber) {
        this.iSubscriber = iSubscriber;
        this.offset = new AtomicInteger(0);
    }
    public AtomicInteger getOffset() {
        return this.offset;
    }
    public ISubscriber getSubscriber() {
        return this.iSubscriber;
    }
}
