import java.util.*;

/**
 * Users 
 * @author JavaFine
 */
public abstract class User {
    private FlightsList flightList;
    private HotelsList hotelList;

    /**
     * Returns four matches of flights 
     * @param departLocation
     * @param destination
     * @param airline
     * @return string of four matches 
     */
    public String getFourMatches(String departLocation, String destination, ArrayList<String> airline) {
        return flightList.getFourMatches(departLocation, destination, airline);
    }

    /**
     * Returns all straight flights
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of flights
     */
    public ArrayList<Flight> getSingleFlights(String departLocation, String destination, ArrayList<String> airline) {
        return flightList.getSingles(departLocation, destination, airline);
    }

    /**
     * Returns all connecting flights
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of connecting flights
     */
    public ArrayList<ArrayList<Flight>> getConnectingFlights(String departLocation, String destination, ArrayList<String> airline) {
        return flightList.getConnectingFlights(departLocation, destination, airline);
    }

    /**
     * Returns hotel search result
     * @param location
     * @param amenities
     * @param accessibility
     * @param roomType
     * @param numOfBeds
     * @param rating
     * @return hotel search array list
     */
    public ArrayList<Hotel> searchHotels(String location, ArrayList<Amenities> amenities, ArrayList<Accessibility> accessibility, String roomType, int numOfBeds, double rating) {
        return hotelList.getSearch(location, amenities, accessibility, roomType, numOfBeds, rating);
    }
}
