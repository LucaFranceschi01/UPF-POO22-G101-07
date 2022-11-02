import java.util.LinkedList;

public class City {
    private String name;
    private int population;
    private LinkedList<Headquarter> headquarters;

    public City(String n, int p) {
        name = n;
        population = p;
        headquarters = new LinkedList<Headquarter>();
    }

    public void addHeadquarter(Headquarter h) {
        headquarters.add(h);
    }

    public String toString() {
        return name;
    }

    public int getPopulation() {
        return population;
    }
}
