package mk.ukim.finki.wp.lab.model.exceptions;
public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(String eventName) {
        super(String.format("Event with name '%s' not found", eventName));
    }
}