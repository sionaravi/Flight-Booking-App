import java.util.ArrayList;

/**
 * Stores information for flight booking
 * @author JavaFine
 */
public class FlightBooking {
    protected ArrayList<Profile> travelers;
    private ArrayList<Seat> seats;
    private ArrayList<Flight> flights;

    /**
     * Constructs an instance of the information for flight booking
     * @param travelers
     * @param seats
     * @param flights
     */
    public FlightBooking(ArrayList<Profile> travelers, ArrayList<Seat> seats, ArrayList<Flight> flights) {
        this.travelers = travelers;
        this.seats = seats;
        this.flights = flights;
    }

    public ArrayList<Profile> getTraveler() {
        return this.travelers;
    }

    public ArrayList<Seat> getSeat() {
        return this.seats;
    }

    /**
     * Adds traveler to traveler list
     * @param profile
     */
    public void addTraveler(Profile profile) {
        travelers.add(profile);
    }

    /**
     * Adds seat to seat list
     * @param seat
     */
    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    /**
     * Return a list of the booked flights
     * @return array list of flights 
     */
    public ArrayList<Flight> getFlight() {
        return this.flights;
    }

    /**
     * Returns a string representing the flight booking
     * @return string
     */
    public String toString() {
        return "Travelers:\n" + this.travelers + "\nSeats:\n" + this.seats + "\nFlights:\n" + this.flights;
    }
}
