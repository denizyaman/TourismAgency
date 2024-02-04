package src.business;

import src.dao.ReservationDao;

import src.dao.RoomDao;
import src.entity.Reservation;


import java.util.ArrayList;

public class ReservationManager {
    private final ReservationDao reservationDao;
    private final RoomDao roomDao;

    public ReservationManager() {
        this.reservationDao = new ReservationDao();
        this.roomDao =new RoomDao();
    }

    public ArrayList<Reservation> findAll() {
        return this.reservationDao.findAll();
    }
    public Reservation findById(int id) {
        return this.reservationDao.findById(id);
    }

    public void delete(int resId,int roomId) {
        this.reservationDao.delete(resId);
        roomDao.increaseStock(roomId);
    }

    public boolean addRes(Reservation reservation){
        boolean result= this.reservationDao.addRes(reservation);
        if(result){
            this.roomDao.decreaseStock(reservation.getRoomId());
        }
        return result;
    }
    public boolean update(Reservation reservation){
        return this.reservationDao.update(reservation);
    }
    public ArrayList<Object[]> getForTable(int size){
        ArrayList<Object[]> roomRowList=new ArrayList<>();
        for (Reservation res: this.findAll()){
            Object[] rowObject=new Object[size];
            int i=0;
            rowObject[i++]=res.getId();
            rowObject[i++]=res.getRoomId();
            rowObject[i++]=res.getCheckInDate();
            rowObject[i++]=res.getCheckOutDate();
            rowObject[i++]=res.getGuestNumber();
            rowObject[i++]=res.getGuestName();
            rowObject[i++]=res.getGuestCitizenId();
            rowObject[i++]=res.getMail();
            rowObject[i++]=res.getPhone();

            roomRowList.add(rowObject);
        }
        return roomRowList;
    }

}
