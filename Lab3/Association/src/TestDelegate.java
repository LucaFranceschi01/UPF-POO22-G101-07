import java.util.LinkedList;
public class TestDelegate {
    private LinkedList<Region> regions;
    private Organization organization;

    public static void main(String[] args) {
        TestDelegate testing = new TestDelegate();
        Regular reg1 = new Regular("Papa Francisco", 666666666, "papa@vaticano.god", testing.organization.getHeadquarters().getFirst(), testing.organization.getHeadquarters().getFirst().getHead());
        Delegate del1 = new Delegate("Someone", 333333333, "someone@association.idk", testing.organization.getHeadquarters().getFirst());
        testing.organization.printMembers();
        testing.organization.getHeadquarters().getFirst().getMembers().get(0).getQR().save();
        testing.organization.getHeadquarters().getFirst().getMembers().get(1).getQR().save();
        testing.organization.getHeadquarters().getFirst().getMembers().get(2).getQR().save();
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
            headquarter.setCities(getCitiesFromRegions(arr));
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
        LinkedList<Delegate> headsList = new LinkedList<Delegate>();
        LinkedList<String[]> hea = Utility.readXML("head");
        for(String[] arr : hea) {
            Headquarter headquarter = Utility.getObject(arr[3], organization.getHeadquarters());
            Availability availability = new Availability(arr[4], arr[5]);
            Delegate head = new Delegate(arr[0], Integer.parseInt(arr[1]), arr[2], headquarter);
            head.setAvailability(availability);
            headsList.add(head);
        }
    }
}