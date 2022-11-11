import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Availability {
    private LinkedList<String> days;
    private LinkedList<String> hours;

    /**
     * Creates an Availability from two strings: days and hours availability
     * @param d Days available in the form of a string so that it matches the RegEx "([a-z]+)"
     * @param h Hours available in the form of a string so that it matches the RegEx "([0-9]+)"
     */
    public Availability(String d, String h) {
        days = new LinkedList<String>();
        hours = new LinkedList<String>();
        Pattern p = Pattern.compile("([a-z]+|[0-9]+)");
        Matcher m = p.matcher(d);
        while(m.find()) {
            days.add(m.group(0));
        }
        m = p.matcher(h);
        while(m.find()) {
            hours.add(m.group(0));
        }
    }

    public LinkedList<String> getDays() {
        return days;
    }

    public LinkedList<String> getHours() {
        return hours;
    }

    public String toString() {
        return days.toString().concat("\n").concat(hours.toString());
    }
}
