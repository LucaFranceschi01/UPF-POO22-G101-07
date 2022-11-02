import java.util.LinkedList;

public class TestOrganization {
    private LinkedList<Region> regions;
    private Delegate delegate;
    private LinkedList<Headquarter> headquarters;
    private Organization organization;

    public static void main(String[] args) {
        new TestOrganization();
    }

    public TestOrganization() {
        organization = new Organization("MyOrganization");
        regions = readRegions();
        headquarters = readHeadquarters();
    }

    public LinkedList<Region> readRegions() {
        LinkedList<Region> regionList = new LinkedList<Region>();
        LinkedList<String[]> reg = Utility.readXML("region");
        for(String[] arr : reg) {
            Region region = new Region(arr[0]);
            LinkedList<City> cities = new LinkedList<City>();
            for(int i=1; i<arr.length/2; i++){
                cities.add(new City(arr[i], Integer.parseInt(arr[i+(arr.length-1)/2])));
            }
            region.setCities(cities);
            regionList.add(region);
        }
        return regionList;
    }

    public LinkedList<Headquarter> readHeadquarters() {
        LinkedList<Headquarter> headquarterList = new LinkedList<Headquarter>();
        LinkedList<String[]> hea = Utility.readXML("headquarter");
        for(String[] arr : hea) {
            Headquarter headquarter = new Headquarter(arr[0], arr[1], organization);
            LinkedList<City> cities = new LinkedList<City>();
            for(int i=2; i< arr.length; i++) {
                // finish
            }
            System.out.println("--------------");
        }
        return null;
    }
}