package mk.ukim.finki.wp.lab.repository.jpa;


import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.EventBooking;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventBookingRepository extends JpaRepository<EventBooking, Long> {
   List<EventBooking> findByEventName(String name);
   EventBooking save(EventBooking eventBooking);

   String findByAttendeeName(String name);

}
