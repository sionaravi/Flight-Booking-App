import java.util.*;

/**
 * A Singleton Listing of Hotels
 * @author JavaFine
 */
public class HotelsList {
    private ArrayList<Hotel> hotels =new ArrayList<Hotel>();
    private ArrayList<Hotel> returnList=new ArrayList<Hotel>();
    private static HotelsList hotelList=new HotelsList();

    private HotelsList() {
        hotels = HotelDatabaseLoader.getHotel();
    }
    /**   
     * Creates a single instance of HotelsList and returns that single instance
     * @return HotelsList
     */
    public static HotelsList getInstance() {
        if (hotelList == null) {
            hotelList = new HotelsList();
        }
        return hotelList;
    }

    public void populateReturnListForTesting() {
        returnList.addAll(hotels);
    }

    public ArrayList<Hotel> getReturnList() {
        return returnList;
    }

    /**
     * Clears search array list
     */
    private void clearSearch() {
        returnList.clear();
    }

    /**
     * Returns list of all hotels from database
     * @return list of all hotels from database
     */
    public ArrayList<Hotel> getAllHotels() {
        return hotels;
    }

    /**
     * Returns hotel based on UUID
     * @param id
     * @return hotel
     */
    public Hotel getHotelByUUID(UUID id) {
        for (Hotel hotel : hotels) {
            if (hotel.getID().equals(id)) {
                return hotel;
            }
        }
        return null;
    }

    /**
     * Adds friend to traveler list of hotel booking
     * @param currentUser
     * @param first
     * @param last
     * @param hotelBooking
     */
    public void addTraveler(RegisteredUser currentUser, String first, String last, HotelBooking hotelBooking) {
        Friend friend = currentUser.getFriendByFristAndLast(first, last);
        hotelBooking.addTraveler(friend.getProfile());
    }

    /**
     * Adds room to hotel booking
     * @param hotelBooking
     * @param hotel
     * @param roomNum
     */
    public void addRoom(HotelBooking hotelBooking, Hotel hotel, int roomNum) {
        Room room = hotel.getHotelRooms().get(roomNum);
        hotelBooking.addRoom(room);
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
    public ArrayList<Hotel> getSearch(String location, ArrayList<Amenities> amenities,
        ArrayList<Accessibility> accessibility, String roomType, int numOfBeds, double rating) {
        clearSearch();
        getHotelByLocation(location);
        getHotelByAmenities(amenities);
        getHotelByAccessibility(accessibility);
        getHotelByRoomType(roomType);
        getHotelByNumberOfBeds(numOfBeds);
        getHotelByRating(rating);
        return returnList;
    }

    /**
     * Returns list of four hotel matches 
     * @param location
     * @return array list of hotels
     */
    public ArrayList<Hotel> getFourMatchesByLocation(String location) {
        clearSearch();
        getHotelByLocation(location);
        ArrayList<Hotel> fourMatches = new ArrayList<Hotel>();
        for(int i = 0; i < 4 && i < returnList.size(); i++) {
            fourMatches.add(returnList.get(i));
        }
        return fourMatches;
    }

    /**
     * Adds hotels that match location to return list
     * @param location
     */
    private void getHotelByLocation(String location) {

        for (Hotel hotel : hotels) {
            String hotelLocation = hotel.getLocation();
            if (hotelLocation.equals(location)) {
                returnList.add(hotel);
            }
        }
    }

    /**
     * Checks that inputted accessibility is valid
     * @param accessibility
     * @return
     */
    public boolean checkValidityOfAccessibility(String accessibility) {
        for (Accessibility access : EnumSet.allOf(Accessibility.class)) {
            if (accessibility.equals(access.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks that inputted amenity is valid
     * @param amenity
     * @return
     */
    public boolean checkValidityOfAmenity(String amenity) {
    	boolean check = false;
        for (Amenities amen : EnumSet.allOf(Amenities.class)) {
            if (amenity.equals(amen.toString())) {
            	check =true;
               // return true;
            }
        }
        return check;
    }

    /**
     * Removes hotels if rating is not as good as or better than inputted rating preference
     * @param rating
     */
    private void getHotelByRating(double rating) {
        for (Hotel hotel: hotels) {
            double hotelRating = hotel.getRating();
            if (hotelRating <= rating) {
                returnList.remove(hotel);
            }
        }
    }

    /**
     * Removes hotels that don't match amentiies
     * @param amenities
     */
    private void getHotelByAmenities(ArrayList<Amenities> amenities) {
        EnumSet<Amenities> amenitiesList = EnumSet.allOf(Amenities.class);
        ArrayList<Amenities> removeList = new ArrayList<Amenities>();
        for (Amenities amen : amenitiesList) {
            removeList.add(amen);
        }
        removeList.removeAll(amenities);
        for (Hotel search : returnList) {
            ArrayList<Amenities> amenity = search.getAmenities();
            for (Amenities rem : removeList) {
                for (Amenities cur : amenity) {
                    if (cur.equals(rem)) {
                        returnList.remove(search);
                    }
                }
            }
        }
    }

    /**
     * Removes hotels that don't match accessibility
     * @param accessibility
     */
    private void getHotelByAccessibility(ArrayList<Accessibility> accessibility) {
        EnumSet<Accessibility> accessibilityList = EnumSet.allOf(Accessibility.class);
        ArrayList<Accessibility> removeList = new ArrayList<Accessibility>();
        for (Accessibility access : accessibilityList) {
            removeList.add(access);
        }
        removeList.removeAll(accessibility);
        for (Hotel search : returnList) {
            for (Accessibility rem : removeList) {
                ArrayList<Accessibility> accessibilities = search.getAccessibility();
                for (Accessibility cur : accessibilities) {
                    if (cur.equals(rem)) {
                        returnList.remove(search);
                    }
                }
            }
        }
    }

    /**
     * Removes hotels that don't match room type
     * @param roomType
     */
    public void getHotelByRoomType(String roomType) {
        if (!roomType.equals("none")) {
            for (Hotel search : returnList) {
                if (!search.getRoomType().equals(roomType)) {
                    returnList.remove(search);
                }
            }
        }
    }

    /**
     * Removes hotels that don't match number of beds
     * @param numOfBeds
     */
    public void getHotelByNumberOfBeds(int numOfBeds) {
        if (numOfBeds != 0) {
            for (Hotel search : returnList) {
                if (search.getnumOfBeds() == numOfBeds) {
                    returnList.add(search);
                }
            }
        }
    }

    public void printRoomByDateAndTime(Hotel hotel, Date checkInDate, String checkinTime,
        Date checkOutDate, String checkOutTime) {
        ArrayList<Room> rooms = hotel.getHotelRooms();
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomCheckInDate().equals(checkInDate) && rooms.get(i).getRoomCheckInTime().equals(checkinTime) && rooms.get(i).getRoomCheckOutDate().equals(checkOutDate) && rooms.get(i).getRoomCheckOutTime().equals(checkOutTime)) {
                System.out.println(rooms.get(i).toString());
            }
        }
    }

    /**
     * Removes hotel from JSON 
     * @param hotelID
     */
    public void cancelHotel(UUID hotelID) {
        for (Hotel hotel : hotels) {
            if (hotel.getID().equals(hotelID)) {
                int pos = this.hotels.indexOf(hotel);
                hotels.remove(pos);
            }
        }
    }
    public static void saveHotels() {
        HotelDatabaseWriter.saveHotels();
    }
}
