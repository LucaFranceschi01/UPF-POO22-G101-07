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

    /**
     * Checks if a specific member is available to assist to a given action.
     * @param a The action we want to check the availability of the member.
     * @return True if the member is available, false if not.
     */
    protected boolean checkAvailabity(Action a) {
        if(availability.getDays().contains(a.getDate().getDayOfWeek().getValue())) {
            for(int h : availability.getHours()) {
                if(a.isPerforming(a.getDate().withHour(h))) { return true; }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return name;
    }
}