import java.time.LocalDateTime;
import java.util.LinkedList;
public class TestDelegate {
    private LinkedList<Region> regions;
    private Organization organization;

    public static void main(String[] args) {

        /* ------------------------------------------ TESTING ------------------------------------------ */

        TestDelegate testing = new TestDelegate();
        System.out.println();                       // Empty line
        System.out.println("Initial members:");
        System.out.println();                       // Empty line
        testing.organization.printMembers();        // We print original members (heads only)

        // GENERAL AVAILABILITIES
        Availability gA = new Availability("dilluns.dimarts.dijous", "9.10.11.15.16.17.18");    // Availability type A
        Availability gB = new Availability("dilluns.dimecres.dijous", "9.10.11.12");            // Availability type B
        Availability gC = new Availability("dimecres", "9.10.11.12.13.14.15.16.17.18.19");      // Availability type C
        Availability gD = new Availability("dilluns.divendres", "9.10.11.12.15.16.17.18");      // Availability type D 

        // SHORTCUT VARIABLES TO ACCESS THE HEADS AND HEADQUARTERS (to make code cleaner)
        LinkedList<Headquarter> headquarters = testing.organization.getHeadquarters();
        Headquarter firstHeadquarter = headquarters.get(0);
        Delegate firstHead = firstHeadquarter.getHead();
        Headquarter secondHeadquarter = headquarters.get(1);
        Delegate secondHead = secondHeadquarter.getHead();
        Headquarter thirdHeadquarter = headquarters.get(2);
        Delegate thirdHead = thirdHeadquarter.getHead();
        Headquarter fourthHeadquarter = headquarters.get(3);
        Delegate fourthHead = fourthHeadquarter.getHead();
        Headquarter fifthHeadquarter = headquarters.get(4);
        Delegate fifthHead = fifthHeadquarter.getHead();
        Headquarter sixthHeadquarter = headquarters.get(5);
        Delegate sixthHead = sixthHeadquarter.getHead();
        Headquarter seventhHeadquarter = headquarters.get(6);
        Delegate seventhHead = seventhHeadquarter.getHead();
        Headquarter eigthHeadquarter = headquarters.get(7);
        Delegate eigthHead = eigthHeadquarter.getHead();
        Headquarter ninthHeadquarter = headquarters.get(8);
        Delegate ninthHead = ninthHeadquarter.getHead();
        Headquarter tenthHeadquarter = headquarters.get(9);
        Delegate tenthHead = tenthHeadquarter.getHead();
        Headquarter eleventhHeadquarter = headquarters.get(10);
        Delegate eleventhHead = eleventhHeadquarter.getHead();

        /* ------------------------------------------ ADDING MEMBERS ------------------------------------------ */

        //ADD

        // we add first some delegates so that they can later be responsible of other regulars
        testing.organization.addDelegate(firstHead, new Delegate("Adrià Garcia", 632879534, "@", firstHeadquarter), gA);
        Delegate firstDelegate = firstHeadquarter.getDelegates().get(1); // first delegate non-head of firstHeadquarter
        testing.organization.addDelegate(firstHead, new Delegate("Joel Molina", 674567822, "@", firstHeadquarter), gB);
        Delegate secondDelegate = firstHeadquarter.getDelegates().get(2); // second delegate non-head of firstHeadquarter
        testing.organization.addDelegate(secondHead, new Delegate("María Martínez", 883629634, "@", secondHeadquarter), gA);
        Delegate firstDelegate_h2 = secondHeadquarter.getDelegates().get(1); // first delegate non-head of secondHeadquarter

        // First headquarter
        testing.organization.addRegular(firstDelegate, new Regular("Álvaro Antón", 875903346, "@", firstHeadquarter, firstDelegate), gA); // delegate adds and it is responsible

        // Second headquarter
        testing.organization.addRegular(secondHead, new Regular("Sergio Ramírez", 690587489, "@", secondHeadquarter, secondDelegate), gA); // head adds and it is not responsible
        testing.organization.addRegular(secondHead, new Regular("Emilio Pérez", 655778930, "@", secondHeadquarter, firstDelegate_h2), gD); // head adds and it is not responsible

        // Third headquarter
        testing.organization.addRegular(thirdHead, new Regular("Nil Bokesa", 837462185, "@", thirdHeadquarter, thirdHead), gA); // head adds and it is responsible
        testing.organization.addDelegate(thirdHead, new Delegate("Salud Moreno", 248457758, "@", thirdHeadquarter), gA);

        // Fourth headquarter
        testing.organization.addRegular(fourthHead, new Regular("Hermenejildo López", 455366782, "@", fourthHeadquarter, fourthHead), gA); // head adds and it is responsible
        testing.organization.addDelegate(fourthHead, new Delegate("Luciano Romero", 234862364, "@", fourthHeadquarter), gC);

        // Fifth headquarter
        testing.organization.addRegular(fifthHead, new Regular("Dalaila Casas", 644785906, "@", fifthHeadquarter, fifthHead), gD); // head adds and it is responsible
        testing.organization.addDelegate(fifthHead, new Delegate("Pablo Mesa", 834834632, "@", fifthHeadquarter), gB);

        // Sixth headquarter
        testing.organization.addRegular(sixthHead, new Regular("Antonio Giménez", 364738493, "@", sixthHeadquarter, sixthHead), gB); // head adds and it is responsible

        // Seventh headquarter
        testing.organization.addRegular(seventhHead, new Regular("Patricia Gómez", 724664738, "@", seventhHeadquarter, seventhHead), gA); // head adds and it is responsible
        
        // Eigth headquarter
        testing.organization.addRegular(eigthHead, new Regular("Laura Pausini", 349623463, "@", eigthHeadquarter, eigthHead), gB); // head adds and it is responsible
        testing.organization.addDelegate(eigthHead, new Delegate("Daniel Torres", 343634921, "@", eigthHeadquarter), gA);

        // Ninth headquarter
        testing.organization.addRegular(ninthHead, new Regular("Alejandro González", 277859402, "@", ninthHeadquarter, ninthHead), gC); // head adds and it is responsible
        testing.organization.addDelegate(ninthHead, new Delegate("Bruce Wayne", 358349894, "@", ninthHeadquarter), gA);

        // Tenth headquarter
        testing.organization.addRegular(tenthHead, new Regular("Luca Franceschi", 374483492, "@", tenthHeadquarter, tenthHead), gA); // head adds and it is responsible
        testing.organization.addDelegate(tenthHead, new Delegate("Brad Pitt", 835934673, "@", tenthHeadquarter), gD);

        // Eleventh headquarter
        testing.organization.addRegular(eleventhHead, new Regular("Trinidad Ruiz", 344466722, "@", eleventhHeadquarter, eleventhHead), gD); // head adds and it is responsible
        testing.organization.addDelegate(eleventhHead, new Delegate("Dwayne Johnson", 183492367, "@", eleventhHeadquarter), gC);

        //DOES NOT ADD
        testing.organization.addDelegate(secondHead, new Delegate("Juan Urgellés", 987453621, "@", firstHeadquarter), gC);          // not correct headquarter
        testing.organization.addRegular(secondHead, new Regular("Jaume Garcia", 655789400, "@", firstHeadquarter, secondHead), gD); // not correct headquarter
        

        // Printing final members
        System.out.println("Final members:");
        System.out.println();                       // Empty line
        testing.organization.printMembers();        // We print original members (heads only)

        /* ------------------------------------------ ADDING ACTIONS ------------------------------------------ */

        // GENERAL DATES FOR ACTIONS
        LocalDateTime d1 = LocalDateTime.of(2022, 11, 23, 16, 0, 0);
        LocalDateTime d2 = LocalDateTime.of(2022, 11, 27, 18, 0, 0);
        LocalDateTime d3 = LocalDateTime.of(2022, 11, 19, 22, 0, 0);
        LocalDateTime d4 = LocalDateTime.of(2022, 11, 21, 10, 0, 0);

        // Actions of the organization
        Action action1 = new Action("Conquer the world", d1, 60);
        Action action2 = new Action("Have a break", d2, 60);
        Action action3 = new Action("Spy other organizations", d3, 90);
        Action action4 = new Action("Care for the environment", d1, 120);
        Action action5 = new Action("Speech about the importance of being punctual", d4, 45);

        // Proposing new actions or adding existing ones to other headquarters
        // Action 1
        secondHead.proposeAction(action1);
        fourthHead.proposeAction(action1);
        fifthHead.proposeAction(action1);
        seventhHead.proposeAction(action1);
        // Action 2
        firstHead.proposeAction(action2);
        thirdHead.proposeAction(action2);
        fifthHead.proposeAction(action2);
        eigthHead.proposeAction(action2);
        // Action 3
        firstHead.proposeAction(action3);
        secondHead.proposeAction(action3);
        fourthHead.proposeAction(action3);
        ninthHead.proposeAction(action3);
        // Action 4
        thirdHead.proposeAction(action4);
        sixthHead.proposeAction(action4);
        ninthHead.proposeAction(action4);
        eleventhHead.proposeAction(action4);
        // Action 5
        secondHead.proposeAction(action5);
        sixthHead.proposeAction(action5);
        seventhHead.proposeAction(action5);
        tenthHead.proposeAction(action5);

        // Print final actions of the organization
        testing.organization.printActions();
    }

    /* ------------------------------------------ CONSTRUCTORS AND READING ------------------------------------------ */

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