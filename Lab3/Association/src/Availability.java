import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Availability {
    private LinkedList<Integer> days;
    private LinkedList<Integer> hours;

    /**
     * Creates an Availability from two strings: days and hours
     * @param d Days available in the form of a string so that it matches the RegEx "([a-z]+)"
     * @param h Hours available in the form of a string so that it matches the RegEx "([0-9]+)"
     */
    public Availability(String d, String h) {
        days = new LinkedList<Integer>();
        hours = new LinkedList<Integer>();
        String[] daysOfWeek = {"dilluns", "dimarts", "dimecres", "dijous", "divendres", "dissabte", "diumenge"};
        // We use indexOf(element) to convert from string to int, and ArrayList gives us that predefined method.
        ArrayList<String> daysArray = new ArrayList<String>(Arrays.asList(daysOfWeek));

        Pattern p = Pattern.compile("([a-z]+|[0-9]+)");
        Matcher m = p.matcher(d);
        while(m.find()) {
            days.add(daysArray.indexOf(m.group(0))+1); // We add 1 to match the method LocalDateTime.getDayOfWeek()
        }
        m = p.matcher(h);
        while(m.find()) {
            hours.add(Integer.parseInt(m.group(0)));
        }
    }

    public LinkedList<Integer> getDays() {
        return days;
    }

    public LinkedList<Integer> getHours() {
        return hours;
    }

    public String toString() {
        return days.toString().concat("\n").concat(hours.toString());
    }
}
