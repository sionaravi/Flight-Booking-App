import java.util.*;
import java.io.*;

/**
 * A Singleton Listing of Users
 * @author JavaFine
 */
public class UserList {
    private static UserDatabaseLoader userDatabaseLoader = new UserDatabaseLoader();
    private UserDatabaseWriter userDatabaseWriter = new UserDatabaseWriter();
    private ArrayList<RegisteredUser> users = new ArrayList<RegisteredUser>();
    private static UserList userList = new UserList();

    /**
     * Gets list of users from JSON file
     */
    UserList() {
        users = userDatabaseLoader.getUser();
    }
    /*public static void main(String[] args) {

     ArrayList<RegisteredUser> users = userDatabaseLoader.getUser();
     System.out.println(users.size());
     }*/

    /**
     * Creates and returns a single instance of UserList
     * @return UserList
     */
    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    /**
     * Returns user by UUID
     * @param id
     * @return registered user
     */
    public RegisteredUser getUserByUUID(UUID id) {
        for (RegisteredUser user : users) {
            if (user.getID().equals(id)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Prints itinerary
     * @param currentUser
     */
    public void printItinerary(RegisteredUser currentUser) {
        currentUser.accessItinerary();
    }

    /**
     * Writes itinerary to file
     * @param currentUser
     * @param title
     */
    public void writeItineraryToFile(RegisteredUser currentUser, String title) {
        try {
            ArrayList<FlightBooking> flightList = currentUser.getFlight();
            ArrayList<HotelBooking> hotelList = currentUser.getHotel();
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(title));
            fileWriter.println("Flight Bookings");
            for (FlightBooking flight : flightList) {
                fileWriter.println(flight.toString());
            }
            fileWriter.println("Hotel Bookings");
            for (HotelBooking hotel : hotelList) {
                fileWriter.println(hotel.toString());
            }
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Checks validity of username
     * @param username
     * @return
     */
    public boolean checkValidityOfUsername(String username) {
    	//System.out.println("-----------------");
    	if(users!=null) {
    		for (RegisteredUser user : users) {
    		//	System.out.println("-----sdsfsd------");
                if (username.equals(user.getUsername())) {
                    return false;
                }
                else {
                	return true;
                }
            }
    		
    	}
    	 return true;
    	
    	
    	
    	
    	
        /*for (RegisteredUser user : users) {
            if (username.equals(user.getUsername())) {
                return false;
            }
            else {
            	return true;
            }
        }
        return true;*/
    }

    /**
     * Returns friend list 
     * @param currentUser
     */
    public void getFriendsList(RegisteredUser currentUser) {
        ArrayList<Friend> friends = currentUser.getFriends(); 
        for(Friend friend: friends) {
            System.out.println(friend.toString());
        }
    }

    /**
     * Adds Non User Friend to Friend List 
     * @param currentUser
     * @param firstName
     * @param lastName
     * @param dob
     * @param discount
     */
    public void addNonUserFriend(RegisteredUser currentUser, String firstName, String lastName, Date dob, String discount) {

        // currentUser.addFriend(currentUser.addNonUserFriend(firstName, lastName, dob, discount));
        currentUser.getFriends().add(currentUser.addNonUserFriend(firstName, lastName, dob, discount));
        System.out.println();
    }

    /**
     * Books hotel
     * @param currentUser
     * @param hotel
     */
    public void bookHotel(RegisteredUser currentUser, HotelBooking hotel) {
        currentUser.bookHotel(hotel);
    }

    /**
     * Returns list of booked flights 
     * @param currentUser
     * @return
     */
    public ArrayList<FlightBooking> getBookedFlights(RegisteredUser currentUser) {
        return currentUser.getFlight();
    }

    /**
     * Returns list of booked hotels 
     * @param currentUser
     * @return
     */
    public ArrayList<HotelBooking> getBookedHotels(RegisteredUser currentUser) {
        return currentUser.getHotel();
    }

    /**
     * Removes flight from booked flights 
     * @param currentUser
     * @param flight
     */
    public void cancelFlight(RegisteredUser currentUser, FlightBooking flight) {
        currentUser.cancelFlight(flight);
    }

    /**
     * Removes hotel from booked hotels 
     * @param currentUser
     * @param hotel
     */
    public void cancelHotel(RegisteredUser currentUser, HotelBooking hotel) {
        currentUser.cancelHotel(hotel);
    }

    /**
     * Adds flight to booked flights 
     * @param currentUser
     * @param flight
     */
    public void bookFlight(RegisteredUser currentUser, FlightBooking flight) {
        currentUser.bookFlight(flight);
    }

    /**
     * Sets preferences 
     * @param currentUser
     * @param pref
     */
    public void setPreferences(RegisteredUser currentUser, Preferences pref) {
        currentUser.setPreferences(pref);
    }

    /**
     * Removes friend from friend list
     * @param currentUser
     * @param first
     * @param last
     */
    public void removeFriend(RegisteredUser currentUser, String first, String last) {
        currentUser.removeFriend(first, last);
    }

    /**
     * Adds user friend to friend list 
     * @param currentUser
     * @param username
     */
    public void addUserFriend(RegisteredUser currentUser, String username) {
        currentUser.addUserFriend(username);
    }

    /**
     * Returns user by username
     * @param username
     * @return registered user
     */
    public RegisteredUser getUserByUsername(String username) {
        for (RegisteredUser user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Adds user to list and to database files
     * @param user
     */
    public RegisteredUser addUser(Profile userProfile, String username, String password) {
        RegisteredUser user = new RegisteredUser(userProfile, username, password);
        users.add(user);
        return user;
        }

    /**
     * Removes user from list and from database file
     * @param user
     */
    public void removeUser(UUID userID) {
        for (RegisteredUser user : users) {
            if (user.getID().equals(userID)) {
                int pos = this.users.indexOf(user);
                users.remove(pos);
            }
        }
    }

    /**
     * Returns the list of friends associated with current user
     * @return list of friends
     */
    public ArrayList<Friend> getFriendsList() {
        return userList.getFriendsList();
    }

    /**
     * Returns user based on inputted username and password
     * @param username
     * @param password
     * @return user based on inputted username and password
     */
    public RegisteredUser getUser(String username, String password) {
        for (RegisteredUser user : getAllUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Returns list of all registered users
     * @return list of users
     */
    public ArrayList<RegisteredUser> getAllUsers() {
        return UserDatabaseLoader.getUser();
    }

    public void saveUsers(){
        UserDatabaseWriter.saveUsers();
    }
}
