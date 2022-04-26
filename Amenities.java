/**
 * Amenities Enum
 * @author JavaFine
 */
public enum Amenities{
    POOL("Pool"),
    GYM("Gym"),
    TOILETRIES("Toiletries"),
    COFFEEKIT("Coffee Kit"),
    WIFI("Wifi"),
    PARKING("Parking"),
    SMOKE("Smoke"),
    MEAL("Meals");

    private final String textForm;

    /**
     * Converts values into strings
     * @param textForm
     */
    private Amenities(String textForm) {
        this.textForm = textForm;
    }

    /**
     * Returns string form of values
     * @return string
     */
    public String toString() {
        return textForm;
    }
}
