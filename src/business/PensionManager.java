package src.business;

import src.core.Helper;
import src.dao.HotelDao;
import src.dao.PensionDao;
import src.entity.Hotel;
import src.entity.Pension;
import src.entity.User;

import java.util.ArrayList;
import java.util.Objects;

public class PensionManager {
    private final PensionDao pensionDao;

    public PensionManager() {
        this.pensionDao = new PensionDao();
    }
    public Pension findById(int pensionId) {
        return this.pensionDao.findById(pensionId);
    }

    public ArrayList<Pension> findByHotelId(int hotelId) {
        return this.pensionDao.findByHotelId(hotelId);
    }
    public boolean savePension(Pension pension){
        return this.pensionDao.addPension(pension);
    }
    public ArrayList<Pension> findAll() {
        return this.pensionDao.findAll();
    }
    public ArrayList<Object[]> getForTable(int size){
        ArrayList<Object[]> pensionRowList=new ArrayList<>();
        for (Pension pension: this.findAll()){
            Object[] rowObject=new Object[size];
            int i=0;
            rowObject[i++]=pension.getId();
            rowObject[i++]=pension.getHotelId();
            rowObject[i++]=pension.getPensionType();

            pensionRowList.add(rowObject);
        }
        return pensionRowList;
    }
}
