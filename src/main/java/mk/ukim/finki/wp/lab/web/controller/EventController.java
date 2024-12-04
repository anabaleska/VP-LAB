package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.EventBooking;
import mk.ukim.finki.wp.lab.model.Location;
import mk.ukim.finki.wp.lab.service.impl.EventBookingServiceImpl;
import mk.ukim.finki.wp.lab.service.impl.EventServiceImpl;
import mk.ukim.finki.wp.lab.service.impl.LocationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    public final EventServiceImpl eventService;
    public final LocationServiceImpl locationService;
    public final EventBookingServiceImpl eventBookingService;

    public EventController(EventServiceImpl eventService, LocationServiceImpl locationService, EventBookingServiceImpl eventBookingService) {
        this.eventService = eventService;
        this.locationService = locationService;
        this.eventBookingService = eventBookingService;
    }

    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Event> eventList = eventService.listAll();
        model.addAttribute("events", eventList);
        return "listEvents";
    }

    @GetMapping("/add-event")
    public String addEvent(Model model){
        List<Location> locationList = locationService.findAll();
        model.addAttribute("locations", locationList);
        return "add-event";
    }


    @PostMapping("/add")
    public String saveEvent(@RequestParam String eventName, @RequestParam String eventDescription, @RequestParam double popularityScore, @RequestParam Long locationId){
        eventService.saveEvent(eventName, eventDescription, popularityScore, locationId);
        return "redirect:/events";
    }

    @GetMapping("edit/{eventId}")
    public String editEvent(@PathVariable Long eventId, Model model){
        if(eventService.findById(eventId).isPresent()){
            Event event = eventService.findById(eventId).get();
            List<Location> locationList = locationService.findAll();
            model.addAttribute("event", event);
            model.addAttribute("locations", locationList);
            return "add-event";
        } else {
            return "redirect:/events?error=EventNotFound";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id){
        eventService.delete(id);
        return "redirect:/events";
    }

    @GetMapping("/detail/{eventId}")
    public String detailEvent(@PathVariable Long eventId, Model model){
        Event event = eventService.findById(eventId).get();
        List<EventBooking> eventBookings = eventBookingService.findByName(event.getName());
        model.addAttribute("event", event);
        model.addAttribute("eventBookings", eventBookings);
        return "detailEvent";
    }

}
