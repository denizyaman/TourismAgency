package src.entity;

import java.util.Date;

public class Reservation {
    private int id;
    private int roomId;
    private String checkInDate;
    private String checkOutDate;
    private double totalPrice;
    private int guestNumber;
    private String guestName;
    private String guestCitizenId;
    private String mail;
    private String phone;
    private int hotelId;
    private int pensionId;
    private int seasonId;
    private String roomType;
    private int stock;
    private double adultPrice;
    private double childPrice;
    private int bedCapacity;
    private int m2;
    private boolean tv;
    private boolean minibar;
    private boolean console;
    private boolean safe;
    private boolean projection;
    private String hotelName;
    private String seasonStartDate;
    private String seasonEndDate;
    private String pensionType;
    private String hotelAddress;
    private String hotelStar;
    private boolean isHotelCarPark;
    private boolean isHotelWifi;
    private boolean isHotelPool;
    private boolean isHotelFitness;
    private boolean isHotelConcierge;
    private boolean isHotelSpa;
    private boolean isHotelRoomService;

    public Reservation() {
    }
    public Reservation(int id, String guestName, String guestCitizenId, String mail, String phone) {
        this.id=id;
        this.guestName = guestName;
        this.guestCitizenId = guestCitizenId;
        this.mail = mail;
        this.phone = phone;
    }
    public Reservation(int roomId, String checkInDate, String checkOutDate, double totalPrice, int guestNumber, String guestName, String guestCitizenId, String mail, String phone) {
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.guestNumber = guestNumber;
        this.guestName = guestName;
        this.guestCitizenId = guestCitizenId;
        this.mail = mail;
        this.phone = phone;
    }

    public Reservation(int roomId, String checkInDate, String checkOutDate, double totalPrice, int guestNumber, String guestName, String guestCitizenId, String mail, String phone, int hotelId, int pensionId, int seasonId, String roomType, int stock, double adultPrice, double childPrice, int bedCapacity, int m2, boolean tv, boolean minibar, boolean console, boolean safe, boolean projection, String hotelName, String seasonStartDate, String seasonEndDate, String pensionType, String hotelAddress, String hotelStar, boolean isHotelCarPark, boolean isHotelWifi, boolean isHotelPool, boolean isHotelFitness, boolean isHotelConcierge, boolean isHotelSpa, boolean isHotelRoomService) {
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.guestNumber = guestNumber;
        this.guestName = guestName;
        this.guestCitizenId = guestCitizenId;
        this.mail = mail;
        this.phone = phone;
        this.hotelId = hotelId;
        this.pensionId = pensionId;
        this.seasonId = seasonId;
        this.roomType = roomType;
        this.stock = stock;
        this.adultPrice = adultPrice;
        this.childPrice = childPrice;
        this.bedCapacity = bedCapacity;
        this.m2 = m2;
        this.tv = tv;
        this.minibar = minibar;
        this.console = console;
        this.safe = safe;
        this.projection = projection;
        this.hotelName = hotelName;
        this.seasonStartDate = seasonStartDate;
        this.seasonEndDate = seasonEndDate;
        this.pensionType = pensionType;
        this.hotelAddress = hotelAddress;
        this.hotelStar = hotelStar;
        this.isHotelCarPark = isHotelCarPark;
        this.isHotelWifi = isHotelWifi;
        this.isHotelPool = isHotelPool;
        this.isHotelFitness = isHotelFitness;
        this.isHotelConcierge = isHotelConcierge;
        this.isHotelSpa = isHotelSpa;
        this.isHotelRoomService = isHotelRoomService;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getPensionId() {
        return pensionId;
    }

    public void setPensionId(int pensionId) {
        this.pensionId = pensionId;
    }

    public int getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(int seasonId) {
        this.seasonId = seasonId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(double adultPrice) {
        this.adultPrice = adultPrice;
    }

    public double getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(double childPrice) {
        this.childPrice = childPrice;
    }

    public int getBedCapacity() {
        return bedCapacity;
    }

    public void setBedCapacity(int bedCapacity) {
        this.bedCapacity = bedCapacity;
    }

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isMinibar() {
        return minibar;
    }

    public void setMinibar(boolean minibar) {
        this.minibar = minibar;
    }

    public boolean isConsole() {
        return console;
    }

    public void setConsole(boolean console) {
        this.console = console;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public boolean isProjection() {
        return projection;
    }

    public void setProjection(boolean projection) {
        this.projection = projection;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getSeasonStartDate() {
        return seasonStartDate;
    }

    public void setSeasonStartDate(String seasonStartDate) {
        this.seasonStartDate = seasonStartDate;
    }

    public String getSeasonEndDate() {
        return seasonEndDate;
    }

    public void setSeasonEndDate(String seasonEndDate) {
        this.seasonEndDate = seasonEndDate;
    }

    public String getPensionType() {
        return pensionType;
    }

    public void setPensionType(String pensionType) {
        this.pensionType = pensionType;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelStar() {
        return hotelStar;
    }

    public void setHotelStar(String hotelStar) {
        this.hotelStar = hotelStar;
    }

    public boolean isHotelCarPark() {
        return isHotelCarPark;
    }

    public void setHotelCarPark(boolean hotelCarPark) {
        isHotelCarPark = hotelCarPark;
    }

    public boolean isHotelWifi() {
        return isHotelWifi;
    }

    public void setHotelWifi(boolean hotelWifi) {
        isHotelWifi = hotelWifi;
    }

    public boolean isHotelPool() {
        return isHotelPool;
    }

    public void setHotelPool(boolean hotelPool) {
        isHotelPool = hotelPool;
    }

    public boolean isHotelFitness() {
        return isHotelFitness;
    }

    public void setHotelFitness(boolean hotelFitness) {
        isHotelFitness = hotelFitness;
    }

    public boolean isHotelConcierge() {
        return isHotelConcierge;
    }

    public void setHotelConcierge(boolean hotelConcierge) {
        isHotelConcierge = hotelConcierge;
    }

    public boolean isHotelSpa() {
        return isHotelSpa;
    }

    public void setHotelSpa(boolean hotelSpa) {
        isHotelSpa = hotelSpa;
    }

    public boolean isHotelRoomService() {
        return isHotelRoomService;
    }

    public void setHotelRoomService(boolean hotelRoomService) {
        isHotelRoomService = hotelRoomService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(int guestNumber) {
        this.guestNumber = guestNumber;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestCitizenId() {
        return guestCitizenId;
    }

    public void setGuestCitizenId(String guestCitizenId) {
        this.guestCitizenId = guestCitizenId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
