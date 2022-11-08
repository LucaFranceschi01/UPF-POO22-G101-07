import java.util.LinkedList;
public class TestDelegate {
    private LinkedList<Region> regions;
    private LinkedList<Delegate> delegates;
    private LinkedList<Headquarter> headquarters;
    private Organization organization;

    public static void main(String[] args) {
        TestDelegate myOrganization = new TestDelegate();
        // System.out.println(myOrganization.delegates.getFirst().getName());
        // myOrganization.delegates.getFirst().genDelegateQR();
        // myOrganization.delegates.getFirst().genRegularQR();
        Regular reg1 = new Regular("Papa Francisco", 666666666, "papa@vaticano.god", myOrganization.headquarters.getFirst(), myOrganization.headquarters.getFirst().getHead());
    }

    public TestDelegate() {
        organization = new Organization("MyOrganization");
        regions = readRegions();
        headquarters = readHeadquarters();
        delegates = readHeads();
        organization.setHeadquarters(headquarters);
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

    public LinkedList<Headquarter> readHeadquarters() {
        LinkedList<Headquarter> headquarterList = new LinkedList<Headquarter>();
        LinkedList<String[]> hea = Utility.readXML("headquarter");
        for(String[] arr : hea) {
            Headquarter headquarter = new Headquarter(arr[0], arr[1], organization);
            headquarter.setCities(getCitiesFromRegions(arr));
            headquarterList.add(headquarter);
        }
        return headquarterList;
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

    public LinkedList<Delegate> readHeads() {
        LinkedList<Delegate> headsList = new LinkedList<Delegate>();
        LinkedList<String[]> hea = Utility.readXML("head");
        for(String[] arr : hea) {
            Headquarter headquarter = Utility.getObject(arr[3], headquarters);
            Availability availability = new Availability(arr[4], arr[5]);
            Delegate head = new Delegate(arr[0], Integer.parseInt(arr[1]), arr[2], headquarter);
            head.setAvailability(availability);
            head.setHeadOf(headquarter);
            headquarter.setHead(head);
            headsList.add(head);
        }
        return headsList;
    }
}