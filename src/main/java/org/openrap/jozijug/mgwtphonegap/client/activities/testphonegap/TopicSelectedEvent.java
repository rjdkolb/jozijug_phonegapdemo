package org.openrap.jozijug.mgwtphonegap.client.activities.testphonegap;

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.EventBus;
import org.openrap.jozijug.mgwtphonegap.client.activities.home.Topic;

public class TopicSelectedEvent extends Event<TopicSelectedEvent.Handler> {

    public interface Handler {

        void onTopicSelectedEventSelected(TopicSelectedEvent event);
    }
    private static final Type<TopicSelectedEvent.Handler> TYPE = new Type<TopicSelectedEvent.Handler>();
    private final Topic topic;

    public static void fire(EventBus eventBus, Topic animation) {
        eventBus.fireEvent(new TopicSelectedEvent(animation));
    }

    @Override
    public com.google.web.bindery.event.shared.Event.Type<Handler> getAssociatedType() {
        return TYPE;
    }

    protected TopicSelectedEvent(Topic topic) {
        this.topic = topic;

    }

    @Override
    protected void dispatch(Handler handler) {
        handler.onTopicSelectedEventSelected(this);

    }

    public static Type<TopicSelectedEvent.Handler> getType() {
        return TYPE;
    }

    public Topic getTopic() {
        return topic;
    }
}
