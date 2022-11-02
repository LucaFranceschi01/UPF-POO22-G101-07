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

    public void signUpAction(Action a, int nm, int nnm, boolean pc) {
        InfoAction info = new InfoAction(a, this, nm, nnm, pc); // wat
        actionsDeveloped.add(info);
    }

    public Organization getOrganization() {
        return organization;
    }

    public Action getAction(Date d) {
        for(int i=0; i<actionsDeveloped.size(); i++) {
            if(actionsDeveloped.get(i).getAction().isPerforming(d)) { return actionsDeveloped.get(i).getAction(); }
        }
        return null; // check
    }

    public void setHead(Delegate h) {
        head = h;
    }

    public void setCities(LinkedList<City> cityList) {
        cities = cityList;
    }

    public LinkedList<City> getCities() {
        return cities;
    }
}
