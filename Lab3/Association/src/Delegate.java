import java.util.Date;
import java.util.LinkedList;

public class Delegate extends Member {
    private LinkedList<Regular> dependents;
    private Headquarter headOf; // can be null?

    public Delegate(String n, int p, String e, Headquarter h) {
        super(n, p, e, h);
        dependents = new LinkedList<Regular>();
        headOf = null;
    }

    public void setHeadOf(Headquarter h) {
        headOf = h;
    }

    public void addDependents(Regular r) {
        dependents.add(r);
    }

    /*public Image generateDelegate(QRLib q) {
        // finish
    }

    public Image generateRegular(QRLib q) {
        // finish
    }

    public boolean signUpDelegate(Delegate d, QRLib q, Image i) {
        // finish
    }

    public boolean signUpRegular(Regular r, QRLib q, Image i) {
        // finish
    }*/

    public void proposeAction(Action a) {
        headOf.getOrganization().addAction(a); // check
    }

    public void signUpAction(Date d) {
        // The head of a headquarter can propose new actions to the organization. The
        // delegates can sign up the headquarter for an action developed on a specific date
        // indicating how many of its dependent members will participate.
    }
}
