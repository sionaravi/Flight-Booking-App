import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Flight Database Loader
 * 
 * @author JavaFine
 */
public class FlightDatabaseLoader {
  protected static final String FLIGHT_FILE = "flight.json";
  protected static final String ID = "id";
  protected static final String Departs_FROM = "departs from";
  protected static final String DESTINATION = "destination";
  protected static final String DEPARTURE_DATE = "departure date";
  protected static final String DEPARTURE_TIME = "departure time";
  protected static final String ARRIVAL_TIME = "arrival time";
  protected static final String SEATS = "seats";
  protected static final String AIRLINE = "Airline";

  /**
   * Returns JSON file as list of flights
   * 
   * @return array list of flights
   */
  public static ArrayList<Flight> getFlight() {
    ArrayList<Seat> seats = new ArrayList<Seat>();
    ArrayList<Flight> flights = new ArrayList<Flight>();
    try {
      // Read json file
      FileReader reader = new FileReader(FLIGHT_FILE);
      JSONParser parser = new JSONParser();
      JSONArray flightJason = (JSONArray) new JSONParser().parse(reader);

      // Loop though the variable
      for (int i = 0; i < flightJason.size(); i++) {
        JSONObject personJSON = (JSONObject) flightJason.get(i);

        String String_id = (String) personJSON.get("id");
        UUID id = UUID.fromString(String_id);
        String departs_from = (String) personJSON.get("departs from");
        String destination = (String) personJSON.get("destination");
        Date departure_date = parseDate((String)personJSON.get("departure date"));
        String departure_time = (String) personJSON.get("departure time");
        String arrival_time = (String) personJSON.get("arrival time");
        String Airline = (String) personJSON.get("Airline");

        // Find the seat and gointo the seat then loop it.
        JSONArray list = (JSONArray) personJSON.get("seats");
        for (int j = 0; j < list.size(); j++) {
          JSONObject getSeats = (JSONObject) list.get(j);
          String S_name = (String) getSeats.get("name");
          boolean availabe = (boolean) getSeats.get("available");
          // boolean availabe = false;
          /*
           * if (String_availabe.equalsIgnoreCase("true")) { availabe = true; }
           */
          // Get the number and avaiblibility, put them into new seat, and add to the arraylist
          Seat new_seat = new Seat(availabe, S_name);
          seats.add(new_seat);
        }
        // Add the whole information into single flight.
        Flight flight = new Flight(id, departs_from, destination, departure_date, departure_time,
            arrival_time, seats, Airline);
        // Add the every single flight to arraylist of flights.
        flights.add(flight);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return flights;
  }
  public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("MM/dd/yyyy").parse(date);
		} catch (ParseException e) {
			System.out.println("Sorry " + date + " is not parsable");
			return null;
		}
	}
}
