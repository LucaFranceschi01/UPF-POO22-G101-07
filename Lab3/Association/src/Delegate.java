import java.util.Date;
import java.util.LinkedList;

public class Delegate extends Member {
    private LinkedList<Regular> dependents;
    private Headquarter headOf; // If null, not head of headquarter

    public Delegate(String n, int p, String e, Headquarter h) {
        super(n, p, e, h);
        dependents = new LinkedList<Regular>();
        headOf = null;
        if(h.getMembers().size() == 0) {
            headOf = h;
            h.setHead(this);
        }
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

    // Creates qr image for a delegate
    public Image genDelegateQR(Delegate d) {
        String text = "This is a QR for a Delegate Member. You don\'t have to care about rising sea levels, if you live on a mega yatch. " + getHeadquarter().getHead().getName();
        Image image = new Image("Lab3/Association/qr/del-".concat(String.valueOf(d.getPhone())).concat(".png"), 600, 600);
        image.setBitMatrix(QRLib.generateQRCodeImage(text, 600, 600));
        image.getBitmap();
        return image;
    }

    // Creates qr image for regular
    public Image genRegularQR(Regular r) {
        String text = "This is a QR for a Regular Member. Climate change doesn\'t matter, if you stay indoors. " + getHeadquarter().getHead().getName();
        Image image = new Image("Lab3/Association/qr/reg-".concat(String.valueOf(r.getPhone())).concat(".png"), 600, 600);
        image.setBitMatrix(QRLib.generateQRCodeImage(text, 600, 600));
        image.getBitmap();
        return image;
    }

    // Checks if image parameter text matches the text that the delegate should have and returns validity
    public boolean signUpDelegate(Delegate d, Image i) {
        String delText = "This is a QR for a Delegate Member. You don\'t have to care about rising sea levels, if you live on a mega yatch. " + d.getHeadquarter().getHead();
        if (QRLib.decodeQRCodeImage(i.getBitmap()).equals(delText)) {
            return true;
        } else {
            return false;
        }
    }

    // Checks if image parameter text matches the text that the regular should have and returns validity
    public boolean signUpRegular(Regular r, Image i) {
        String regText = "This is a QR for a Regular Member. Climate change doesn\'t matter, if you stay indoors. " + r.getHeadquarter().getHead();
        if (QRLib.decodeQRCodeImage(i.getBitmap()).equals(regText)) {
            return true;
        } else {
            return false;
        }
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