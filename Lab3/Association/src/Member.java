public class Member {
    protected String name;
    protected int phone;
    protected String email;
    protected Availability availability;
    protected Headquarter headquarter;

    public Member(String n, int p, String e, Headquarter h) {
        name = n;
        phone = p;
        email = e;
        headquarter = h;
    }

    public void setAvailability(Availability a) {
        availability = a;
    }

    public Headquarter getHeadquarter() {
        return headquarter;
    }
}
