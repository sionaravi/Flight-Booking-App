import java.util.ArrayList;
import java.util.EnumSet;
import java.util.UUID;

/**
 * A Singleton Listing of Flights
 * 
 * @author JavaFine
 */
public class FlightsList {
    private FlightDatabaseLoader flightLoader = new FlightDatabaseLoader();
    private ArrayList<Flight> flights = new ArrayList<Flight>();
    private static FlightsList flightList=new FlightsList(); 

    private FlightsList() {
        flights = flightLoader.getFlight(); //first line of get all flights
    }
    /**
     * Returns instance of flights list
     * @return flights list
     */
    public static FlightsList getInstance() {
        if (flightList == null) {
            flightList = new FlightsList();
        }
        return flightList;
    }

    /**
     * Returns a single flight by UUID
     * @param id
     * @return flight
     */
    public Flight getFlightByUUID(UUID id) {
        for (Flight flight : flights) {
            if (flight.getID().equals(id))
                return flight;
            }
        return null;
    }

    /**
     * Returns list of all flights
     * @return all flights
     */
    public ArrayList<Flight> getAllFlights() {
        return flights;
    }

    /**
     * Returns string with four flight matches
     * @param departLocation
     * @param destination
     * @param airline
     * @return string of four flight matches
     */
    public void getFourMatches(String departLocation, String destination, ArrayList<String> airline) {
        ArrayList<Flight> firstMatch = getFirstMatch(departLocation, destination, airline);
        ArrayList<Flight> secondMatch = getSecondMatch(departLocation, destination, airline);
        ArrayList<Flight> thirdMatch = getThirdMatch(departLocation, destination, airline);
        ArrayList<Flight> fourthMatch = getFourthMatch(departLocation, destination, airline);
        System.out.println("Flight 1. " + firstMatch.toString());
    	System.out.println("\nFlight 2. " + secondMatch.toString());
    	System.out.println("\nFlight 3. " + thirdMatch.toString());
        System.out.println("\nFlight 4. " + fourthMatch.toString());
    
           
    }

    /**
     * Gets first match - direct flight
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of single direct flight
     */
    public ArrayList<Flight> getFirstMatch(String departLocation, String destination, ArrayList<String> airline) {
        ArrayList<Flight> firstMatch = new ArrayList<Flight>();
        do {
            for(Flight flight: flights) {
                if(flight.getDepartLocation().equals(departLocation) && flight.getDestination().equals(destination) && checkAirline(airline)) {
                    firstMatch.add(flight);
                }
            }
        } while(firstMatch.size() == 0);
        return firstMatch;
    }

