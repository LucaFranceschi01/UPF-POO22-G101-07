public class Member {
    private String name;
    private int phone;
    private String email;
    private Availability availability;
    private Headquarter headquarter;

    public Member(String n, int p, String e, Headquarter h) {
        name = n;
        phone = p;
        email = e;
        headquarter = h;
    }

    protected void setAvailability(Availability a) {
        availability = a;
    }

    protected Headquarter getHeadquarter() {
        return headquarter;
    }

    protected String getName() {
        return name;
    }
}
