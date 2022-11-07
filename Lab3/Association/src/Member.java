public class Member {
    private String name;
    private int phone;
    private String email;
    private Availability availability;
    private Headquarter headquarter;
    private Image personalQR;

    public Member(String n, int p, String e, Headquarter h) {
        name = n;
        phone = p;
        email = e;
        headquarter = h;
        personalQR = null;
    }

    protected String getName() {
        return name;
    }
    
    protected int getPhone() {
        return phone;
    }

    protected String getEmail() {
        return email;
    }

    protected Availability getAvailability() {
        return availability;
    }

    protected Headquarter getHeadquarter() {
        return headquarter;
    }

    protected Image getQR() {
        return personalQR;
    }

    protected void setAvailability(Availability a) {
        availability = a;
    }

    protected void setHeadquarter(Headquarter h) {
        headquarter = h;
    }

    protected void setQR(Image qr) {
        personalQR = qr;
    }
}
