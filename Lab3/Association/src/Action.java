import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class Action {
    private String purpose;
    private LocalDateTime date; // date
    private int duration; // minutes
    private LinkedList<InfoAction> infoActions; // not 

    public Action(String p, LocalDateTime dat, int dur) {
        purpose = p;
        date = dat;
        duration = dur;
        infoActions = new LinkedList<InfoAction>();
    }
    
    /*public void addHeadquarter(Headquarter h) {
        developedAction.setHeadquarter(h); // links infoaction with headquarter
    }*/

    public LocalDateTime getDate() {
        return date;
    }

    public String getPurpose() {
        return purpose;
    }

    public int getDuration() {
        return duration;
    }

    public LinkedList<InfoAction> getDevelopedAction() {
        return infoActions;
    }

    public boolean isPerforming(LocalDateTime d) {
        if (d.compareTo(date) >= 0 && d.compareTo(LocalDateTime.from(date.toInstant(null).plus(Duration.ofMinutes(duration)))) < 0) { return true; }
        return false;
    }

    public void addInfoActions(InfoAction a) {
        infoActions.add(a);
    }

    public LinkedList<Headquarter> getHeadquarters() {
        LinkedList<Headquarter> hList = new LinkedList<Headquarter>();
        for(InfoAction info : infoActions) {
            hList.add(info.getHeadquarter());
        }
        return hList;
    }
}
