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

    /**
     * Given a specific date, it checks if the action is being performed at the date or not.
     * @param d Date at which we want to know if the action is performing.
     * @return True if if the date introduced is between the beggining and the end of the action, false otherwise.
     */
    public boolean isPerforming(LocalDateTime d) { // esta date tiene que ser de la availability de member
        if(d.compareTo(date) >= 0 && d.compareTo(date.plusMinutes(duration)) < 0) { return true; }
        return false;
    }

    public void addInfoActions(InfoAction a) {
        infoActions.add(a);
    }

    /**
     * Creates and returns a list of headquarters for each infoAction inside infoActions of a specific action.
     * @return A list of the headquarters where that action is being performed.
     */
    public LinkedList<Headquarter> getHeadquarters() {
        LinkedList<Headquarter> hList = new LinkedList<Headquarter>();
        for(InfoAction info : infoActions) {
            hList.add(info.getHeadquarter());
        }
        return hList;
    }

    /**
     * Given a specific headquarter, returns the number of members of that headquarter that are participating in the action.
     * @param h Headquarter we want to get the number of members from.
     * @return Number of participating members of the headquarter.
     */
    public int getAssistingNumMembers(Headquarter h) {
        for(InfoAction info : infoActions) {
            if(info.getHeadquarter() == h) {
                return info.getNumMembers();
            }
        }
        return 0;
    }
}
