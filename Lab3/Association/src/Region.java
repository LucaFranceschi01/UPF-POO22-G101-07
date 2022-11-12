import java.util.LinkedList;

public class Region {
    private String name;
    private LinkedList<City> cities;

    public Region(String n) {
        name = n;
    }

    public void setCities(LinkedList<City> c) {
        cities = c;
    }

    public LinkedList<City> getCities() {
        return cities;
    }

    @Override
    public String toString() {
        return name.concat(":").concat(cities.toString());
    }
}
