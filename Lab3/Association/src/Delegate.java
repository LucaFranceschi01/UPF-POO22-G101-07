import java.util.Date;
import java.util.LinkedList;

public class Delegate extends Member {
    private LinkedList<Regular> dependents;
    private Headquarter headOf; // can be null?

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

    public Headquarter getHeadquarter() {
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
            text = text.concat("\\n - ").concat(getName());
        }
        Image image = new Image("Lab3/Association/img/del-".concat(String.valueOf(d.getPhone())).concat(".jpg"), 600, 600);
        image.setBitMatrix(QRLib.generateQRCodeImage(text, 600, 600));
        image.getBitmap(); // to set bitmap
        // image.save(); // save??
        // setQR(image);
        return image;
    }

    public Image genRegularQR(Regular r) {
        String text = "This is a QR for a Regular Member. Climate change doesn\'t matter, if you stay indoors.";
        Image image = new Image("Lab3/Association/img/reg-".concat(String.valueOf(r.getPhone())).concat(".jpg"), 600, 600);
        image.setBitMatrix(QRLib.generateQRCodeImage(text, 600, 600));
        image.getBitmap(); // to set bitmap
        // image.save(); // save??
        // setQR(image);
        return image;
    }

    public boolean signUpDelegate(Delegate d) {
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
}
