import java.util.Date;
import java.util.LinkedList;

public class Organization {
    private String name;
    private LinkedList<Headquarter> headquarters;
    private LinkedList<Action> actions;
    
    public Organization(String n) {
        name = n;
        headquarters = new LinkedList<Headquarter>();
        actions = new LinkedList<Action>();
    }

    public void addAction(Action a) {
        actions.add(a);
    }

    public Action getAction(Date d) {
        for(Action a : actions) {
            if(a.isPerforming(d)) { return a; }
        }
        return null; // check
    }

    public String getName() {
        return name;
    }

    public LinkedList<Headquarter> getHeadquarters() {
        return headquarters;
    }

    public LinkedList<Action> getActions() {
        return actions;
    }

    public void setHeadquarters(LinkedList<Headquarter> h) {
        headquarters = h;
    }

    public void setActions(LinkedList<Action> a) {
        actions = a;
    }

    public LinkedList<Delegate> getHeads() {
        LinkedList<Delegate> heads = new LinkedList<Delegate>();
        for(Headquarter h : headquarters) {
            heads.add(h.getHead());
        }
        return heads;
    }

    public void printMembers() {
        for(Headquarter h : headquarters) {
            System.out.printf("%s: ", h.toString());
            System.out.println(h.getMembers().toString());
        }
        System.out.println("-----------------------------------------------------");
    }
    /*
     * Delegate d: the delegate that wants to signup a member
     * String type: the type of the newDel member
     * Member m: the newDel member
     */
    public void addDelegate(Delegate d, Delegate newDel, Availability a) {
        if(d.signUpDelegate(newDel, d.genDelegateQR(newDel)) == true) {
            d.getHeadquarter().addMember((Member) newDel);
            newDel.setAvailability(a);
        }
    }

    public void addRegular(Delegate d, Regular newReg, Availability a) {
        if(d.signUpRegular(newReg, d.genRegularQR(newReg)) == true) {
            d.getHeadquarter().addMember((Member) newReg);
            newReg.setAvailability(a);
        }
    }
}