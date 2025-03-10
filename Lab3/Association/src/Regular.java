import java.util.LinkedList;

public class Regular extends Member{
    private Delegate responsible;
    private LinkedList<Vehicle> vehicles;

    public Regular(String n, int p, String e, Headquarter h, Delegate d) {
        super(n, p, e, h);
        vehicles = new LinkedList<Vehicle>();
        responsible = d;
    }

    public LinkedList<Vehicle> getVehicles() {
        return vehicles;
    }
        
    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public Delegate getResponsible() {
        return responsible;
    }
}