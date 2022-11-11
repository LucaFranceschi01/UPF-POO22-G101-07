import java.time.LocalDateTime;
import java.util.LinkedList;

public class Delegate extends Member {
    private LinkedList<Regular> dependents;
    private Headquarter headOf; // If null, not head of headquarter

    public Delegate(String n, int p, String e, Headquarter h) {
        super(n, p, e, h); // call to Member constructor
        dependents = new LinkedList<Regular>();
        headOf = null;

        // The first delegate assigned to a headquarter is the head
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

    // Creates QR Image for a Delegate d
    public Image genDelegateQR(Delegate d) {
        String text = "This is a QR for a Delegate Member. You don\'t have to care about rising sea levels, if you live on a mega yatch. " + getHeadquarter().getHead().getName();
        Image image = new Image("Lab3/Association/qr/del-".concat(String.valueOf(d.getPhone())).concat(".png"), 600, 600);
        image.setBitMatrix(QRLib.generateQRCodeImage(text, 600, 600));
        image.getBitmap();
        return image;
    }

    // Creates QR Image for a Regular d
    public Image genRegularQR(Regular r) {
        String text = "This is a QR for a Regular Member. Climate change doesn\'t matter, if you stay indoors. " + getHeadquarter().getHead().getName();
        Image image = new Image("Lab3/Association/qr/reg-".concat(String.valueOf(r.getPhone())).concat(".png"), 600, 600);
        image.setBitMatrix(QRLib.generateQRCodeImage(text, 600, 600));
        image.getBitmap();
        return image;
    }

    /**
     * Checks if the Delegate can be signed up using the specified QR Image: Essentially, checks if the text it should have is the same as the text of the decoded Image.
     * @param d The Delegate we want to sign up.
     * @param i The Image of which validity is being tested.
     * @return If the signup operation can be performed.
     */
    public boolean signUpDelegate(Delegate d, Image i) {
        String delText = "This is a QR for a Delegate Member. You don\'t have to care about rising sea levels, if you live on a mega yatch. " + d.getHeadquarter().getHead();
        if (QRLib.decodeQRCodeImage(i.getBitmap()).equals(delText)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the Regular can be signed up using the specified QR Image: Essentially, checks if the text it should have is the same as the text of the decoded Image.
     * @param r The Regular we want to sign up.
     * @param i The image of which validity is being tested.
     * @return If the signup operation can be performed.
     */
    public boolean signUpRegular(Regular r, Image i) {
        String regText = "This is a QR for a Regular Member. Climate change doesn\'t matter, if you stay indoors. " + r.getHeadquarter().getHead();
        if (QRLib.decodeQRCodeImage(i.getBitmap()).equals(regText)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * The head of a headquarter can propose new actions to the organization.
     * @param a The new action that is being proposed to the organization.
     */
    public void proposeAction(Action a) {
        if(headOf != null) {
            headOf.getOrganization().addAction(a);
            // If a head proposes an action, for sure that headquarter will signup for the action
            int nm = signUpAction(a.getDate());
            headOf.signUpAction(a, nm, 0, false); // when signed up there are no assistants
        } else {
            System.out.println("Only heads of headquarters can propose new actions!");
        }
    }

    /**
     * Put delegate and dependents in the list of assisting members. Needs to check availability of assisting members
     * @param d
     * @return
     */
    public int signUpAction(LocalDateTime d) {
        // RETURNS ALL ITS DEPENDENT MEMBERS THAT WILL BE AVAILABLE AT A CERTAIN DATETIME
        return 0;
    }

    public String checkClass() {
        return "Delegate";
    }
}