import java.util.*;

/**
 * A Hotel
 * @author JavaFine
 */
public class Hotel{
    private UUID id; 
    private String name;
    private String city;
    private ArrayList<Room> rooms;
    private ArrayList<Amenities> amenities;
    private ArrayList<Accessibility> accessibilities;
    private String roomType;
    private String typeOfBeds;
    private int numOfBeds;
    private String checkOutDay;
    private String checkInDay;
    private Double rating;
    private String checkInTime;
    private String checkOutTime;
    private String pricePerNight;
    private String totalPrice;

    public Hotel() {
        
    }
    /**
     * Loads JSON File
     * @param id
     * @param name
     * @param city
     * @param rooms
     */
    public Hotel(UUID id, String city, String name, ArrayList<Room> rooms) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.rooms = rooms;
    }

    /**
     * Returns list of amenities of hotel
     * @return array list of amenities 
     */
    public ArrayList<Amenities> getAmenities() {
        return this.amenities;
    }

    /**
     * Returns location of hotel
     * @return location
     */
    public String getLocation() {
        return this.city;
    }

    /**
     * Returns list of accessibilities of hotel
     * @return array list of accessibilities
     */
    public ArrayList<Accessibility> getAccessibility() {
        return this.accessibilities;
    }

    /**
     * Adds amentity to amenities list
     * @param amenity
     */
    public void addAmenities(Amenities amenity) {
        amenities.add(amenity);
    }

    /**
     * Removes amenity from amentiies list 
     * @param amenity
     */
    public void removeAmenity(Amenities amenity) {
        amenities.remove(amenity);
    }

    /**
     * Adds accessibility to accessibilities list
     * @param accessibility
     */
    public void addAccessibility(Accessibility accessibility) {
        accessibilities.add(accessibility);
    }

    /**
     * Removes accessibility from accessibilities list 
     * @param accessibility
     */
    public void removeAccessibility(Accessibility accessibility) {
        accessibilities.remove(accessibility);
    }

    /**
     * Returns UUID
     * @return UUID
     */
    public Object getID() {
        return this.id;
    }

    /**
     * Returns name of hotel
     * @return hotel name
     */
    public String getHotelName() {
        return this.name;
    }

    /**
     * Returns list of hotel rooms 
     * @return array list of hotel rooms
     */
    public ArrayList<Room> getHotelRooms() {
        return this.rooms;
    }

    /**
     * Returns room type
     * @return room type 
     */
    public String getRoomType() {
        return this.getRoomType();
    }

    /**
     * Returns number of beds 
     * @return number of beds 
     */
    public int getnumOfBeds() {
        return this.getnumOfBeds();
    }

    /**
     * Returns check in day
     * @return check in day
     */
    public String getCheckInDay() {
        return checkInDay;
    }

    /**
     * Returns check out day
     * @return
     */
    public String getCheckOutDay() {
        return checkOutDay;
    }

    /**
     * Returns rating
     * @return rating 
     */
    public Double getRating() {
        return this.rating;
    }
    public String toString() {
        return " Name: " + name + "Rating: " + rating + "Check in day: " + checkInDay + "Check out day: " + checkOutDay;
    }
}
