package src.business;

import src.dao.HotelDao;
import src.dao.UserDao;
import src.entity.Hotel;
import src.entity.User;

import java.util.ArrayList;
import java.util.Objects;


public class HotelManager {
    private final HotelDao hotelDao;

    public HotelManager() {
        this.hotelDao = new HotelDao();
    }
    public Hotel findById(int hotelId) {
        return this.hotelDao.findById(hotelId);
    }
    public boolean saveHotel(Hotel hotel){
        return this.hotelDao.addHotel(hotel);
    }
    public ArrayList<Hotel> findAll() {
        return this.hotelDao.findAll();
    }
    public ArrayList<Object[]> getForTable(int size){
        ArrayList<Object[]> hotelRowList=new ArrayList<>();
        for (Hotel hotel: this.findAll()){
            Object[] rowObject=new Object[size];
            int i=0;
            rowObject[i++]=hotel.getId();
            rowObject[i++]=hotel.getName();
            rowObject[i++]=hotel.getAddress();
            rowObject[i++]=hotel.getMail();
            rowObject[i++]=hotel.getPhone();
            rowObject[i++]=hotel.getStar();
            rowObject[i++]=hotel.isCarpark();
            rowObject[i++]=hotel.isWifi();
            rowObject[i++]=hotel.isPool();
            rowObject[i++]=hotel.isFitness();
            rowObject[i++]=hotel.isConcierge();
            rowObject[i++]=hotel.isSpa();
            rowObject[i++]=hotel.isRoomService();
            hotelRowList.add(rowObject);
        }
        return hotelRowList;
    }
    public ArrayList<Hotel> findItems(String role){
        if(Objects.equals(role, "All")){
            return this.findAll();
        }else{
            return this.findAll();
        }
    }
}
