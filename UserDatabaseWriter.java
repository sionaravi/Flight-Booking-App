import java.io.*;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Hotel Database Writer 
 * @author JavaFine
 */
public class UserDatabaseWriter {
  protected static final String User_FILE_NAME = "src/users.json";
  protected static final String User_FILE_Id = "id";
  protected static final String User_FILE_User_Id = "user-id";
  protected static final String User_FILE_Password = "password";
  protected static final String User_FILE_First_Name = "firstname";
  protected static final String User_FILE_Last_Name = "lastname";
  protected static final String User_FILE_Address = "address";
  protected static final String User_FILE_City = "city";
  protected static final String User_FILE_State = "state";
  protected static final String User_FILE_Zip = "zip";
  protected static final String User_FILE_Date_Of_Birthday = "d.o.b";
  protected static final String User_FILE_Email_Address = "emailAddress";
  protected static final String User_FILE_Phone_Number = "phoneNumber";
  protected static final String User_FILE_Disability = "disability";
  protected static final String User_FILE_Visa = "visa";
  protected static final String User_FILE_Occupation = "occupation";
  protected static final String User_FILE_Discount = "discount";

  protected static final String Friends = "Friends";
  protected static final String Friend_ID = "id";
  protected static final String Friend_First_Name = "firstname";
  protected static final String Friend_Last_Name = "lastname";
  protected static final String Friend_Date_Of_Birthday = "d.0.b";
  protected static final String Friend_Discount = "discount";

  protected static final String Friend_Flights = "flights";
  protected static final String Friend_Flight_id = "flightid";
  protected static final String Friend_Flight_Seat = "seat";

  protected static final String Friend_Hotels = "hotels";
  protected static final String Friend_Hotel_id = "hotelid";
  protected static final String Friend_Hotel_Check_In_Day = "check in day";
  protected static final String Friend_Hotel_Check_Out_Day = "check out day";

  /**
   * Saves registered users
   */
  public static void saveUsers() {
    UserList users = UserList.getInstance();
    ArrayList<RegisteredUser> currentUsers = users.getAllUsers();
    JSONArray jasonUsers = new JSONArray();

    for (int i = 0; i < currentUsers.size(); i++) {
      // Give a array in the begining
      jasonUsers.add(getUsersJSON(currentUsers.get(i)));
    }
    try (FileWriter file = new FileWriter(User_FILE_NAME)) {
      file.write(jasonUsers.toJSONString());
      file.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets registered users from JSON file
   */
  public static JSONObject getUsersJSON(RegisteredUser user) {
    // Creat a object of JSON
    JSONObject jsonoF = new JSONObject();
    
    String StringUUID = user.getID().toString();
    jsonoF.put(User_FILE_Id, StringUUID);
    jsonoF.put(User_FILE_Password, user.getPassword());
    jsonoF.put(User_FILE_First_Name,user.getProfile().getFirst());
	  jsonoF.put(User_FILE_Last_Name,user.getProfile().getLast());
    jsonoF.put(User_FILE_City,user.getProfile().getCity());
    jsonoF.put(User_FILE_State,user.getProfile().getState());
    jsonoF.put(User_FILE_Zip,user.getProfile().getZip());
    jsonoF.put(User_FILE_Date_Of_Birthday,user.getProfile().getDOB());
    jsonoF.put(User_FILE_Email_Address,user.getProfile().getEmailAddress());
  	jsonoF.put(User_FILE_Phone_Number,user.getProfile().getPhoneNumber());
    jsonoF.put(User_FILE_Disability,user.getProfile().getDisability());
    jsonoF.put(User_FILE_Visa,user.getProfile().getVisa());
    jsonoF.put(User_FILE_Occupation,user.getProfile().getOccupation());
    jsonoF.put(User_FILE_Discount,user.getProfile().getDiscount());

    JSONArray jasonFriends = new JSONArray();
    jsonoF.put(Friends, jasonFriends);
    ArrayList<Friend> currentFriends = user.getFriends();

    for (int j = 0; j < currentFriends.size(); j++) {
      JSONArray jasonFlight = new JSONArray();
      jsonoF.put(Friend_Flights, jasonFlight);
      // Problem
      ArrayList<Flight> currentFlights = user.getFriends().get(j).getFlights();
        
      for (int k = 0; k < currentFlights.size(); k++) {
        jasonFlight.add(getFlightsJSON(currentFlights.get(k)));
      }
      JSONArray jasonHotel = new JSONArray();
      jsonoF.put(Friend_Hotels, jasonHotel);
      // Problem
      ArrayList<Hotel> currentHotels = user.getFriends().get(j).getHotels();
    
      for (int i= 0; i < currentHotels.size(); i++) {
        jasonHotel.add(getHotelsJSON(currentHotels.get(i)));
      }
      jasonFriends.add(getFriendsJSON(currentFriends.get(j)));
    }
    return jsonoF;
  }

  /**
   * Gets friends from JSON
   * @param friend
   * @return
   */
  public static JSONObject getFriendsJSON(Friend friend) {
    JSONObject jsonoS = new JSONObject();
    jsonoS.put(Friend_ID , friend.getID());
	  jsonoS.put(Friend_First_Name,friend.getFirstName());
	  jsonoS.put(Friend_Last_Name,friend.getLastName());
	  jsonoS.put(Friend_Date_Of_Birthday,friend.getDateOfBirthday());
	  jsonoS.put(Friend_Discount,friend.getDiscount());
	  jsonoS.put(Friend_Flights,friend.getFlights());
	  jsonoS.put(Friend_Hotels,friend.getHotels());
    return jsonoS;
  }

  /**
   * Gets user's flights from JSON file
   * @param flight
   * @return
   */
  public static JSONObject getFlightsJSON(Flight flight) {
    JSONObject jsonoS = new JSONObject();
    jsonoS.put(Friend_Flight_id , flight.getID());
	  jsonoS.put(Friend_Flight_Seat,flight.getFlightSeats());
    return jsonoS;
  }

  /**
   * Gets user's hotels from JSON file
   * @param hotel
   * @return
   */
  public static JSONObject getHotelsJSON(Hotel hotel) {
    JSONObject jsonoS = new JSONObject();
    jsonoS.put(Friend_Hotel_id, hotel.getID());
    jsonoS.put(Friend_Hotel_Check_In_Day,hotel.getCheckInDay());
	  jsonoS.put(Friend_Hotel_Check_Out_Day,hotel.getCheckOutDay());
    return jsonoS;
  }
  
  
}