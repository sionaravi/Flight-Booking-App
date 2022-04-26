import java.util.ArrayList;

/**
 * Stores information for hotel booking
 * @author JavaFine
 */
public class HotelBooking {
    protected ArrayList<Profile> travelers;
    private ArrayList<Room> rooms;
    private Hotel hotel;

    /**
     * Creates an instance of the information for hotel booking
     * @param travelers
     * @param rooms
     * @param hotel
     */
    public HotelBooking(ArrayList<Profile> travelers, ArrayList<Room> rooms, Hotel hotel) {
        this.travelers = travelers;
        this.rooms = rooms;
        this.hotel = hotel;
    }

    public ArrayList<Profile> getTraveler() {
        return this.travelers;
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }

    /**
     * Adds friend to hotel booking
     * @param profile
     */
    public void addTraveler(Profile profile) {
        travelers.add(profile);
    }
    
    /**
     * Adds room to hotel booking
     * @param room
     */
    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Returns the name of the Hotel
     * @return
     */
    public Hotel getHotel() {
        return this.hotel;
    }

    /**
     * Returns the number of guests, rooms, and the hotel.
     */
    public String toString() {
        return "Guests: " + this.travelers + "\nRooms: " + this.rooms + "\nHotel: " + this.hotel;
    }
}
