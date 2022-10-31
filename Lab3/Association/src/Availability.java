import java.util.LinkedList;

public class Availability {
    private LinkedList<String> days;
    private LinkedList<String> hours;

    public Availability(LinkedList<String> d, LinkedList<String> h) {
        days = d;
        hours = h;
    }
}
