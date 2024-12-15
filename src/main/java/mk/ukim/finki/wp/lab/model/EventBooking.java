package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class EventBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String attendeeName;
    String attendeeAddress;
    Long numberOfTickets;
    @ManyToOne
    Event event;
    public EventBooking(Event event, String attendeeName, String attendeeAddress, Long numberOfTickets) {
        this.event = event;
        this.attendeeName = attendeeName;
        this.attendeeAddress = attendeeAddress;
        this.numberOfTickets = numberOfTickets;
    }

    public EventBooking() {

    }
}
