package src.dao;

import src.core.Db;
import src.entity.Pension;
import src.entity.Seasons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SeasonDao {
    private final Connection con;

    public SeasonDao() {
        this.con = Db.getInstance();
    }

    public ArrayList<Seasons> findAll() {
        ArrayList<Seasons> seasonsList = new ArrayList<>();
        String sql = "SELECT * FROM public.seasons ORDER BY hotel_id ASC";
        try {
            ResultSet rs = this.con.createStatement().executeQuery(sql);
            while (rs.next()) {
                seasonsList.add(this.match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seasonsList;
    }

    public Seasons findById(int seasonId){
        Seasons obj = null;
        String query = "SELECT * FROM public.seasons WHERE id = ?";
        try {
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, seasonId);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                obj = this.match(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }
    public ArrayList<Seasons> findByHotelId(int hotelId){
        ArrayList<Seasons> seasonsList = new ArrayList<>();
        String sql = "SELECT * FROM public.seasons WHERE hotel_id=?";
        try {
            PreparedStatement pr = this.con.prepareStatement(sql);
            pr.setInt(1, hotelId);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                seasonsList.add(this.match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seasonsList;
    }
    public Seasons match(ResultSet rs) throws SQLException {
        Seasons obj = new Seasons();
        obj.setId(rs.getInt("id"));
        obj.setHotelId(rs.getInt("hotel_id"));
        obj.setStartDate(rs.getString("start_date"));
        obj.setEndDate(rs.getString("end_date"));
        return obj;
    }
    public boolean addSeason(Seasons seasons){
        String query = "INSERT INTO public.seasons (hotel_id,start_date,end_date) VALUES (?,?,?)";
        try{
            PreparedStatement pr = this.con.prepareStatement(query);
            pr.setInt(1, seasons.getHotelId());
            pr.setString(2,seasons.getStartDate());
            pr.setString(3,seasons.getEndDate());


            return pr.executeUpdate()!=-1;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}
