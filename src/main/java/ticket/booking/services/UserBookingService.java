package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;
import ticket.booking.util.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserBookingService {

    private User user;

    private List<User> userList;

    private ObjectMapper objectMapper = new ObjectMapper();

    private static final String USERS_PATH = "src/main/java/ticket/booking/localDb/users.json";


    public UserBookingService(User user) throws IOException {
        this.user = user;
        loadUsers();
    }

    public UserBookingService() throws IOException{
        loadUsers();
    }

    public List<User> loadUsers() throws IOException{
        File users = new File(USERS_PATH);
        return objectMapper.readValue(users, new TypeReference<List<User>>() {});
    }


    public boolean loginUser() {
        Optional<User> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equalsIgnoreCase(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashPassword());
        }).findFirst();
        return foundUser.isPresent();
    }

    public Boolean signUp(User user1) {
        try{
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        } catch (IOException ex) {
            return Boolean.FALSE;
        }
    }

    private void saveUserListToFile() throws IOException{
        File usersFile = new File(USERS_PATH);
        objectMapper.writeValue(usersFile, userList);
    }

    public void fetchBooking() {
        user.printTickets();
    }


    public boolean cancelBooking(String ticketId) {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the ticket ID to cancel: ");
//        String ticketIdInput = scanner.next();

        if (ticketId == null || ticketId.isEmpty()) {
            System.out.println("Ticket ID cannot be null or empty");
            return Boolean.FALSE;
        }

        boolean removed = user.getTicketsBooked().removeIf(ticket -> ticket.getTicketID().equals(ticketId));

        if(removed) {
            System.out.println("Ticket with ID " + ticketId + " has been cancelled.");
        } else {
            System.out.println("No ticket found with ID " + ticketId);
        }

        return removed;
    }


    public List<Train> getTrains(String source, String destination) {
        try{
            TrainService trainService = new TrainService();
            return trainService.searchTrains(source, destination);
        } catch (IOException ex) {
            return new ArrayList<>();
        }
    }


    public List<List<Integer>> fetchSeats (Train train) {
        return train.getSeats();
    }


    public boolean bookTrainSeat (Train train, int row, int seat) {
        try {
            TrainService trainService = new TrainService();
            List<List<Integer>> seats = train.getSeats();
            if(row >= 0 && row < seats.size() && seat >= 0 && seat < seats.get(row).size()) {
                if(seats.get(row).get(seat) == 0) {
                    seats.get(row).set(seat, 1);
                    train.setSeats(seats);
                    trainService.addTrain(train);
                    return true; // Booking successful
                } else {
                    return false; // Seat is already booked
                }
            } else {
                return false; // Invalid row or seat Index
            }
        } catch (IOException e) {
            return Boolean.FALSE;
        }
    }


}


/*

public boolean loginUser() {

    for(User user1 : userList){

        if(user1.getName().equalsIgnoreCase(user.getName()) &&
           UserServiceUtil.checkPassword(user.getPassword(), user1.getHashPassword())) {

            return true;
        }
    }

    return false;
}




 */
