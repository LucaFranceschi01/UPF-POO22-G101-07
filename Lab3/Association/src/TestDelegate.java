import java.util.LinkedList;
public class TestDelegate {
    private LinkedList<Region> regions;
    private Organization organization;

    public static void main(String[] args) {
        TestDelegate testing = new TestDelegate();
        testing.organization.printMembers();

        // We need to create some variables for the code to look cleaner
        Availability gA = new Availability("dilluns.dimarts.dijous", "9.10.11.15.16.17.18"); // generic Availability
        LinkedList<Headquarter> headquarters = testing.organization.getHeadquarters();
        Headquarter firstHeadquarter = headquarters.get(0);
        Delegate firstHead = firstHeadquarter.getHead();
        Headquarter secondHeadquarter = headquarters.get(1);
        Delegate secondHead = secondHeadquarter.getHead();

        //ADD
        testing.organization.addDelegate(firstHead, new Delegate("a", 1, "@", firstHeadquarter), gA);
        Delegate firstDelegate = firstHeadquarter.getDelegates().get(1); // first delegate non-head of firstHeadquarter
        //ADD
        testing.organization.addDelegate(firstHead, new Delegate("b", 1, "@", firstHeadquarter), gA);
        Delegate secondDelegate = firstHeadquarter.getDelegates().get(2); // second delegate non-head of firstHeadquarter
        //DOES NOT ADD
        testing.organization.addDelegate(secondHead, new Delegate("c", 1, "@", firstHeadquarter), gA);
        //ADD
        testing.organization.addRegular(firstHead, new Regular("d", 1, "@", firstHeadquarter, firstHead), gA); // head adds and it is responsible
        //ADD
        testing.organization.addRegular(firstHead, new Regular("e", 1, "@", firstHeadquarter, firstDelegate), gA); // head adds and it is not responsible
        //ADD
        testing.organization.addRegular(firstDelegate, new Regular("f", 1, "@", firstHeadquarter, firstDelegate), gA); // delegate adds and it is responsible
        //ADD
        testing.organization.addRegular(firstDelegate, new Regular("g", 1, "@", firstHeadquarter, secondDelegate), gA); // delegate adds and it is not responsible
        //DOES NOT ADD
        testing.organization.addRegular(secondHead, new Regular("h", 1, "@", firstHeadquarter, secondHead), gA); // not correct headquarter
        testing.organization.printMembers();
    }
    // Constructor of TestDelegate, where we call the methods to read XML files
    public TestDelegate() {
        organization = new Organization("MyOrganization");
        regions = readRegions();
        readHeadquarters();
        readHeads();
    }

    // Reads XML of regions and returns a list of regions following the data given
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

    // Reads XML of headquarters and assigns the data given to the attributes of organization
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

    // From an array containing cities, returns the corresponding cities in the corresponding class
    private LinkedList<City> getCitiesFromRegions(String[] array) {
        LinkedList<City> cities = new LinkedList<City>();
        for(int i=2; i< array.length; i++) {
            for(Region region : regions) {
                City city = Utility.getObject(array[i], region.getCities());
                if(city != null) { cities.add(city); }
            }
        }
        return cities;
    }

    // Reads XML of heads and assigns the data given to the attributes of organization
    public void readHeads() {
        LinkedList<String[]> hea = Utility.readXML("head");
        for(String[] arr : hea) {
            Headquarter headquarter = Utility.getObject(arr[3], organization.getHeadquarters());
            Availability availability = new Availability(arr[4], arr[5]);
            Delegate head = new Delegate(arr[0], Integer.parseInt(arr[1]), arr[2], headquarter);
            head.setAvailability(availability);
            headquarter.addMember((Member) head);
        }
    }
}