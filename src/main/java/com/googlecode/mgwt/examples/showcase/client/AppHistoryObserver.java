package com.googlecode.mgwt.examples.showcase.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.History;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.googlecode.mgwt.dom.client.event.mouse.HandlerRegistrationCollection;
import com.googlecode.mgwt.examples.showcase.client.activities.AboutPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.UIEntrySelectedEvent;
import com.googlecode.mgwt.examples.showcase.client.activities.UIEntrySelectedEvent.UIEntry;
import com.googlecode.mgwt.examples.showcase.client.activities.UIPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.animation.AnimationPlace;

import com.googlecode.mgwt.examples.showcase.client.activities.animation.TopicSelectedEvent;
import com.googlecode.mgwt.examples.showcase.client.activities.animationdone.VerifyCompassPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.carousel.CarouselPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.elements.ElementsPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.forms.FormsPlace;
import com.googlecode.mgwt.examples.showcase.client.activities.home.Topic;
import com.googlecode.mgwt.examples.showcase.client.event.ActionEvent;
import com.googlecode.mgwt.examples.showcase.client.event.ActionNames;
import com.googlecode.mgwt.examples.showcase.client.places.HomePlace;
import com.googlecode.mgwt.mvp.client.history.HistoryHandler;
import com.googlecode.mgwt.mvp.client.history.HistoryObserver;
import com.googlecode.mgwt.ui.client.MGWT;

public class AppHistoryObserver implements HistoryObserver {

    @Override
    public void onPlaceChange(Place place, HistoryHandler handler) {
    }

    @Override
    public void onHistoryChanged(Place place, HistoryHandler handler) {
    }

    @Override
    public void onAppStarted(Place place, HistoryHandler historyHandler) {
        if (MGWT.getOsDetection().isPhone()) {
            onPhoneNav(place, historyHandler);
        } else {
            // tablet
            onTabletNav(place, historyHandler);

        }

    }

    @Override
    public HandlerRegistration bind(EventBus eventBus, final HistoryHandler historyHandler) {

        HandlerRegistration addHandler = eventBus.addHandler(TopicSelectedEvent.getType(), new TopicSelectedEvent.Handler() {
            @Override
            public void onAnimationSelected(TopicSelectedEvent event) {

                Topic topic = event.getTopic();

                int animationName = topic.getCount();

                Place place = null;

                switch (animationName) {
                    case 0:
                        place = new VerifyCompassPlace();

                        break;


                    default:
                        // TODO log
                        place = new VerifyCompassPlace();
                        break;
                }

                if (MGWT.getOsDetection().isTablet()) {

                    historyHandler.replaceCurrentPlace(place);
                    historyHandler.goTo(place, true);
                } else {
                    historyHandler.goTo(place);
                }

            }
        });
        HandlerRegistration register3 = UIEntrySelectedEvent.register(eventBus, new UIEntrySelectedEvent.Handler() {
            @Override
            public void onAnimationSelected(UIEntrySelectedEvent event) {

                UIEntry entry = event.getEntry();

                Place place = null;

                switch (entry) {

                    case ELEMENTS:
                        place = new ElementsPlace();
                        break;
                    case FORMS:
                        place = new FormsPlace();
                        break;



                    case CAROUSEL:
                        place = new CarouselPlace();
                        break;

                    default:
                        break;
                }

                if (MGWT.getOsDetection().isTablet()) {

                    historyHandler.replaceCurrentPlace(place);
                    historyHandler.goTo(place, true);
                } else {
                    historyHandler.goTo(place);
                }

            }
        });

        HandlerRegistration register2 = ActionEvent.register(eventBus, ActionNames.BACK, new ActionEvent.Handler() {
            @Override
            public void onAction(ActionEvent event) {

                History.back();

            }
        });

        HandlerRegistration register = ActionEvent.register(eventBus, ActionNames.ANIMATION_END, new ActionEvent.Handler() {
            @Override
            public void onAction(ActionEvent event) {
                if (MGWT.getOsDetection().isPhone()) {
                    History.back();
                } else {
                    historyHandler.goTo(new AnimationPlace(), true);
                }

            }
        });

        HandlerRegistrationCollection col = new HandlerRegistrationCollection();
        col.addHandlerRegistration(register);
        col.addHandlerRegistration(register2);
        col.addHandlerRegistration(register3);
        col.addHandlerRegistration(addHandler);
        return col;
    }

    private void onPhoneNav(Place place, HistoryHandler historyHandler) {
        if (place instanceof VerifyCompassPlace) {

            historyHandler.replaceCurrentPlace(new HomePlace());

            historyHandler.pushPlace(new AnimationPlace());

        } else {
            if (place instanceof AboutPlace) {
                historyHandler.replaceCurrentPlace(new HomePlace());

            } else {
                if (place instanceof AnimationPlace) {
                    historyHandler.replaceCurrentPlace(new HomePlace());
                } else {
                    if (place instanceof UIPlace) {
                        historyHandler.replaceCurrentPlace(new HomePlace());
                    } else {
                        if (place instanceof UIPlace) {
                            historyHandler.replaceCurrentPlace(new HomePlace());
                        } else {

                            if (place instanceof CarouselPlace
                                    || place instanceof ElementsPlace || place instanceof FormsPlace) {
                                historyHandler.replaceCurrentPlace(new HomePlace());

                                historyHandler.pushPlace(new UIPlace());
                            }

                        }
                    }
                }
            }
        }
    }

    private void onTabletNav(Place place, HistoryHandler historyHandler) {
        if (place instanceof VerifyCompassPlace) {

            historyHandler.replaceCurrentPlace(new HomePlace());

        } else {
            if (place instanceof AboutPlace) {
                historyHandler.replaceCurrentPlace(new HomePlace());
            } else {
                if (place instanceof AnimationPlace) {
                    historyHandler.replaceCurrentPlace(new HomePlace());
                } else {
                    if (place instanceof UIPlace) {
                        historyHandler.replaceCurrentPlace(new HomePlace());
                    } else {
                        if (place instanceof UIPlace) {
                            historyHandler.replaceCurrentPlace(new HomePlace());
                        } else {

                            if (place instanceof CarouselPlace
                                    || place instanceof ElementsPlace || place instanceof FormsPlace) {
                                historyHandler.replaceCurrentPlace(new HomePlace());

                            }

                        }
                    }
                }
            }
        }
    }
}
