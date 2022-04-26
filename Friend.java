import java.util.*;

/**
 * A Friend 
 * @author JavaFine
 */
public class Friend {
    private UUID id ;
	private String firstName;
	private String lastName;
	private Date dateOfBirthday;
	private String discount;
    ArrayList<Flight> flights = new ArrayList<Flight>();
    ArrayList<Hotel> hotels=new ArrayList<Hotel>();

    /**
     * Loads friend from JSON file
     * @param Friend_ID
     * @param Friend_FirstName
     * @param Friend_LastName
     * @param dob
     * @param Friend_Discount
     * @param friend_flight
     * @param new_Room
     */
    public Friend(UUID Friend_ID,String Friend_FirstName,String Friend_LastName,Date dob,String Friend_Discount,ArrayList<Flight> friend_flight,ArrayList<Hotel> new_Hotel) {
       this.id=Friend_ID;
	   this.firstName=Friend_FirstName;
	   this.lastName=Friend_LastName;
	   this.dateOfBirthday=dob;
	   this.discount=Friend_Discount;
       this.flights=friend_flight;
       this.hotels=new_Hotel;
    }

    /**
     * Creates new friend
     * @param uuid2
     * @param first
     * @param last
     * @param dob
     * @param discount
     */
   /* public void createFriend(UUID uuid2, String first, String last, Date dob, String discount) {
 
        ArrayList<Flight> emptyFlightList = new ArrayList<Flight>();
        ArrayList<Hotel> emptyHotelList = new ArrayList<Hotel>();
        Friend newFriend = new Friend(uuid2, first, last, dob, discount, emptyFlightList, emptyHotelList);
    }
*/
    /**
     * Returns profile of friend
     * @return profile
     */
    public Profile getProfile() {
        String address = null;
        String city = null;
        String state = null; 
        String zip = null;
        String emailAddress = null;
        String phoneNumber = null;
        Boolean disability = false;
        String visa = null;
        String occupation = null;
        return new Profile(firstName, lastName, address, city, state, zip, dateOfBirthday, emailAddress, phoneNumber, visa, disability, occupation, discount);
    }

    /**
     * Returns first name 
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns last name
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns date of birth
     * @return
     */
    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    /**
     * Returns discount
     * @return
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * Returns string containing friend's information 
     * @return string
     */
    public String toString() {
        return "First Name: " + this.firstName + " Last Name: " + this.lastName + " Date of Birth: " + this.dateOfBirthday + " Discount: " + this.discount + " Flights: " + this.flights.toString() + " Hotels: " + this.hotels.toString(); 
    }

    /**
     * Returns friend's UUID
     * @return uuid
     */
    public UUID getID() {
        return id;
    }

    /**
     * Returns flight list of friend
     * @return array list of flights
     */
    public ArrayList<Flight> getFlights() {
        return flights;
    }

    /**
     * Returns hotel list of friend
     * @return array list of hotels
     */
    public ArrayList<Hotel> getHotels() {
        return hotels;
    }
 } 