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

    protected void setAvailability(Availability a) {
        availability = a;
    }

    protected void setHeadquarter(Headquarter h) {
        headquarter = h;
    }

    public boolean checkAvailabity() {
        // por hacer, toca checkear si el member está disponible a esa hora
        return false; // de momento pa q no quede en rojito feo
    }

    public String toString() {
        return name;
    }

    public String checkClass() {
        return "Member";
    }
}