package src.dao;

import src.core.Db;
import src.entity.Hotel;
import src.entity.Pension;
import src.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PensionDao {
    private final Connection con;

    public PensionDao() {
        this.con = Db.getInstance();
    }

    public ArrayList<Pension> findAll() {
        ArrayList<Pension> pensionList = new ArrayList<>();
        String sql = "SELECT * FROM public.pension ORDER BY hotel_id ASC";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                pensionList.add(this.match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pensionList;
    }

    public Pension findById(int pensionId){
        Pension obj = null;
        String query = "SELECT * FROM public.pension WHERE id = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, pensionId);
            ResultSet rs = pr.executeQuery(query);
            if (rs.next()) {
                obj = this.match(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public ArrayList<Pension> findByHotelId(int hotelId){
        ArrayList<Pension> pensionList = new ArrayList<>();
        String sql = "SELECT * FROM public.pension WHERE hotel_id=?";
        try {
            PreparedStatement pr = this.con.prepareStatement(sql);
            pr.setInt(1, hotelId);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                pensionList.add(this.match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pensionList;
    }
    public Pension match(ResultSet rs) throws SQLException {
        Pension obj = new Pension();
        obj.setId(rs.getInt("id"));
        obj.setHotelId(rs.getInt("hotel_id"));
        obj.setPensionType(rs.getString("pension_type"));
        return obj;
    }
    public boolean addPension(Pension pension){
        String query = "INSERT INTO public.pension (hotel_id,pension_type) VALUES (?,?)";
        try{
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, pension.getHotelId());
            pr.setString(2,pension.getPensionType());


            return pr.executeUpdate()!=-1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}
