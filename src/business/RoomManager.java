package src.business;


import src.dao.RoomDao;
import src.entity.Room;

import java.sql.Date;
import java.util.ArrayList;

public class RoomManager {
    private RoomDao roomDao;

    public RoomManager() {
        this.roomDao = new RoomDao();
    }
    public Room findById(int roomId) {
        return this.roomDao.findById(roomId);
    }
    public boolean addroom(Room room){
        return this.roomDao.addRoom(room);
    }

    public ArrayList<Room> findAll() {
        return this.roomDao.findAll();
    }
    public ArrayList<Room> findBySearchValue(String searchHotelName, String searchHotelAddress,String searchCheckInDate,String searchCheckOutDate, int adultNumber,int childNumber) {


        String sql = "SELECT r.*,h.*,s.start_date,s.end_date,p.pension_type FROM public.rooms r " +
                "LEFT JOIN public.hotel h ON r.hotel_id=h.id " +
                "LEFT JOIN public.seasons s ON r.season_id=s.id " +
                "LEFT JOIN public.pension p ON r.pension_id=p.id " +
                "WHERE stock>0";

                if(!searchHotelName.isEmpty()){
                    sql+=" AND h.name ILIKE '%"+searchHotelName+"%'";
                }
                if(!searchHotelAddress.isEmpty()){
                    sql+=" AND h.address ILIKE '%"+searchHotelAddress+"%'";
                }
                if((adultNumber+childNumber) > 0){
                    sql+=" AND r.bed_capacity >= "+(childNumber+adultNumber);
                }
                if (!searchCheckInDate.isEmpty()){
                    sql+=" AND s.start_date <= '"+searchCheckInDate+"'";
                }
                if (!searchCheckOutDate.isEmpty()){
                    sql+=" AND s.end_date >= '"+searchCheckOutDate+"'";
                }
                sql+=" ORDER BY hotel_id ASC";

        return this.roomDao.findBySearchValue(sql);
    }
    public ArrayList<Object[]> getForTable(int size){
        ArrayList<Object[]> roomRowList=new ArrayList<>();
        for (Room room: this.findAll()){
            Object[] rowObject=new Object[size];
            int i=0;
            rowObject[i++]=room.getId();
            rowObject[i++]=room.getHotelName();
            rowObject[i++]=room.getPensionType();
            rowObject[i++]=room.getRoomType();
            rowObject[i++]=room.getStock();
            rowObject[i++]=room.getAdultPrice();
            rowObject[i++]=room.getChildPrice();
            rowObject[i++]=room.getBedCapacity();
            rowObject[i++]=room.getM2();
            rowObject[i++]=room.isTv();
            rowObject[i++]=room.isMinibar();
            rowObject[i++]=room.isConsole();
            rowObject[i++]=room.isSafe();
            rowObject[i++]=room.isProjection();
            rowObject[i++]=room.getSeasonStartDate();
            rowObject[i++]=room.getSeasonEndDate();
            roomRowList.add(rowObject);
        }
        return roomRowList;
    }

    public ArrayList<Object[]> getForTableBySearch(int size, ArrayList<Room> roomList){
        ArrayList<Object[]> roomRowList=new ArrayList<>();
        for (Room room: roomList){
            Object[] rowObject=new Object[size];
            int i=0;
            rowObject[i++]=room.getId();
            rowObject[i++]=room.getHotelName();
            rowObject[i++]=room.getPensionType();
            rowObject[i++]=room.getRoomType();
            rowObject[i++]=room.getStock();
            rowObject[i++]=room.getAdultPrice();
            rowObject[i++]=room.getChildPrice();
            rowObject[i++]=room.getBedCapacity();
            rowObject[i++]=room.getM2();
            rowObject[i++]=room.isTv();
            rowObject[i++]=room.isMinibar();
            rowObject[i++]=room.isConsole();
            rowObject[i++]=room.isSafe();
            rowObject[i++]=room.isProjection();
            rowObject[i++]=room.getSeasonStartDate();
            rowObject[i++]=room.getSeasonEndDate();


            roomRowList.add(rowObject);
        }
        return roomRowList;
    }



}
