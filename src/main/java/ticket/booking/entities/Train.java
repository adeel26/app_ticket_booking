package ticket.booking.entities;

import java.sql.Time;
import java.util.List;
import java.util.Map;

public class Train {

     private String trainId;

     private String trainNo;

     private List<List<Integer>> seats;

     private Map<String, Time> stationsTimes;

     private List<String> stations;

    public Train(String trainId, String trainNo, Map<String, Time> stationsTimes, List<String> stations, List<List<Integer>> seats) {
        this.trainId = trainId;
        this.trainNo = trainNo;
        this.stationsTimes = stationsTimes;
        this.stations = stations;
        this.seats = seats;
    }

    public Train() {

    }

    public String getTrainId() {
        return this.trainId;
    }

    public String getTrainNo() {
        return this.trainNo;
    }

    public List<List<Integer>> getSeats() {
        return this.seats;
    }

    public Map<String, Time> getStationsTimes() {
        return this.stationsTimes;
    }

    public List<String> getStations() {
        return this.stations;
    }


    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public void setSeats(List<List<Integer>> seats) {
        this.seats = seats;
    }

    public void setStationsTimes(Map<String, Time> stationsTimes) {
        this.stationsTimes = stationsTimes;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    public String getTrainInfo() {
        return String.format("Train ID: %s Train No: %s", trainId, trainNo);
    }
}
