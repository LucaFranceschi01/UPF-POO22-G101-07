import java.util.LinkedList;

public class Regular extends Member{
    private Delegate responsible;
    private LinkedList<Vehicle> vehicles;

    public Regular(String n, int p, String e, Headquarter h, Delegate d) {
        super(n, p, e, h);
        vehicles = new LinkedList<Vehicle>();
        responsible = d;
        d.addDependents(this);
    }
        
    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public Delegate getResponsible() {
        return responsible;
    }

    public String checkClass() {
        return "Regular";
    }
}