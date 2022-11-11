import java.time.LocalDateTime;
import java.util.LinkedList;

public class Organization {
    private String name;
    private LinkedList<Headquarter> headquarters;
    private LinkedList<Action> actions;
    
    public Organization(String n) {
        name = n;
        actions = new LinkedList<Action>();
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

    // Returns a linkedlist with the heads of each headquarter of the organization
    public LinkedList<Delegate> getHeads() {
        LinkedList<Delegate> heads = new LinkedList<Delegate>();
        for(Headquarter h : headquarters) {
            heads.add(h.getHead());
        }
        return heads;
    }

    // Prints the members of each headquarter in a legible way
    public void printMembers() {
        for(Headquarter h : headquarters) {
            System.out.printf("%-15s: ", h.toString());
            System.out.println(h.getMembers().toString());
        }
        System.out.println("-".repeat(50));
    }
    /**
     * This method tries to add a new Delegate to the Organization. Essentially, it checks that the two delegates belong to the same headquarter.
     * @param del The Delegate that tries to add a new Delegate to the organization.
     * @param newDel The Delegate that is being created.
     * @param a The availability of the new Delegate.
     */
    public void addDelegate(Delegate del, Delegate newDel, Availability a) {
        if(del.signUpDelegate(newDel, del.genDelegateQR(newDel)) == true) {
            del.getHeadquarter().addMember((Member) newDel);
            newDel.setAvailability(a);
        }
    }

    /**
     * This method tries to add a new Regular to the Organization. Essentially, it checks that the Delegate and the Regular belong to the same headquarter.
     * @param del The Delegate that tries to add a new Regular to the organization.
     * @param newReg The Regular that is being created.
     * @param a The availability of the new Regular.
     */
    public void addRegular(Delegate del, Regular newReg, Availability a) {
        if(del.signUpRegular(newReg, del.genRegularQR(newReg)) == true) {
            del.getHeadquarter().addMember((Member) newReg);
            del.addDependents(newReg);
            newReg.setAvailability(a);
        }
    }

    public void addAction(Action a) {
        actions.add(a);
    }

    public Action getAction(LocalDateTime d) {
        for(Action a : actions) {
            if(a.isPerforming(d)) { return a; } // we suppose that there cannot be more than one action given a date
        }
        return null; // check
    }

    public void printActions() {
        for(Action a : actions) {
            System.out.printf("%s: %s%n", a.getPurpose(), a.getHeadquarters().toString());
        }
        System.out.println("-".repeat(50));

    }
}