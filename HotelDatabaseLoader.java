import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Hotel Database Loader
 * @author JavaFine
 */
public class HotelDatabaseLoader{
	protected static final String HOTEL_FILE_NAME = "hotels.json";
	protected static final String HOTEL_FILE_ID = "id";
	protected static final String HOTEL_FILE_CITY = "city";
	protected static final String HOTEL_FILE_CHECK_IN_DATE = "check in date";
	protected static final String HOTEL_FILE_CHECK_OUT_DATE="check out date";
	protected static final String HOTEL_FILE_CHECK_IN_TIME="check in time";
	protected static final String HOTEL_FILE_CHECK_OUT_TIME="check out time";
	protected static final String HOTEL_NAME="hotel name";
	protected static final String HOTEL_ROOM_TYPE="room type";
	protected static final String HOTEL_NUMBER_OF_BEDS="number of beds";
	protected static final String HOTEL_Price_Per_Night="Price per night";
	
	/**
	 * Returns list of hotels from JSON file
	 * @return array list of hotels
	 */
	public static ArrayList<Hotel> getHotel() {
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		ArrayList<Room> rooms = new ArrayList<Room>();
		
		try {
			//Read json file
			FileReader reader = new FileReader(HOTEL_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray hotelJason = (JSONArray) new JSONParser().parse(reader);
			
			for(int i =0;i<hotelJason.size();i++) {
				JSONObject hotelJSON =(JSONObject) hotelJason.get(i);
				UUID id =UUID.fromString((String) hotelJSON.get("id"));
				String city = (String) hotelJSON.get("city");
				
				String hotel_name=(String)hotelJSON.get("hotel name");
				
				JSONArray list = (JSONArray) hotelJSON.get("rooms");
				for (int j = 0; j < list.size(); j++) {
					JSONObject getRooms = (JSONObject) list.get(j);
					String room_type=(String)getRooms.get("room type");
					int number_of_beds=((Long)getRooms.get("number of beds")).intValue();
					Date check_in_date =parseDate((String)getRooms.get("check in date"));
					Date check_out_date =parseDate((String)getRooms.get("check out date"));
					String check_in_time=(String) getRooms.get("check in time");
					String check_out_time=(String) getRooms.get("check out time");
					
					String Price_Per_Night=(String) hotelJSON.get("Price per night");
					Room new_room = new Room(room_type, number_of_beds,check_in_date,check_out_date, check_in_time,check_out_time,Price_Per_Night);
					rooms.add(new_room);
        		}
				Hotel hotel = new Hotel(id, city,hotel_name,rooms);
				hotels.add(hotel);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return hotels;
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

