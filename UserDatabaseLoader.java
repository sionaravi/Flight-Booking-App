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
 * User Database Loader
 * 
 * @author JavaFine
 */
public class UserDatabaseLoader {
  protected static final String User_FILE_NAME = "users.json";
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

  protected static final String User_Friends = "Friends";

  /**
   * Returns list of users from JSON file
   * 
   * @return array list of users
   */
  public static ArrayList<RegisteredUser> getUser() {
    ArrayList<RegisteredUser> users = new ArrayList<RegisteredUser>();
    ArrayList<Friend> friends = new ArrayList<Friend>();
    ArrayList<Flight> flights = new ArrayList<Flight>();
    ArrayList<Hotel> hotels = new ArrayList<Hotel>();

    try {
      // Read json file
      FileReader reader = new FileReader(User_FILE_NAME);
      JSONParser parser = new JSONParser();
      JSONArray userJason = (JSONArray) new JSONParser().parse(reader);

      for (int i = 0; i < userJason.size(); i++) {
        JSONObject userJSON = (JSONObject) userJason.get(i);
        String String_id = (String) userJSON.get("id");
        UUID id = UUID.fromString(String_id);
        String userID = (String) userJSON.get("user-id");
        String password = (String) userJSON.get("password");
        String firstName = (String) userJSON.get("firstname");
        String lastName = (String) userJSON.get("lastname");
        String address = (String) userJSON.get("address");
        String city = (String) userJSON.get("city");
        String state = (String) userJSON.get("state");
        String zip = (String) userJSON.get("zip");
        Date dateOfBirthday = parseDate((String) userJSON.get("d.o.b"));
        String emailAddress = (String) userJSON.get("emailAddress");
        String phoneNumber = (String) userJSON.get("phoneNumber");
        Boolean disability = (Boolean) userJSON.get("disability");
        String visa = (String) userJSON.get("visa");
        String occupation = (String) userJSON.get("occupation");
        String discount = (String) userJSON.get("discount");

        JSONArray list = (JSONArray) userJSON.get("Friends");
        for (int j = 0; j < list.size(); j++) 
        {
          JSONObject getFriends = (JSONObject) list.get(j);
          String String_Friend_ID = (String) getFriends.get("id");
          UUID Friend_ID = UUID.fromString(String_Friend_ID);
          String Friend_FirstName = (String) getFriends.get("firstname");
          String Friend_LastName = (String) getFriends.get("lastname");
          Date Friend_DateOfBirthday = parseDate((String) userJSON.get("d.o.b"));
          String Friend_Discount = (String) getFriends.get("discount");

          JSONArray list_flight = (JSONArray) getFriends.get("flights");
          for (int k = 0; k < list_flight.size(); k++) {
            JSONObject getFri_flight = (JSONObject) list_flight.get(k);
       
            String String_Flight_ID = (String) getFri_flight.get("flightid");
           // System.out.println(String_Flight_ID);
            UUID Flight_ID = UUID.fromString(String_Friend_ID);
            String Flight_Seat = (String) getFri_flight.get("seat");
          }
          JSONArray list_hotel = (JSONArray) getFriends.get("hotels");
          for (int m = 0; m < list_hotel.size(); m++) {
            JSONObject getFri_hotel = (JSONObject) list_hotel.get(m);
            String String_Hotel_ID = (String) getFri_hotel.get("hotelid");
           // System.out.println(String_Hotel_ID);
            UUID Hotel_ID = UUID.fromString(String_Hotel_ID);
            Date Hotel_Room_Check_IN_Day = parseDate((String) getFri_hotel.get("check in day"));
          }
          
          Friend new_friend = new Friend(Friend_ID, Friend_FirstName, Friend_LastName,
              Friend_DateOfBirthday, Friend_Discount, flights, hotels);
          friends.add(new_friend);
        }
        Profile new_User =
            new Profile(firstName, lastName, address, city, state, zip, dateOfBirthday,
                emailAddress, phoneNumber, visa, disability.booleanValue(), occupation, discount);
        RegisteredUser user = new RegisteredUser(id, friends, new_User, userID, password);
        users.add(user);
        return users;
      }
    } catch (Exception e) {
      System.out.println(e);
    }
    return users;
  }

  public static Date parseDate(String date) {
    try {
      return new SimpleDateFormat("mm/dd/yyyy").parse(date);
    } catch (ParseException e) {
      System.out.println("Sorry " + date + " is not parsable");
      return null;
    }
  }
}
