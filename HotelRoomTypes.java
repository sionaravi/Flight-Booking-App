/**
 * Hotel Room Type Enum
 * @author JavaFine
 */
public enum HotelRoomTypes {
    SUITE("Suite"),
    STANDARD("Standard"),
    ROOM_ONLY("Room Only"),
    CONNECTING("Connecting"),
    MINIMALIST("Minimalist"),
    DELUXE("Deluxe"),
    STUDIO("Studio");

    private final String textForm;

    /**
     * Converts the values into strings 
     * @param textForm
     */
    private HotelRoomTypes(String textForm) {
        this.textForm = textForm;
    }

    /**
     * Returns string form 
     */
    public String toString() {
        return textForm;
    }
}
