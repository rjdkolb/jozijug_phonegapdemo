package com.googlecode.mgwt.examples.showcase.client.activities.animation;

import com.google.web.bindery.event.shared.Event;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.examples.showcase.client.activities.home.Topic;

public class TopicSelectedEvent extends Event<TopicSelectedEvent.Handler> {

	public interface Handler {
		void onAnimationSelected(TopicSelectedEvent event);
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
		handler.onAnimationSelected(this);

	}

	public static Type<TopicSelectedEvent.Handler> getType() {
		return TYPE;
	}

	public Topic getTopic() {
		return topic;
	}

}