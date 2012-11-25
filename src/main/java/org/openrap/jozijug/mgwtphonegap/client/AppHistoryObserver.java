package org.openrap.jozijug.mgwtphonegap.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.History;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.googlecode.mgwt.dom.client.event.mouse.HandlerRegistrationCollection;

import org.openrap.jozijug.mgwtphonegap.client.activities.testphonegap.TestPhoneGapPlace;

import org.openrap.jozijug.mgwtphonegap.client.activities.testphonegap.TopicSelectedEvent;
import org.openrap.jozijug.mgwtphonegap.client.activities.compass.VerifyCompassPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.carousel.CarouselPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.elements.ElementsPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.forms.FormsPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.gps.VerifyGPSPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.home.Topic;
import org.openrap.jozijug.mgwtphonegap.client.event.ActionEvent;
import org.openrap.jozijug.mgwtphonegap.client.event.ActionNames;
import org.openrap.jozijug.mgwtphonegap.client.places.HomePlace;
import com.googlecode.mgwt.mvp.client.history.HistoryHandler;
import com.googlecode.mgwt.mvp.client.history.HistoryObserver;
import com.googlecode.mgwt.ui.client.MGWT;
import org.openrap.jozijug.mgwtphonegap.client.activities.AboutPlace;
import org.openrap.jozijug.mgwtphonegap.client.activities.UIEntrySelectedEvent;
import org.openrap.jozijug.mgwtphonegap.client.activities.UIEntrySelectedEvent.UIEntry;
import org.openrap.jozijug.mgwtphonegap.client.activities.UIPlace;

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
            public void onTopicSelectedEventSelected(TopicSelectedEvent event) {

                Topic topic = event.getTopic();

                int topicIndex = topic.getCount();

                Place place = null;

                switch (topicIndex) {
                    case 1:
                        place = new VerifyCompassPlace();

                        break;
                    case 2:
                        place = new VerifyGPSPlace();

                        break;

                    default:
                        GWT.log("Warning Place not found "+topicIndex);
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
                    historyHandler.goTo(new TestPhoneGapPlace(), true);
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
        if (place instanceof VerifyCompassPlace || (place instanceof VerifyGPSPlace)) {

            historyHandler.replaceCurrentPlace(new HomePlace());

            historyHandler.pushPlace(new TestPhoneGapPlace());

        } else {
            if (place instanceof AboutPlace) {
                historyHandler.replaceCurrentPlace(new HomePlace());

            } else {
                if (place instanceof TestPhoneGapPlace) {
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
        if (place instanceof VerifyCompassPlace || (place instanceof VerifyGPSPlace)) {

            historyHandler.replaceCurrentPlace(new HomePlace());

        } else {
            if (place instanceof AboutPlace) {
                historyHandler.replaceCurrentPlace(new HomePlace());
            } else {
                if (place instanceof TestPhoneGapPlace) {
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
