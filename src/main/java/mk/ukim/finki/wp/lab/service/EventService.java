package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Event;
import java.util.List;
import java.util.Optional;

public interface EventService {


    List<Event> listAll();
    List<Event> searchEvents(String text);
    List<Event> searchByRating(int rating);
    Event saveEvent(String name, String description, double popularityScore, Long locationId);
    Optional<Event> findById(Long id);
    public void delete(Long id);
    Optional<Event> findByName(String name);

}
