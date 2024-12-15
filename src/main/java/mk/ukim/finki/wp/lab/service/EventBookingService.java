package mk.ukim.finki.wp.lab.service;
import java.util.List;

import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.EventBooking;

public interface EventBookingService {
    EventBooking placeBooking(String event, String attendeeName, String attendeeAddress, Long numberOfTickets);
    List<EventBooking> findByName(String name);
    String findByAttendeeName(String name);
}
