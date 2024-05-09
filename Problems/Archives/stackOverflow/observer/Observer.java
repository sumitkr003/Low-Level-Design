package stackOverflow.observer;

import stackOverflow.content.Content;

public abstract class Observer {
    protected Content content;

    public Observer(Content content) {
        this.content = content;
        this.content.attach(this);
    }

    public abstract void update();

    public Content getContent() {
        return content;
    }
}
