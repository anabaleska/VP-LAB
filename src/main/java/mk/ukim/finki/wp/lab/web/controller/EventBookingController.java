package mk.ukim.finki.wp.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.service.EventBookingService;
import mk.ukim.finki.wp.lab.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/eventBooking")
public class EventBookingController {
    public final EventBookingService eventBookingService;
    public final EventService eventService;

    public EventBookingController(EventBookingService eventBookingService, EventService eventService) {
        this.eventBookingService = eventBookingService;
        this.eventService = eventService;
    }

    @PostMapping("/confirmation")
    public String getEventBookingPage(@RequestParam Long eventId, @RequestParam String name, @RequestParam String numTickets, Model model, HttpServletRequest request) {

        Event event = eventService.findById(eventId).get();
        String address = request.getRemoteAddr();
        model.addAttribute("eventName", event.getName());
        model.addAttribute("name", name);
        model.addAttribute("address", address);
        model.addAttribute("numTickets", numTickets);
        eventBookingService.placeBooking(event.getName(), name, address, Long.valueOf(numTickets));
        return "bookingConfirmation";
    }
}
