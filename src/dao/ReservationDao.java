package src.dao;

import src.business.ReservationManager;
import src.core.Db;
import src.entity.Reservation;
import src.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationDao {

    private final Connection con;

    public ReservationDao() {
        this.con = Db.getInstance();
    }
    public Reservation match(ResultSet rs) throws SQLException {
        Reservation obj = new Reservation();
        obj.setId(rs.getInt("id"));
        obj.setRoomId(rs.getInt("room_id"));
        obj.setCheckInDate(rs.getString("check_in_date"));
        obj.setCheckOutDate(rs.getString("check_out_date"));
        obj.setTotalPrice(rs.getDouble("total_price"));
        obj.setGuestNumber(rs.getInt("guest_count"));
        obj.setGuestName(rs.getString("guest_name"));
        obj.setGuestCitizenId(rs.getString("guest_citizen_id"));
        obj.setMail(rs.getString("guest_mail"));
        obj.setPhone(rs.getString("guest_phone"));

        return obj;
    }

    public ArrayList<Reservation> findAll() {
        ArrayList<Reservation> resList = new ArrayList<>();
        String sql = "SELECT * FROM public.reservation";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                resList.add(this.match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resList;
    }
    public Reservation findById(int resId) {
        Reservation reservation=null;
        String query = "SELECT * FROM public.reservation res LEFT JOIN public.rooms room ON res.room_id=room.id LEFT JOIN public.hotel hotel ON room.hotel_id=hotel.id WHERE res.id=?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, resId);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                reservation = this.match(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservation;
    }
    public boolean addRes(Reservation reservation){
        String query = "INSERT INTO public.reservation (room_id,total_price,guest_count,guest_name,guest_citizen_id,guest_mail,guest_phone,check_in_date,check_out_date) VALUES (?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, reservation.getRoomId());
            pr.setDouble(2, reservation.getTotalPrice());
            pr.setInt(3, reservation.getGuestNumber());
            pr.setString(4, reservation.getGuestName());
            pr.setString(5, reservation.getGuestCitizenId());
            pr.setString(6, reservation.getMail());
            pr.setString(7, reservation.getPhone());
            pr.setString(8, reservation.getCheckInDate());
            pr.setString(9, reservation.getCheckOutDate());
            return pr.executeUpdate()!=-1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    public boolean update(Reservation reservation){
        String query = "UPDATE public.reservation SET guest_name=?,guest_mail=?,guest_citizen_id=?,guest_phone=? WHERE id=? ";
        try{
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setString(1, reservation.getGuestName());
            pr.setString(2, reservation.getMail());
            pr.setString(3, reservation.getGuestCitizenId());
            pr.setString(4, reservation.getPhone());
            pr.setInt(5, reservation.getId());
            return pr.executeUpdate()!=-1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean delete(int id){
        String query = "DELETE FROM public.reservation WHERE id=? ";
        try{
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, id);
            return pr.executeUpdate()!=-1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}
