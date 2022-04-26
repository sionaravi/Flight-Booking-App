import java.util.*;

/**
 * Registered Users
 * @author JavaFine
 */
public class RegisteredUser extends User {
    private UUID id;
    private Profile userProfile;
    private String username="";
    private String password="";
    private Preferences pref;
    private ArrayList<FlightBooking> flightBookings = new ArrayList<FlightBooking>();
    private ArrayList<HotelBooking> hotelBookings = new ArrayList<HotelBooking>();
    private ArrayList<Friend> friendList = new ArrayList<Friend>();

    /**
     * Loads JSON file 
     * @param id
     * @param friendList
     * @param user
     * @param username
     * @param password
     */
    public RegisteredUser(UUID id, ArrayList<Friend> friendList, Profile userpProfile, String username, String password) {
        //System.out.println("uuserpProfile.getLast();
    	this.id = id;
        this.friendList = friendList;
        this.userProfile = userpProfile;
        this.username = username;
        this.password = password;
     /*   System.out.println(this.userProfile.getLast()+"asdoijsadkjl");
        
        System.out.println(this.username+"username 穿进去了");
        */
    }

    public String toString() {
        return "Username: " + this.username;
    }

    /**
     * Creates new registered user 
     * @param userProfile
     * @param username
     * @param password
     */ 
    public RegisteredUser(Profile userProfile, String username, String password) {
    	 this.username = username;
        UUID uuid = UUID.randomUUID();
        friendList = new ArrayList<Friend>();
       // this.username = userProfile.get
        System.out.println(username);
        RegisteredUser newUser = new RegisteredUser(uuid, friendList, userProfile, username, password);
     
    }

    /**
     * Returns username
     * @return username
     */
    public String getUsername() {
        return this.username;
    }
    
    /**
     * Returns password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns user profile
     * @return profile 
     */
    public Profile getProfile() {
        return userProfile;
    }

    /**
     * Returns friend list
     * @return friend list 
     */
    public ArrayList<Friend> getFriends() {
        return friendList;
    }

    /**
     * Returns friend based on first and last name
     * @param first
     * @param last
     * @return friend
     */
    public Friend getFriendByFristAndLast(String first, String last) {
        for(Friend friends: friendList) {
            if(friends.getFirstName().equals(first) && friends.getLastName().equals(last)) {
                return friends;
            }
        }
        return null;
    }

    /**
     * Sets user preferences 
     * @param pref
     */
    public void setPreferences(Preferences pref) {
        this.pref = pref;
    }

    /**
     * Returns user preferences 
     * @return preferences 
     */
    public Preferences getPreferences() {
        return pref;
    }

    /**
     * Adds flight to user's flight list 
     * @param flight
     */
    public void bookFlight(FlightBooking flight) {
       flightBookings.add(flight);
    }

    /**
     * Removes flight from user's flight list
     * @param flight
     */
    public void cancelFlight(FlightBooking flight) {
        flightBookings.remove(flight);
    }

    /**
     * Adds hotel to user's hotel list
     * @param hotel
     */
    public void bookHotel(HotelBooking hotel) {
        hotelBookings.add(hotel);
    }

    /**
     * Removes hotel from user's hotel list
     * @param hotel
     */
    public void cancelHotel(HotelBooking hotel) {
        hotelBookings.remove(hotel);
    }
    
    /**
     * Adds a friend in general
     * @param friend
     */
    public void addFriend(Friend friend) {
        friendList.add(friend);
    }

    /**
     * Adds non-user friend to friends list
     * @param firstName
     * @param lastName
     * @param dob
     * @param discount
     * @return friend
     */
    public Friend addNonUserFriend(String firstName, String lastName, Date dob, String discount) {
        UUID uuid = UUID.randomUUID();
        
        ArrayList<Flight> emptyFlightList = new ArrayList<Flight>();
        ArrayList<Hotel> emptyHotelList = new ArrayList<Hotel>();
        Friend aFriend = new Friend(uuid, firstName,lastName, dob, discount, emptyFlightList, emptyHotelList);
        System.out.println(discount+"123");
        friendList.add(aFriend);
        return aFriend;
    }

    /**
     * Adds user friend to friend's list based on username
     * @param userName
     * @return 
     */
    public Friend addUserFriend(Friend username2) {
        RegisteredUser newFriend = UserList.getInstance().getUserByUsername(username2);
        UUID uuid = newFriend.getID();
        String first = newFriend.getProfile().getFirst();
        String last = newFriend.getProfile().getLast();
        Date dob = newFriend.getProfile().getDOB();
        String discount = newFriend.getProfile().getDiscount();
        Friend aFriend = new Friend(uuid, first, last, dob, discount);
        friendList.add(aFriend);
        return aFriend;
    }

    /**
     * Removes friend from friends list based on first and last name
     * @param first
     * @param last
     */
    public void removeFriend(String first, String last) {
        for (Friend friend : friendList) {
            if (friend.getFirstName().equals(first) && friend.getLastName().equals(last)) {
                friendList.remove(friend);
            }
        }
    }

    /**
     * Prints itinerary 
     */
    public void accessItinerary() {
        System.out.println("Booked Flights");
        for(FlightBooking flight:flightBookings) {
            System.out.println(flight.toString());
        }
        System.out.println("Booked Hotels");
        for(HotelBooking hotel:hotelBookings) {
            System.out.println(hotel.toString());
        }
    }

    /**
     * Returns list of booked hotels 
     * @return array list of hotel bookings
     */
    public ArrayList<HotelBooking> getHotel() {
        return hotelBookings;
    }

    /**
     * Returns list of booked flights
     * @return array list of flight bookings
     */
    public ArrayList<FlightBooking> getFlight() {
        return flightBookings;
    }

    /**
     * Returns UUID
     * @return UUID
     */
    public UUID getID() {
        return this.id;
    }
}
