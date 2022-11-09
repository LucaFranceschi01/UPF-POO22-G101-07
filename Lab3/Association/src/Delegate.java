import java.util.Date;
import java.util.LinkedList;

public class Delegate extends Member {
    private LinkedList<Regular> dependents;
    private Headquarter headOf; // if not null, is head of a headquarter

    public Delegate(String n, int p, String e, Headquarter h) {
        super(n, p, e, h);
        dependents = new LinkedList<Regular>();
        headOf = null;
        if(h.getMembers().size() == 1) {
            headOf = h;
            h.setHead(this);
        }
        h.getHead().signUpDelegate(this);
    }

    public void setHeadOf(Headquarter h) {
        headOf = h;
    }

    public Headquarter getHeadOf() {
        return headOf;
    }

    public LinkedList<Regular> getDependents() {
        return dependents;
    }

    public void addDependents(Regular r) {
        dependents.add(r);
    }

    public Image genDelegateQR(Delegate d) {
        String text = "This is a QR for a Delegate Member. You don\'t have to care about rising sea levels, if you live on a mega yatch.";
        if(d.getHeadOf() != null) {
            text = getName().concat(". ").concat(text);
        }
        Image image = new Image("Lab3/Association/qr/del-".concat(String.valueOf(d.getPhone())).concat(".png"), 600, 600);
        image.setBitMatrix(QRLib.generateQRCodeImage(text, 600, 600));
        image.getBitmap(); // to set bitmap
        image.save();
        return image;
    }

    public Image genRegularQR(Regular r) {
        String text = "This is a QR for a Regular Member. Climate change doesn\'t matter, if you stay indoors.";
        Image image = new Image("Lab3/Association/qr/reg-".concat(String.valueOf(r.getPhone())).concat(".png"), 600, 600);
        image.setBitMatrix(QRLib.generateQRCodeImage(text, 600, 600));
        image.getBitmap(); // to set bitmap
        image.save();
        return image;
    }

    public boolean signUpDelegate(Delegate d) { // as we use it, always true
        if(headOf != null) {
            d.setQR(genDelegateQR(d));
            return true;
        }
        return false;
    }

    public void signUpRegular(Regular r) {
        r.setQR(genRegularQR(r));
    }

    public void proposeAction(Action a) {
        headOf.getOrganization().addAction(a); // check
    }

    public void signUpAction(Date d) {
        // The head of a headquarter can propose new actions to the organization. The
        // delegates can sign up the headquarter for an action developed on a specific date
        // indicating how many of its dependent members will participate.
    }

    public String checkClass() {
        return "Delegate";
    }
}
