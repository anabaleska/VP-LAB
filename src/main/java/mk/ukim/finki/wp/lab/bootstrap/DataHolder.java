package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Event;
import mk.ukim.finki.wp.lab.model.EventBooking;
import mk.ukim.finki.wp.lab.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
   public static List<Event> events = null;
   public static List<EventBooking> eventBookings = null;
   public static List<Location> locations = null;
//
//   @PostConstruct
//   public void init(){
//       Location location1 = new Location("Greenwood Community Center", "123 Maple Ave, Greenwood", "200", "A spacious community center with ample parking and facilities for small events and meetings.");
//       Location location2 = new Location("Silver Lake Conference Hall", "45 Elm Street, Silver Lake", "500", "A modern conference hall with state-of-the-art AV equipment, ideal for corporate gatherings.");
//       Location location3 = new Location("Sunset Beach Pavilion", "101 Ocean Drive, Sunset Beach", "100", "An open-air pavilion by the beach, perfect for small weddings and outdoor parties.");
//       Location location4 = new Location("Mountain View Lodge", "789 Mountain Rd, Pine Valley", "150", "A cozy lodge with beautiful mountain views, suitable for retreats and private events.");
//       Location location5 = new Location("Central Park Event Hall", "567 Oak St, Central City", "300", "A centrally located event hall, well-equipped for medium-sized gatherings and celebrations.");
//       events = new ArrayList<>();
//       events.add(new Event("Tech Innovations Expo", "A yearly exhibition showcasing cutting-edge technology and innovations from startups worldwide.", 88, location1));
//       events.add(new Event("Global Food Fest", "An international food festival featuring cuisines from over 50 countries, with live cooking demos.", 92, location2));
//       events.add(new Event("Music for Change Concert", "A charity concert with famous musicians performing to raise awareness for environmental conservation.", 85, location3));
//       events.add(new Event("Literature and Arts Fair", "A gathering of authors, poets, and artists, featuring book readings, art exhibits, and creative workshops.", 76, location1));
//       events.add(new Event("City Marathon", "An annual marathon event with thousands of participants, promoting health and community fitness.",80, location5));
//       events.add(new Event("Film Festival", "A week-long event showcasing independent films, with awards for various categories and director Q&A sessions.", 90, location1));
//       events.add(new Event("Science Fair", "A youth science fair featuring innovative projects by students and demonstrations by leading scientists.", 78, location4));
//       events.add(new Event("Vintage Car Show", "An outdoor event displaying classic and vintage cars, with awards for the best-preserved models.", 74, location3));
//       events.add(new Event("Startup Pitch Night", "A networking event where startups pitch their ideas to investors, followed by a networking session.", 84, location2));
//       events.add(new Event("Comic Con", "A large convention for comic, anime, and sci-fi enthusiasts, featuring cosplay, panel discussions, and merch stalls.", 95, location3));
//
//       eventBookings = new ArrayList<>();
//       eventBookings.add(new EventBooking("eventName", "attendeeName", "attendeeAddress", 2L));
//
//       locations = new ArrayList<>();
//       locations.add(location1);
//       locations.add(location2);
//       locations.add(location3);
//       locations.add(location4);
//       locations.add(location5);
//   }
}
