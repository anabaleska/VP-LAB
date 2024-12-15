//package mk.ukim.finki.wp.lab.repository.impl;
//
//import mk.ukim.finki.wp.lab.model.EventBooking;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static mk.ukim.finki.wp.lab.bootstrap.DataHolder.eventBookings;
//
//@Repository
//public class inMemoryEventBookingRepository {
//    public EventBooking saveEventBooking(EventBooking eventBooking) {
//        eventBookings.add(eventBooking);
//        return eventBooking;
//    }
//
//    public List<EventBooking> findByAttendee(String name){
//        return eventBookings.stream().filter(eventBooking -> eventBooking.getAttendeeName().equals(name)).collect(Collectors.toList());
//    }
//
//    public List<EventBooking> findByEventName(String name){
//        return eventBookings.stream().filter(eventBooking -> eventBooking.getEventName().equals(name)).collect(Collectors.toList());
//    }
//
//}
