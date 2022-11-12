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
    
    public LocalDateTime getDate() {
        return date;
    }

    public String getPurpose() {
        return purpose;
    }

    public int getDuration() {
        return duration;
    }

    public LinkedList<InfoAction> getInfoActions() {
        return infoActions;
    }

    public boolean isPerforming(LocalDateTime d) { // esta date tiene que ser de la availability de member
        if(d.compareTo(date) >= 0 && d.compareTo(date.plusMinutes(duration)) < 0) { return true; }
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

    public int getAssistingNumMembers(Headquarter h) {
        for(InfoAction info : infoActions) {
            if(info.getHeadquarter() == h) {
                return info.getNumMembers();
            }
        }
        return 0;
    }
}
