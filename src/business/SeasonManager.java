package src.business;

import src.core.Helper;
import src.dao.HotelDao;
import src.dao.PensionDao;
import src.dao.SeasonDao;
import src.entity.Hotel;
import src.entity.Pension;
import src.entity.Seasons;
import src.entity.User;

import java.util.ArrayList;
import java.util.Objects;

public class SeasonManager {
    private SeasonDao seasonDao;

    public SeasonManager() {
        this.seasonDao = new SeasonDao();
    }
    public Seasons findById(int seasonsId) {
        return this.seasonDao.findById(seasonsId);
    }
    public boolean saveSeasons(Seasons seasons){
        return this.seasonDao.addSeason(seasons);
    }
    public ArrayList<Seasons> findAll() {
        return this.seasonDao.findAll();
    }

    public ArrayList<Seasons> findByHotelId(int hotelId) {
        return this.seasonDao.findByHotelId(hotelId);
    }
    public ArrayList<Object[]> getForTable(int size){
        ArrayList<Object[]> pensionRowList=new ArrayList<>();
        for (Seasons season: this.findAll()){
            Object[] rowObject=new Object[size];
            int i=0;
            rowObject[i++]=season.getId();
            rowObject[i++]=season.getHotelId();
            rowObject[i++]=season.getStartDate();
            rowObject[i++]=season.getEndDate();



            pensionRowList.add(rowObject);
        }
        return pensionRowList;
    }
}
