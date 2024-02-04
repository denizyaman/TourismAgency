package src.dao;

import src.core.Db;
import src.entity.Room;
import src.entity.Seasons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDao {
    private final Connection con;

    public RoomDao() {
        this.con = Db.getInstance();
    }

    public ArrayList<Room> findAll() {
        ArrayList<Room> roomArrayList = new ArrayList<>();
        String sql = "SELECT r.*,h.*,s.start_date,s.end_date,p.pension_type FROM public.rooms r LEFT JOIN public.hotel h ON r.hotel_id=h.id LEFT JOIN public.seasons s ON r.season_id=s.id LEFT JOIN public.pension p ON r.pension_id=p.id WHERE stock>0 ORDER BY hotel_id ASC";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                roomArrayList.add(this.match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomArrayList;
    }

    public ArrayList<Room> findBySearchValue(String sql) {
        ArrayList<Room> roomArrayList = new ArrayList<>();
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                roomArrayList.add(this.match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomArrayList;
    }

    public Room findById(int roomId){
        Room obj = null;
        String query = "SELECT r.*,h.*,s.start_date,s.end_date,p.pension_type FROM public.rooms r LEFT JOIN public.hotel h ON r.hotel_id=h.id LEFT JOIN public.seasons s ON r.season_id=s.id LEFT JOIN public.pension p ON r.pension_id=p.id WHERE r.id = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, roomId);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = this.match(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public void increaseStock(int roomId){
        String query = "UPDATE rooms SET stock = stock + 1 WHERE id = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, roomId);
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void decreaseStock(int roomId){
        String query = "UPDATE rooms SET stock = stock - 1 WHERE id = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, roomId);
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Room match(ResultSet rs) throws SQLException {
        Room obj = new Room();
        obj.setId(rs.getInt("id"));
        obj.setHotelId(rs.getInt("hotel_id"));
        obj.setHotelName(rs.getString("name"));
        obj.setSeasonStartDate(rs.getString("start_date"));
        obj.setSeasonEndDate(rs.getString("end_date"));
        obj.setSeasonId(rs.getInt("season_id"));
        obj.setPensionId(rs.getInt("pension_id"));
        obj.setStock(rs.getInt("stock"));
        obj.setBedCapacity(rs.getInt("bed_capacity"));
        obj.setM2(rs.getInt("m2"));
        obj.setAdultPrice(rs.getDouble("adult_price"));
        obj.setChildPrice(rs.getDouble("child_price"));
        obj.setRoomType(rs.getString("room_type"));
        obj.setPensionType(rs.getString("pension_type"));
        obj.setTv(rs.getBoolean("tv"));
        obj.setSafe(rs.getBoolean("safe"));
        obj.setMinibar(rs.getBoolean("minibar"));
        obj.setConsole(rs.getBoolean("console"));
        obj.setProjection(rs.getBoolean("projection"));
        obj.setHotelCarPark(rs.getBoolean("carpark"));
        obj.setHotelWifi(rs.getBoolean("wifi"));
        obj.setHotelPool(rs.getBoolean("pool"));
        obj.setHotelFitness(rs.getBoolean("fitness"));
        obj.setHotelConcierge(rs.getBoolean("concierge"));
        obj.setHotelSpa(rs.getBoolean("spa"));
        obj.setHotelRoomService(rs.getBoolean("room_service"));
        obj.setHotelStar(rs.getString("star"));
        obj.setHotelAddress(rs.getString("address"));

        return obj;
    }


    public boolean addRoom(Room room){
        String query = "INSERT INTO public.rooms (hotel_id,room_type,stock,adult_price,child_price,bed_capacity,m2,tv,minibar,console,safe,projection,pension_id,season_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, room.getHotelId());
            pr.setInt(14, room.getSeasonId());
            pr.setInt(13, room.getPensionId());
            pr.setInt(3, room.getStock());
            pr.setInt(6, room.getBedCapacity());
            pr.setDouble(4, room.getAdultPrice());
            pr.setDouble(5, room.getChildPrice());
            pr.setInt(7, room.getM2());
            pr.setString(2, room.getRoomType());
            pr.setBoolean(8, room.isTv());
            pr.setBoolean(11, room.isSafe());
            pr.setBoolean(9, room.isMinibar());
            pr.setBoolean(10, room.isConsole());
            pr.setBoolean(12, room.isProjection());

            return pr.executeUpdate()!=-1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}
