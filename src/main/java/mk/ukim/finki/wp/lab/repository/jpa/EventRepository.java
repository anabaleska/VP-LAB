package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByLocation_Id(Long locationId);
    List<Event> findALLByNameContaining(String name);
    List<Event> findAllByPopularityScoreIsGreaterThanEqual(double rating);
    void deleteById(Long id);
    Optional<Event> findByName(String name);
    Optional<Event> findById(Long id);
}
