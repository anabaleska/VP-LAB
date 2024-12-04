package mk.ukim.finki.wp.lab.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.wp.lab.service.EventBookingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/eventBooking")
public class EventBookingController {
    public final EventBookingService eventBookingService;

    public EventBookingController(EventBookingService eventBookingService) {
        this.eventBookingService = eventBookingService;
    }

    @PostMapping("/confirmation")
    public String getEventBookingPage(@RequestParam String eventName, @RequestParam String name, @RequestParam String numTickets, Model model, HttpServletRequest request) {

        String address = request.getRemoteAddr();
        model.addAttribute("eventName", eventName);
        model.addAttribute("name", name);
        model.addAttribute("address", address);
        model.addAttribute("numTickets", numTickets);

        eventBookingService.placeBooking(eventName, name, address, Long.valueOf(numTickets));
        return "bookingConfirmation";
    }
}
