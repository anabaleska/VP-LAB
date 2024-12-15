//package mk.ukim.finki.wp.lab.repository.impl;
//
//import mk.ukim.finki.wp.lab.model.Event;
//import mk.ukim.finki.wp.lab.model.Location;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import static mk.ukim.finki.wp.lab.bootstrap.DataHolder.events;
//
//@Repository
//public class InMemoryEventRepository {
//
//    public final InMemoryLocationRepository locationRepository;
//
//    public InMemoryEventRepository(InMemoryLocationRepository locationRepository) {
//        this.locationRepository = locationRepository;
//    }
//
//    public List<Event> findAll(){
//        return events;
//    }
//
//    public List<Event> searchEvents(String text){
//       return events.stream().filter(event -> event.getName().contains(text) ||
//               event.getDescription().contains(text)).collect(Collectors.toList());
//    }
//
//    public List<Event> searchByRating(int rating){
//        return events.stream().filter(event -> event.getPopularityScore() >= rating)
//                .collect(Collectors.toList());
//    }
//    public Event saveEvent(String name, String description, double popularityScore, Long locationId){
//        Location location = locationRepository.findById(locationId).get();
//        events.removeIf(event -> event.getName().equals(name));
//        Event event = new Event(name, description, popularityScore, location);
//        events.add(event);
//        return event;
//    }
//    public Optional<Event> findById(Long id){
//        return events.stream().filter(event -> event.getId().equals(id)).findFirst();
//    }
//    public void delete(Long id){
//        events.removeIf(event -> event.getId().equals(id));
//    }
//}