    /**
     * Checks validity of inputted airline company preference
     * @param airline
     * @return boolean
     */
    public boolean checkValidityOfAirline(String airline) {
        for (AirlineCompany comp : EnumSet.allOf(AirlineCompany.class)) {
            if (airline.equals(comp.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks validity of inputted class preference 
     * @param prefClass
     * @return
     */
    public boolean checkValidityOfClass(String prefClass) {
        for (FlightClass flightClass : EnumSet.allOf(FlightClass.class)) {
            if (prefClass.equals(flightClass.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns second match - one transfer flight
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of two flights 
     */
    public ArrayList<Flight> getSecondMatch(String departLocation, String destination, ArrayList<String> airline) {
    	ArrayList<ArrayList<Flight>> singleTransfers = new ArrayList<ArrayList<Flight>>();
        getTwoConnectingFlights(singleTransfers, departLocation, destination, airline);

        if(singleTransfers.size() <= 1){
            return null;
        }
        return singleTransfers.get(0);
    }

    /**
     * Returns third match - one transfer flight
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of two flights 
     */
    public ArrayList<Flight> getThirdMatch(String departLocation, String destination, ArrayList<String> airline) {
        ArrayList<ArrayList<Flight>> singleTransfers = new ArrayList<ArrayList<Flight>>();
        getTwoConnectingFlights(singleTransfers, departLocation, destination, airline);

        if(singleTransfers.size() <= 1){
            return null;
        }
        return singleTransfers.get(1);
    }

    /**
     * Returns fourth match - two transfer flight
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of three flights 
     */
    public ArrayList<Flight> getFourthMatch(String departLocation, String destination, ArrayList<String> airline) {
        ArrayList<ArrayList<Flight>> twoTransfers = new ArrayList<ArrayList<Flight>>();
        getThreeConnectingFlights(twoTransfers, departLocation, destination, airline);

        if(twoTransfers.size() == 0) {
            return null;
        }
        return twoTransfers.get(0);
    }

    /**
     * Checks list of inputted airline companies for validity
     * @param airline
     * @return boolean
     */
    private boolean checkAirline(ArrayList<String> airline) {
        EnumSet<AirlineCompany> airlineList = EnumSet.allOf(AirlineCompany.class);
        for (String air : airline) {
            for (AirlineCompany comp : airlineList) {
                if (comp.toString().equals(air)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns list of all direct flights 
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of flights 
     */
    public ArrayList<Flight> getSingles(String departLocation, String destination, ArrayList<String> airline) {
        ArrayList<Flight> returnList = new ArrayList<Flight>();
        getFlightsGen(returnList, departLocation, destination);
        getFlightByAirline(returnList, airline);
        return returnList;
    }

    /**
     * Returns list of all connecting flights 
     * @param departLocation
     * @param destination
     * @param airline
     * @return array list of connecting flights 
     */
    public ArrayList<ArrayList<Flight>> getConnectingFlights(String departLocation,
        String destination, ArrayList<String> airline) {
        ArrayList<ArrayList<Flight>> returnList = new ArrayList<ArrayList<Flight>>();
        getTwoConnectingFlights(returnList, departLocation, destination, airline);
        getThreeConnectingFlights(returnList, departLocation, destination, airline);
        return returnList;
    }

    /**
     * Adds two transfer flights to list of flights 
     * @param returnList
     * @param departLocation
     * @param destination
     * @param airline
     */
    public void getThreeConnectingFlights(ArrayList<ArrayList<Flight>> returnList, String departLocation, String destination, ArrayList<String> airline) {
    	ArrayList<Flight> init = getFlightByDepartLocation(airline, departLocation);
    	ArrayList<Flight> fin = getFlightByDestination(airline, destination);
    	ArrayList<Flight> between = getAllFlights();
    	getFlightByAirline(between, airline);
    	ArrayList<ArrayList<Flight>> firstTwo = new ArrayList<ArrayList<Flight>>();
    	for (Flight in: init) {
    	for (Flight bet: between) {
    	if(in.getDestination().equals(bet.getDepartLocation())) {
    	ArrayList<Flight> temp = new ArrayList<Flight>();
    	temp.add(in);
    	temp.add(bet);
    	firstTwo.add(temp);
    	}
    	}
    	}
    	for (ArrayList<Flight> bet: firstTwo) {
    	for (Flight f: fin) {
    	if(bet.get(1).getDestination().equals(f.getDepartLocation())) {
    	ArrayList<Flight> threeFlights = new ArrayList<Flight>();
    	threeFlights.addAll(bet);
    	threeFlights.add(f);
    	returnList.add(threeFlights);
    	}
    	}
    	}}

    /**
     * Adds one transfer flights to list of flights 
     * @param returnList
     * @param departLocation
     * @param destination
     * @param airline
     */
    public void getTwoConnectingFlights(ArrayList<ArrayList<Flight>> returnList,
        String departLocation, String destination, ArrayList<String> airline) {
        ArrayList<Flight> initial = getFlightByDestination(airline, destination);
        ArrayList<Flight> check = getFlightByDepartLocation(airline, departLocation);
        for (Flight init : initial) {
            for (Flight ch : check) {
                ArrayList<Flight> twoFlights = new ArrayList<Flight>();
                if (init.getDepartLocation().equals(ch.getDestination())) {
                    twoFlights.add(init);
                    twoFlights.add(ch);
                    returnList.add(twoFlights);
                }
            }
        }
    }

    /**
     * Removes flights based on airline
     * @param filterList
     * @param airline
     */
    public void getFlightByAirline(ArrayList<Flight> filterList, ArrayList<String> airline) {
        EnumSet<AirlineCompany> airlineList = EnumSet.allOf(AirlineCompany.class);
        ArrayList<String> removeList = new ArrayList<String>();
        for (AirlineCompany comp : airlineList) {
            removeList.add(comp.toString());
        }
        removeList.removeAll(airline);
        for (Flight flight : flights) {
            for (String rem : removeList) {
                if (flight.getAirline().equals(rem)) {
                    filterList.remove(flight);
                }
            }
        }
    }

    /**
     * Returns list of flights filtered by destination and airline
     * @param airline
     * @param destination
     * @return array list of flights
     */
    public ArrayList<Flight> getFlightByDestination(ArrayList<String> airline, String destination) {
        ArrayList<Flight> flightByDest = new ArrayList<Flight>();
        for (Flight flight : flights) {
            if (flight.getDestination().equals(destination)) {
                flightByDest.add(flight);
            }
        }
        getFlightByAirline(flightByDest, airline);
        return flightByDest;
    }

    /**
     * Adds traveler to flightbooking 
     * @param currentUser
     * @param first
     * @param last
     * @param flightBooking
     */
    public void addTraveler(RegisteredUser currentUser, String first, String last, FlightBooking flightBooking) {
        Friend friend = currentUser.getFriendByFristAndLast(first, last);
        flightBooking.addTraveler(friend.getProfile());
    }

    /**
     * Creates flight booking
     * @param currentUser
     * @param flightSearch
     * @return
     */
    public FlightBooking createFlightBooking(RegisteredUser currentUser, ArrayList<Flight> flightSearch) {
        ArrayList<Profile> travelers = new ArrayList<Profile>();
        travelers.add(currentUser.getProfile());
        ArrayList<Seat> seats = new ArrayList<Seat>();
        return new FlightBooking(travelers, seats, flightSearch);
    }

    /**
     * Returns list of flights filtered by departure location and airline
     * @param airline
     * @param departLocation
     * @return array list of flights
     */
    public ArrayList<Flight> getFlightByDepartLocation(ArrayList<String> airline,
        String departLocation) {
        ArrayList<Flight> flightByDepart = new ArrayList<Flight>();
        for (Flight flight : flights) {
            if (flight.getDepartLocation().equals(departLocation)) {
                flightByDepart.add(flight);
            }
        }
        getFlightByAirline(flightByDepart, airline);
        return flightByDepart;
    }

    /**
     * Adds flights based on departure location and destination
     */
    public void getFlightsGen(ArrayList<Flight> returnList, String departLocation, String destination) {
        for (Flight flight : flights) {
            if (flight.getDepartLocation().equals(departLocation) && flight.getDestination().equals(destination)) {
                returnList.add(flight);
            }
        }
    }

    /**
     * Returns list of available seats on flight
     * @param flight
     * @return
     */
    public void getAvailableSeats(ArrayList<Flight> flights) {
        for(Flight flight: flights) {
        	ArrayList<Seat> flightSeats = flight.getFlightSeats();
        	for (Seat seat : flightSeats) {
                if (!seat.isOccupied()) {
                    System.out.println(seat.toString());
                }
            }
        }
    }

    /**
     * Returns seat based on seat number
     * @param flight
     * @param seatNum
     * @return
     */
    public Seat addSeatToFlightBooking(Flight flight, String seatNum, FlightBooking flightBooking) {
        Seat seat = flight.getSeatBySeatNumber(seatNum);
        flightBooking.addSeat(seat);
        return null;
    }

    /**
     * Cancels flight by UUID
     */
    public void cancelFlight(UUID UUID) {
        for (Flight flight : flights) {
            if (flight.getID().equals(UUID)) {
                int pos = this.flights.indexOf(flight);
                flights.remove(pos);
            }
        }
    }
    public void saveFlights() {
        FlightDatabaseWriter.saveFlights();
    }
}
