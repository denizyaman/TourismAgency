package src.dao;

import src.core.Db;
import src.entity.Hotel;
import src.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HotelDao {
    private final Connection con;

    public HotelDao() {
        this.con = Db.getInstance();
    }

    public ArrayList<Hotel> findAll() {
        ArrayList<Hotel> hotelList = new ArrayList<>();
        String sql = "SELECT * FROM public.hotel ORDER BY id ASC";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                hotelList.add(this.match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelList;
    }

    public Hotel findById(int hotelId){
       Hotel obj = null;
        String query = "SELECT * FROM public.hotel WHERE id = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, hotelId);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = this.match(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public Hotel match(ResultSet rs) throws SQLException {
        Hotel obj = new Hotel();
        obj.setId(rs.getInt("id"));
        obj.setName(rs.getString("name"));
        obj.setAddress(rs.getString("address"));
        obj.setMail(rs.getString("mail"));
        obj.setPhone(rs.getString("phone"));
        obj.setStar(rs.getString("star"));
        obj.setCarpark(rs.getBoolean("carpark"));
        obj.setWifi(rs.getBoolean("wifi"));
        obj.setPool(rs.getBoolean("pool"));
        obj.setFitness(rs.getBoolean("fitness"));
        obj.setConcierge(rs.getBoolean("concierge"));
        obj.setSpa(rs.getBoolean("spa"));
        obj.setRoomService(rs.getBoolean("room_service"));
        return obj;
    }
    public boolean addHotel(Hotel hotel){
        String query = "INSERT INTO public.hotel (name,address,mail,phone,star,carpark,wifi,pool,fitness,concierge,spa,room_service) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setString(1, hotel.getName());
            pr.setString(2, hotel.getAddress());
            pr.setString(3, hotel.getMail());
            pr.setString(4, hotel.getPhone());
            pr.setString(5, hotel.getStar());
            pr.setBoolean(6, hotel.isCarpark());
            pr.setBoolean(7, hotel.isWifi());
            pr.setBoolean(8, hotel.isPool());
            pr.setBoolean(9, hotel.isFitness());
            pr.setBoolean(10, hotel.isConcierge());
            pr.setBoolean(11, hotel.isSpa());
            pr.setBoolean(12, hotel.isRoomService());

            return pr.executeUpdate()!=-1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

}
