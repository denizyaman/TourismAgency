package src.entity;

import java.util.Date;

public class Seasons {
    private int id;
    private int hotelId;
    private String startDate;
    private String endDate;

    public Seasons() {
    }

    public Seasons(int hotelId, String startDate, String endDate) {
        this.hotelId = hotelId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
