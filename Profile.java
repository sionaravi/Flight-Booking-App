import java.util.Date;

/**
 * A Profile 
 * @author JavaFine
 */
public class Profile {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private Date dateOfBirth;
    private String emailAddress;
    private String phoneNumber;
    private Boolean disability;
    private String visa;
    private String occupation;
    private String discount;

    /**
     * Constructs profile
     * @param firstName
     * @param lastName
     * @param address
     * @param city
     * @param state
     * @param zip
     * @param dateOfBirthday
     * @param emailAddress
     * @param phoneNumber
     * @param visa
     * @param disability
     * @param occupation
     * @param discount
     */
    public Profile(String firstName, String lastName, String address, String city, String state, String zip,
            Date dateOfBirthday, String emailAddress, String phoneNumber, String visa, Boolean disability,
            String occupation, String discount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.dateOfBirth = dateOfBirthday;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.disability = disability;
        this.visa = visa;
        this.occupation = occupation;
        this.discount = discount;
    }

    /**
     * Returns first name
     * @return first name
     */
    public String getFirst() {
        return firstName;
    }

    /**
     * Returns last name
     * @return last name
     */
    public String getLast() {
        return lastName;
    }

    /**
     * Returns date of birth
     * @return date of birth
     */
    public Date getDOB() {
        return dateOfBirth;
    }

    /**
     * Returns discount
     * @return discount 
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * Returns visa
     * @return visa
     */
    public String getVisa() {
        return visa;
    }

    /**
     * Returns occupation
     * @return occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * Returns address
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Return city
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Returns zip
     * @return zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * Returns state
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Returns email address
     * @return email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Returns phone number
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns disability
     * @return disability
     */
    public Boolean getDisability() {
        return disability;
    }
}
