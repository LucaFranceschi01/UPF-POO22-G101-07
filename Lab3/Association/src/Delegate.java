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

    public Headquarter getHeadquarter() {
        return headOf;
    }

    public void addDependents(Regular r) {
        dependents.add(r);
    }

    public Image genDelegateQR(QRLib q) { // mal
        String text = "This is a QR for a Delegate Member. You don\'t have to care about rising sea levels, if you live on a mega yatch.";
        Image image = new Image("Lab3/Association/img", 600, 600);
        image.setBitMatrix(QRLib.generateQRCodeImage(text, 600, 600));
        image.getBitmap();
        return image;
    }

    /*public Image genRegularQR(QRLib q) {
        // finish
    }*/

    /*public boolean signUpDelegate(Delegate d, QRLib q, Image i) {
        
    }*/

    /*public boolean signUpRegular(Regular r, QRLib q, Image i) {
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

    protected String getName() {
        return super.getName();
    }
}
