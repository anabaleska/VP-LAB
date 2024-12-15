package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.EventBooking;
import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.exceptions.EventNotFoundException;
import mk.ukim.finki.wp.lab.repository.jpa.EventBookingRepository;
import mk.ukim.finki.wp.lab.repository.jpa.EventRepository;
import mk.ukim.finki.wp.lab.service.EventBookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventBookingServiceImpl implements EventBookingService {

    public final EventBookingRepository eventBookingRepository;
    public final EventRepository eventRepository;

    public EventBookingServiceImpl(EventBookingRepository eventBookingRepository, EventRepository eventRepository) {
        this.eventBookingRepository = eventBookingRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public EventBooking placeBooking(String event, String attendeeName, String attendeeAddress, Long numberOfTickets) {
        Event eventName = eventRepository.findByName(event).orElseThrow(()->new EventNotFoundException(event));
        EventBooking eventBooking = new EventBooking(eventName, attendeeName, attendeeAddress, numberOfTickets);
        return eventBookingRepository.save(eventBooking);
    }

    @Override
    public List<EventBooking> findByName(String name) {
        return eventBookingRepository.findByEventName(name);
    }

    @Override
    public String findByAttendeeName(String name) {
        return eventBookingRepository.findByAttendeeName(name);
    }
}
