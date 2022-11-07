import java.time.Duration;
import java.util.Date;
import java.util.LinkedList;

public class Action {
    private String purpose;
    private Date date; // date
    private int duration; // minutes
    private LinkedList<InfoAction> developedAction;

    public Action(String p, Date dat, int dur) {
        purpose = p;
        date = dat;
        duration = dur;
        developedAction = new LinkedList<InfoAction>();
    }
    
    /*public void addHeadquarter(Headquarter h) {
        developedAction.setHeadquarter(h);
    }*/

    public Date getDate() {
        return date;
    }

    public String getPurpose() {
        return purpose;
    }

    public int getDuration() {
        return duration;
    }

    public LinkedList<InfoAction> getDevelopedAction() {
        return developedAction;
    }

    public boolean isPerforming(Date d) {
        if (d.compareTo(date) >= 0 && d.compareTo(Date.from(date.toInstant().plus(Duration.ofMinutes(duration)))) < 0) { return true; }
        return false;
    }
}
