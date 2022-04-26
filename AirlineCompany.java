/**
  * Airline Company Enum
  * @author JavaFine
  */
public enum AirlineCompany {
    AMERICAN_AIRLINE("American Airline"),
    DELTA("Delta"),
    SOUTHWEST_AIRLINES("Southwest Airlines"),
    UNITED_AIRLINES("United Airlines");

    private final String textForm;

    /**
     * Converts the values into strings
     * @param textForm
     */
    private AirlineCompany(String textForm) {
        this.textForm = textForm;
    }

    /**
     * Returns the string form of the enums
     * @return string
     */
    public String toString() {
        return textForm;
    }
}
