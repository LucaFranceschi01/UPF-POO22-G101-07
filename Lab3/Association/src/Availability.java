import java.io.ObjectInputStream.GetField;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Availability {
    private LinkedList<String> days;
    private LinkedList<String> hours;

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
}
