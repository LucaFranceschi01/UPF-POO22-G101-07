import java.util.Date;
import java.util.LinkedList;

public class Headquarter {
    private String name;
    private String email;
    private Delegate head;
    private Organization organization;
    private LinkedList<Member> members;
    private LinkedList<InfoAction> actionsDeveloped;
    private LinkedList<City> cities;

    public Headquarter(String n, String e, Organization o) {
        name = n;
        email = e;
        organization = o;
        members = new LinkedList<Member>();
        actionsDeveloped = new LinkedList<InfoAction>();
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

    public Action getAction(Date d) {
        for(int i=0; i<actionsDeveloped.size(); i++) {
            if(actionsDeveloped.get(i).getAction().isPerforming(d)) { return actionsDeveloped.get(i).getAction(); }
        }
        return null; // check
    }

    public void signUpAction(Action a, int nm, int nnm, boolean pc) {
        InfoAction info = new InfoAction(a, this, nm, nnm, pc); // wat
        actionsDeveloped.add(info);
    }
}
