/**
 * Flight Class Enum
 * @author JavaFine
 */
public enum FlightClass {
   ECONOMY("Economy"),
   PREMIUM_ECONOMY("Premium Economy"),
   FIRST_CLASS("First Class"),
   BUSINESS("Business");
   
   private final String textForm;

   /**
    * Converts the values into strings 
    * @param textForm
    */
   private FlightClass(String textForm) {
        this.textForm = textForm;
    }

    /**
     * Returns the string form of the values
     * @return strings
     */
   public String toString() {
      return textForm;
   }
}
