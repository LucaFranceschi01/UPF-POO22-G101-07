import java.util.LinkedList;
public class TestDelegate {
    private LinkedList<Region> regions;
    private Organization organization;

    public static void main(String[] args) {
        TestDelegate testing = new TestDelegate();
        LinkedList<Headquarter> headquarters = testing.organization.getHeadquarters();
        new Delegate("Some Delegate", 333333333, "someone@association.idk", headquarters.getFirst());
        new Regular("Papa Francisco", 666666666, "papa@vaticano.god", headquarters.getFirst(), headquarters.getFirst().getDelegates().getFirst());
        new Regular("New Papa Francisco", 666666667, "papa@vaticano.god", headquarters.getFirst(), headquarters.getFirst().getDelegates().get(1));
        testing.organization.printMembers();
        // headquarters.getFirst().getMembers().get(0).getQR().save();
    }

    public TestDelegate() {
        organization = new Organization("MyOrganization");
        regions = readRegions();
        readHeadquarters();
        readHeads();
    }

    public LinkedList<Region> readRegions() {
        LinkedList<Region> regionList = new LinkedList<Region>();
        LinkedList<String[]> reg = Utility.readXML("region");
        for(String[] arr : reg) {
            Region region = new Region(arr[0]);
            LinkedList<City> cities = new LinkedList<City>();
            for(int i=1; i<=arr.length/2; i++){
                cities.add(new City(arr[i], Integer.parseInt(arr[i+(arr.length-1)/2])));
            }
            region.setCities(cities);
            regionList.add(region);
        }
        return regionList;
    }

    public void readHeadquarters() {
        LinkedList<Headquarter> headquarterList = new LinkedList<Headquarter>();
        LinkedList<String[]> hea = Utility.readXML("headquarter");
        for(String[] arr : hea) {
            Headquarter headquarter = new Headquarter(arr[0], arr[1], organization);
            LinkedList<City> cities  = getCitiesFromRegions(arr);
            headquarter.setCities(cities);
            for(City c : cities) {
                c.addHeadquarter(headquarter);
            }
            headquarterList.add(headquarter);
        }
        organization.setHeadquarters(headquarterList);
    }

    public LinkedList<City> getCitiesFromRegions(String[] array) {
        LinkedList<City> cities = new LinkedList<City>();
        for(int i=2; i< array.length; i++) {
            for(Region region : regions) {
                City city = Utility.getObject(array[i], region.getCities());
                if(city != null) { cities.add(city); }
            }
        }
        return cities;
    }

    public void readHeads() {
        LinkedList<String[]> hea = Utility.readXML("head");
        for(String[] arr : hea) {
            Headquarter headquarter = Utility.getObject(arr[3], organization.getHeadquarters());
            Availability availability = new Availability(arr[4], arr[5]);
            Delegate head = new Delegate(arr[0], Integer.parseInt(arr[1]), arr[2], headquarter);
            head.setAvailability(availability);
        }
    }
}