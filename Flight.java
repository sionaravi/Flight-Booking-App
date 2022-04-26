import java.util.*;

/**
 * A Flight 
 * @author JavaFine
 */
public class Flight {
  private UUID id;
  private String departLocation;
  private String destination;
  private Date departDate;
  private String departTime;
  private String arrivalTime;
  private ArrayList<Seat> flightSeats;
  private String airline;

  /**
   * Loads JSON File
   * @param id
   * @param departLocation
   * @param destination
   * @param departDate
   * @param departTime
   * @param arrivalTime
   * @param flightSeats
   * @param airline
   */
  public Flight(UUID id, String departLocation, String destination, Date departDate,
      String departTime, String arrivalTime, ArrayList<Seat> flightSeats, String airline) {
    this.id = id;
    this.departLocation = departLocation;
    this.destination = destination;
    this.departDate = departDate;
    this.departTime = departTime;
    this.arrivalTime = arrivalTime;
    this.flightSeats = flightSeats;
    this.airline = airline;
  }

  /**
   * Returns seat based on inputted seat number
   * @param seatNum
   * @return seat
   */
  public Seat getSeatBySeatNumber(String seatNum) {
    for (Seat seat : flightSeats) {
      if (seat.getSeatNumber().equals(seatNum)) {
        return seat;
      }
    }
    return null;
  }

  /**
   * Returns UUID
   * @return UUID
   */
  public UUID getID() {
    return this.id;
  }

  /**
   * Returns departure location
   * @return departure location 
   */
  public String getDepartLocation() {
    return this.departLocation;
  }

  /**
   * Returns destination location
   * @return destination location
   */
  public String getDestination() {
    return this.destination;
  }

  /**
   * Returns departure date
   * @return departure date
   */
  public Date getDepartDate() {
    return this.departDate;
  }

  /**
   * Returns departure time
   * @return departure time
   */
  public String getDepartTime() {
    return this.departTime;
  }

  /**
   * Returns arrival time 
   * @return arrival time
   */
  public String getArrivalTime() {
    return this.arrivalTime;
  }

  /**
   * Returns flight seats
   * @return array list of seats 
   */
  public ArrayList<Seat> getFlightSeats() {
    return flightSeats;
  }

  /**
   * Returns airline
   * @return airline
   */
  public String getAirline() {
    return this.airline;
  }

  /**
   * Returns string form of Flight Class
   * @return string 
   */
  public String toString() {
    return "Departure Location: " + this.departLocation + " Destination: " + this.destination + "\nDepature Date: " + this.departDate + " Departure Time: " + this.departTime + " Arrival Time: " + this.arrivalTime;
  }
}