package mk.ukim.finki.wp.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.service.EventService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "")
public class EventListSevlet extends HttpServlet {

    public final EventService eventService;
    public final SpringTemplateEngine springTemplateEngine;

    public EventListSevlet(EventService eventService, SpringTemplateEngine springTemplateEngine) {
        this.eventService = eventService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        List<Event> events = eventService.listAll();
        String text = req.getParameter("text");
        String rating = req.getParameter("rating");

        if (text != null && rating != null) {
            if (!text.isEmpty() && !rating.isEmpty()) {
                events = eventService.searchEvents(text);
                List<Event> temp = eventService.searchByRating(Integer.parseInt(rating));
                events = temp.stream().filter(events::contains).collect(Collectors.toList());
            }

        }
        context.setVariable("events", events);
        springTemplateEngine.process("listEvents.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String eventName = req.getParameter("selected");

        String numTickets = req.getParameter("numTickets");
        String name = req.getParameter("name");

        req.getSession().setAttribute("name", name);
        req.getSession().setAttribute("eventName", eventName);
        req.getSession().setAttribute("numTickets", numTickets);
        resp.sendRedirect("/eventBooking");
    }
}
