package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.Location;
import mk.ukim.finki.wp.lab.repository.jpa.EventRepository;
import mk.ukim.finki.wp.lab.repository.jpa.LocationRepository;
import mk.ukim.finki.wp.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    public final EventRepository eventRepository;
    public final LocationRepository locationRepository;

    public EventServiceImpl(EventRepository eventRepository, LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text) {
        return eventRepository.findALLByNameContaining(text);
    }

    @Override
    public List<Event> searchByRating(int rating) {
        return eventRepository.findAllByPopularityScoreIsGreaterThanEqual(rating);
    }

    @Override
    public Event saveEvent(String name, String description, double popularityScore, Long locationId) {
        Optional<Location> location = locationRepository.findById(locationId);
        return eventRepository.save(new Event(name, description, popularityScore, location.get()));
    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

}
