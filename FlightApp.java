import java.util.*;

/**
 * Flight Application
 * @author JavaFine
 */
public class FlightApp {
    private FlightsList flightList;
    private HotelsList hotelList;
    private UserList userList;
   
    public FlightApp() {
        this.flightList = flightList.getInstance();
        this.hotelList = hotelList.getInstance();
        this.userList = userList.getInstance();
    }

    public ArrayList<RegisteredUser> getAllUsers() {
        return userList.getAllUsers();
    }
    /**
     * Returns user based on username and password
     * @param username
     * @param password
     * @return registered user
     */
    public RegisteredUser login(String username, String password) {
        try {
            return userList.getUser(username, password);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } 
    }

    /**
     * Checks validity of username
     * @param username
     * @return boolean
     */
    public boolean checkValidityOfUsername (String username) {
        try {
            return userList.checkValidityOfUsername(username);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     * Adds RegisteredUser to User.json file 
     * @param newUser
     */
    public RegisteredUser addUser(Profile userProfile, String username, String password) {
        RegisteredUser user = null;
        
        try {
        	System.out.println("--");
            user = userList.addUser(userProfile, username, password);
            System.out.println("1213---");
        } catch (Exception e) {
            System.out.println(e);
        }

        return user;
    }

    /**
     * Returns list of all flights
     * @return array list of flights
     */
    public ArrayList<Flight> getAllFlights() {
        try {
            return flightList.getAllFlights();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Prints itinerary of current userx
     * @param currentUser
     */
    public void printItinerary(RegisteredUser currentUser) {
        try {
            userList.printItinerary(currentUser);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Prints friend list of current user
     * @param currentUser
     */
    public void printFriendsList(RegisteredUser currentUser) {
        try {
            userList.getFriendsList(currentUser);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Adds non-user friend to friend list
     * @param currentUser
     * @param first
     * @param last
     * @param dob
     * @param discount
     */
    public void addNonUserFriend(RegisteredUser currentUser, String first, String last, Date dob, String discount) {
        try {
            userList.addNonUserFriend(currentUser, first, last, dob, discount);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Adds user friend to friend list
     * @param currentUser
     * @param username
     */
    public void addUserFriend(RegisteredUser currentUser, String username) {
        try {
            userList.addUserFriend(currentUser, username);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
   
    /**
     * Removes friend from friend list
     * @param currentUser
     * @param first
     * @param last
     */
    public void removeFriend(RegisteredUser currentUser, String first, String last) {
        try {
            userList.removeFriend(currentUser, first, last);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Adds friend to hotel booking
     * @param currentUser
     * @param first
     * @param last
     * @param hotelBooking
     */
    public void addFriendToHotelBooking(RegisteredUser currentUser, String first, String last, HotelBooking hotelBooking) {
        try {
            hotelList.addTraveler(currentUser, first, last, hotelBooking);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Adds friend to flight booking
     * @param currentUser
     * @param first
     * @param last
     * @param flightBooking
     */
    public void addFriendToFlightBooking(RegisteredUser currentUser, String first, String last, FlightBooking flightBooking) {
        try {
            flightList.addTraveler(currentUser, first, last, flightBooking);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Adds room to hotel booking
     * @param hotelBooking
     * @param roomNum
     */
    public void addRoomToHotelBooking(HotelBooking hotelBooking, int roomNum) {
        try {
            hotelList.addRoom(hotelBooking, hotelBooking.getHotel(), roomNum);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Creates and returns flight booking
     * @param currentUser
     * @param flightSearch
     * @return flight booking
     */
    public FlightBooking createFlightBooking(RegisteredUser currentUser, ArrayList<Flight> flightSearch) {
        try {
            return flightList.createFlightBooking(currentUser, flightSearch);
        } catch (Exception e) {
            System.out.println(e); 
        }
        return null;
    }

    /**
     * Adds seats to flight booking
     * @param flightBooking
     * @param flight
     * @param seatNum
     */
    public void addSeatsToFlightBooking(FlightBooking flightBooking, Flight flight, String seatNum) {
        try {
            flightList.addSeatToFlightBooking(flight, seatNum, flightBooking);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    /**
     * Prints rooms of hotel
     * @param hotel
     * @param checkInDate
     * @param checkinTime
     * @param checkOutDate
     * @param checkOutTime
     */
    public void printRooms(Hotel hotel, Date checkInDate, String checkinTime, Date checkOutDate, String checkOutTime) {
        try {
            hotelList.printRoomByDateAndTime(hotel, checkInDate, checkinTime, checkOutDate, checkOutTime);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Prints available seats on flight
     * @param flight
     */
    public void printAvailableSeats(ArrayList<Flight> flight) {
        try {
            flightList.getAvailableSeats(flight);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Sets preferences of current user
     * @param currentUser
     * @param pref
     */
    public void setPreferences(RegisteredUser currentUser, Preferences pref) {
        try {
            userList.setPreferences(currentUser, pref);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Checks validity of inputted airline
     * @param airline
     * @return boolean
     */
    public boolean checkValidityOfAirline(String airline) {
        try {
            return flightList.checkValidityOfAirline(airline);
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    /**
     * Checks validity of inputted class
     * @param prefClass
     * @return boolean
     */
    public boolean checkValidityOfClass(String prefClass) {
        try {
            return flightList.checkValidityOfClass(prefClass);
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    /**
     * Checks validity of accessibility inputted by user
     * @param accessibility
     * @return boolean
     */
    public boolean checkValidityOfAccessibility(String accessibility) {
        try {
            return hotelList.checkValidityOfAccessibility(accessibility);
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     * Checks validity of amenity inputted by user
     * @param amenity
     * @return boolean
     */
    public boolean checkValidityOfAmenity(String amenity) {
        try {
            return hotelList.checkValidityOfAmenity(amenity);
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     * Returns flight search result
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of filtered flights 
     */
    public ArrayList<Flight> getSingleFlights(String departLocation, String destination, ArrayList<String> airline) {
        try {
            return flightList.getSingles(departLocation, destination, airline);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Returns hotel search result
     * @param location
     * @param amenities
     * @param accessibility
     * @param roomType
     * @param numOfBeds
     * @param rating
     * @return array list of filtered hotels
     */
    public ArrayList<Hotel> getHotelSearch(String location, ArrayList<Amenities> amenities, ArrayList<Accessibility> accessibility, String roomType, int numOfBeds, double rating) {
        try {
            return hotelList.getSearch(location, amenities, accessibility, roomType, numOfBeds, rating);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Books hotel
     * @param currentUser
     * @param hotel
     */
    public void bookHotel(RegisteredUser currentUser, HotelBooking hotel) {
        try {
            userList.bookHotel(currentUser, hotel);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Books flight
     * @param currentUser
     * @param flight
     */
    public void bookFlight(RegisteredUser currentUser, FlightBooking flight) {
        try {
            userList.bookFlight(currentUser, flight);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Returns booked flights list
     * @param currentUser
     * @return array list of booked flights
     */
    public ArrayList<FlightBooking> getBookedFlights(RegisteredUser currentUser) {
        try {
            return userList.getBookedFlights(currentUser);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Removes flight from bookedf light list
     * @param currentUser
     * @param flight
     */
    public void cancelFlight(RegisteredUser currentUser, FlightBooking flight) {
        try {
            userList.cancelFlight(currentUser, flight);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Returns booked hotels list
     * @param currentUser
     * @return array list of hotel bookings
     */
    public ArrayList<HotelBooking> getBookedHotels(RegisteredUser currentUser) {
        try {
            return userList.getBookedHotels(currentUser);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Removes hotel from booked hotels list
     * @param currentUser
     * @param hotel
     */
    public void cancelHotel(RegisteredUser currentUser, HotelBooking hotel) {
        try {
            userList.cancelHotel(currentUser, hotel);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Writes itinerary to file user named
     * @param currentUser
     * @param title
     */
    public void writeItineraryToFile(RegisteredUser currentUser, String title) {
        try {
            userList.writeItineraryToFile(currentUser, title);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Returns list all connecting flights
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of connecting flights
     */
    public ArrayList<ArrayList<Flight>> getConnectingFlights(String departLocation, String destination, ArrayList<String> airline) {
        try {
            return flightList.getConnectingFlights(departLocation, destination, airline);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Returns four flight matches - 1 direct flight, 2 single transfer, 1 double transfer
     * @param departLocation
     * @param destination
     * @param airline
     * @return string of four matches 
     */
    public void getFourMatches(String departLocation, String destination, ArrayList<String> airline) {
        try {
            flightList.getFourMatches(departLocation, destination, airline);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Returns direct flight match
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of single direct flight
     */
    public ArrayList<Flight> getFirstMatch(String departLocation, String destination, ArrayList<String> airline) {
        try {
            return flightList.getFirstMatch(departLocation, destination, airline);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Returns four hotel matches based on location
     * @param location
     * @return array list of hotels
     */
    public ArrayList<Hotel> getFourMatchesByLocation(String location) {
        try {
            return hotelList.getFourMatchesByLocation(location);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Returns all flights in first one transfer flight
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of flights for one transfer flight
     */
    public ArrayList<Flight> getSecondMatch(String departLocation, String destination, ArrayList<String> airline) {
        try {
            return flightList.getSecondMatch(departLocation, destination, airline);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Returns all flights in second one transfer flight
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of flights for one transfer flight
     */
    public ArrayList<Flight> getThirdMatch(String departLocation, String destination, ArrayList<String> airline) {
        try {
            return flightList.getThirdMatch(departLocation, destination, airline);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     * Returns all flights in two transflight flight
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of flights for one transfer flight
     */
    public ArrayList<Flight> getFourthMatch(String departLocation, String destination, ArrayList<String> airline) {
        try {
            return flightList.getFourthMatch(departLocation, destination, airline);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void quit(){
        flightList.saveFlights();
        HotelsList.saveHotels();
        userList.saveUsers();
    }
}
