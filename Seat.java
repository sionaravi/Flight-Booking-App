/**
 * A Seat on a Flight
 */
 public class Seat {
    private boolean occupied;
    private String seatNumber;

    /**
     * Constructs a seat 
     * @param occupied
     * @param seatNumber
     */
    public Seat(boolean occupied, String seatNumber) {
        this.setOccupied(occupied);
        this.seatNumber = seatNumber;
    }

    /**
     * Checks whether seat is occupied or not
     * @return boolean
     */
    public boolean isOccupied() {
        return occupied;
    }

    /**
     * Changes seat occupation status
     * @param occupied
     */
    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    /**
     * Returns seat number
     * @return seat number
     */
    public String getSeatNumber() {
        return seatNumber;
    }
 } 