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
    
    public String toString() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public Delegate getHead() {
        return head;
    }
    
    public Organization getOrganization() {
        return organization;
    }
    
    public LinkedList<City> getCities() {
        return cities;
    }

    public LinkedList<Member> getMembers() {
        return members;
    }
    
    public void addAction(InfoAction a) {
        developedActions.add(a);
    }
    
    public void setHead(Delegate h) {
        head = h;
    }

    public void setCities(LinkedList<City> cityList) {
        cities = cityList;
    }
    
    public void addMember(Member m) {
        members.add(m);
    }
    
    /**
     * Checks all members of the headquarter and selects only the delegates.
     * @return A list will all the delegates of the headquarter.
     */
    public LinkedList<Delegate> getDelegates() {
        LinkedList<Delegate> delegates = new LinkedList<Delegate>();
        for(Member m : members) {
            if(m instanceof Delegate) {
                delegates.add((Delegate) m);
            }
        }
        return delegates;
    }

    /**
     * Checks all members of the headquarter and selects only the regulars.
     * @return A list will all the regulars of the headquarter.
     */
    public LinkedList<Regular> getRegulars() {
        LinkedList<Regular> regulars = new LinkedList<Regular>();
        for(Member m : members) {
            if(m instanceof Regular) {
                regulars.add((Regular) m);
            }
        }
        return regulars;
    }

    /**
     * Will create an Infoaction for the specific case of an action, a headquarter that will perform it and some more attributes
     * and will link that infoaction to the appropiate Action and Headquarter classes.
     * @param a Action that is going to be signed up (developed)
     * @param nm Number of members of the headquarter participating.
     * @param nnm Number of non-members of the headquarter participating.
     * @param pc If the action has pressCoverage or not.
     */
    public void signUpAction(Action a, int nm, int nnm, boolean pc) {
        InfoAction info = new InfoAction(a, this, nm, nnm, pc);
        a.addInfoActions(info);
        addAction(info);
    }

    /**
     * Counts the members of the Headquarter that will assist to the given action.
     * @param a The action we want to know the participants.
     * @return  An integer containing the number of members participating.
     */
    public int countAssistingMembers(Action a) {
        int counter = 0;
        for(Delegate d : getDelegates()) {
            if(d.checkAvailabity(a) == true) { counter++; }
            counter += d.countAssistingRegulars(a);
        }
        return counter;
    }

    /**
     * Creates a list with the members of the Headquarter that will assist to the given action.
     * @param a The action we want to know the participants.
     * @return  A list containing the number of members participating.
     */
    public LinkedList<Member> getAssistingMembers(Action a) {
        LinkedList<Member> members = new LinkedList<Member>();
        for(Delegate d : getDelegates()) {
            if(d.checkAvailabity(a) == true) {
                members.add(d);
            }
            for(Member m : d.getAssistingRegulars(a)) {
                members.add(m);
            }
        }
        return members;
    }
}