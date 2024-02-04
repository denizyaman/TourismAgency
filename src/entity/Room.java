package src.entity;

public class Room {
    private int id;
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

    public Room() {
    }

    public Room(int hotelId, int pensionId, int seasonId, String roomType, int stock, double adultPrice, double childPrice, int bedCapacity, int m2, boolean tv, boolean minibar, boolean console, boolean safe, boolean projection, String hotelName, String seasonStartDate, String seasonEndDate, String pensionType, String hotelAddress, String hotelStar, boolean isHotelCarPark, boolean isHotelWifi, boolean isHotelPool, boolean isHotelFitness, boolean isHotelConcierge, boolean isHotelSpa, boolean isHotelRoomService) {
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
    public Room(int hotelId,int pensionId,int season_id,String room_type,int stock, Double adult_price,Double child_price,int bedCapacity,int m2,boolean isTv,boolean isMiniBar,boolean isConsole, boolean isSafe,boolean isProjection){
        this.hotelId = hotelId;
        this.pensionId = pensionId;
        this.seasonId = season_id;
        this.roomType = room_type;
        this.stock = stock;
        this.adultPrice = adult_price;
        this.childPrice = child_price;
        this.bedCapacity = bedCapacity;
        this.m2 = m2;
        this.tv = isTv;
        this.minibar = isMiniBar;
        this.console = isConsole;
        this.safe = isSafe;
        this.projection = isProjection;
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

    public String getHotelStar() {
        return hotelStar;
    }

    public void setHotelStar(String hotelStar) {
        this.hotelStar = hotelStar;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getPensionType() {
        return pensionType;
    }

    public void setPensionType(String pensionType) {
        this.pensionType = pensionType;
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
}
