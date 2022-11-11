import java.time.LocalDateTime;
import java.util.LinkedList;

public class Headquarter {
    private String name;
    private String email;
    private Delegate head;
    private Organization organization;
    private LinkedList<Member> members;
    private LinkedList<InfoAction> developedActions;
    private LinkedList<City> cities;

    public Headquarter(String n, String e, Organization o) {
        name = n;
        email = e;
        organization = o;
        members = new LinkedList<Member>();
        developedActions = new LinkedList<InfoAction>();
        cities = new LinkedList<City>();
    }

    public void addMember(Member m) {
        members.add(m);
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setHead(Delegate h) {
        head = h;
    }

    public Delegate getHead() {
        return head;
    }

    public void setCities(LinkedList<City> cityList) {
        cities = cityList;
    }

    public LinkedList<City> getCities() {
        return cities;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return name;
    }

    public LinkedList<Member> getMembers() {
        return members;
    }

    public LinkedList<Delegate> getDelegates() {
        LinkedList<Delegate> delegates = new LinkedList<Delegate>();
        for(Member m : members) {
            if(m.checkClass().equals("Delegate")) {
                delegates.add((Delegate) m);
            }
        }
        return delegates;
    }

    public LinkedList<Regular> getRegulars() {
        LinkedList<Regular> regulars = new LinkedList<Regular>();
        for(Member m : members) {
            if(m.checkClass().equals("Regular")) {
                regulars.add((Regular) m);
            }
        }
        return regulars;
    }

    public Action getAction(LocalDateTime d) {
        for(int i=0; i<developedActions.size(); i++) {
            if(developedActions.get(i).getAction().isPerforming(d)) { return developedActions.get(i).getAction(); }
        }
        return null; // check
    }

    public void addAction(InfoAction a) {
        developedActions.add(a);
    }
    /**
     * Will add the action to the Action.linkedlist of infoactions and Headquarter.actionsdeveloped
     * The headquarter will perform that action.
     * @param a Action that is going to be signed up (developed)
     * @param nm
     * @param nnm
     * @param pc
     */
    public void signUpAction(Action a, int nm, int nnm, boolean pc) {
        InfoAction info = new InfoAction(a, this, nm, nnm, pc);
        a.addInfoActions(info);
        addAction(info);
    }
}
