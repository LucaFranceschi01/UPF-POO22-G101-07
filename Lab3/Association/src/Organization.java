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
}
