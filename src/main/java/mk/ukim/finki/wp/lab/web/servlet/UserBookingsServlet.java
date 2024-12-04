package mk.ukim.finki.wp.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mk.ukim.finki.wp.lab.repository.impl.inMemoryEventBookingRepository;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(urlPatterns = "/userBookings")
public class UserBookingsServlet extends HttpServlet {
    public final SpringTemplateEngine springTemplateEngine;
    public final inMemoryEventBookingRepository eventBookingRepository;
    public UserBookingsServlet(SpringTemplateEngine springTemplateEngine, inMemoryEventBookingRepository eventBookingRepository) {
        this.springTemplateEngine = springTemplateEngine;
        this.eventBookingRepository = eventBookingRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("name");
        context.setVariable("eventBookings", eventBookingRepository.findByAttendee(name));
        springTemplateEngine.process("userBookings.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
