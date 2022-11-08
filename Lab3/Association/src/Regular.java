import java.util.LinkedList;

public class Regular extends Member{
    private Delegate responsible;
    private LinkedList<Vehicle> vehicles;

    public Regular(String n, int p, String e, Headquarter h, Delegate r) {
        super(n, p, e, h);
        responsible = r;
        r.addDependents(this);
        vehicles = new LinkedList<Vehicle>();
        r.signUpRegular(this);
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public Delegate getResponsible() {
        return responsible;
    }

    public String toString() {
        return String.valueOf(getPhone());
    }
}
