package ticket.booking.entities;

import java.util.Date;

public class Ticket {

    private String ticketID;

    private String userId;

    private String source;

    private String destination;

    private Date dateOfTravel;

    private Train train;

    public Ticket(String ticketID, String userId, String source, String destination, Date dateOfTravel, Train train) {
        this.ticketID = ticketID;
        this.userId = userId;
        this.source = source;
        this.destination = destination;
        this.dateOfTravel = dateOfTravel;
        this.train = train;
    }

    public String getTicketInfo() {
        return String.format("Ticket ID: %s belongs to User %s from %s to %s on %s", ticketID, userId, source, destination, dateOfTravel);
    }

    public String getTicketID() {
        return this.ticketID;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getSource() {
        return this.source;
    }

    public String getDestination() {
        return this.destination;
    }

    public Date getDateOfTravel() {
        return this.dateOfTravel;
    }

    public Train getTrain() {
        return this.train;
    }


    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDateOfTravel(Date dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
