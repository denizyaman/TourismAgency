package src.view;

import src.business.ReservationManager;
import src.business.RoomManager;
import src.core.Helper;
import src.entity.Hotel;
import src.entity.Pension;
import src.entity.Reservation;
import src.entity.Room;

import javax.swing.*;
import java.sql.Date;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReservationDetailView extends Layout {
    private JPanel container;
    private JPanel otel_data_container;
    private JPanel room_detail_container;
    private JPanel reservation_detail_container;
    private JTextField fld_rez_otel_name;
    private JTextField fld_rez_hotel_address;
    private JTextField fld_rez_hotel_stars;
    private JCheckBox cb_rez_carPark;
    private JCheckBox cb_rez_wifi;
    private JCheckBox cb_rez_pool;
    private JCheckBox cb_rez_fitness;
    private JCheckBox cb_rez_concierge;
    private JCheckBox cb_rez_spa;
    private JCheckBox cb_rez_roomService;
    private JPanel cb_container;
    private JTextField fld_rez_roomType;
    private JTextField fld_rez_pensionType;
    private JTextField fld_rez_checkinDate;
    private JTextField fld_rez_checkoutDate;
    private JTextField fld_rez_totalPrice;
    private JTextField fld_rez_bedCapacity;
    private JTextField fld_rez_m2;
    private JCheckBox cb_rez_tv;
    private JCheckBox cb_rez_minibar;
    private JCheckBox cb_rez_console;
    private JCheckBox cb_rez_safe;
    private JCheckBox cb_rez_projection;
    private JTextField fld_rez_totalPerson;
    private JTextField fld_rez_personName;
    private JTextField fld_rez_personMail;
    private JTextField fld_rez_personNumber;
    private JTextField fld_rez_persenPhone;
    private JButton btn_rez_submit;
    private int roomId;
    private RoomManager roomManager;
    private ReservationManager resManager;
    private Room room;
    private String checkinDate;
    private String checkoutDate;
    private int adultNumber;
    private int childNumber;
    private Reservation res;

    public ReservationDetailView(int roomId,String checkinDate, String checkoutDate, int adultNumber, int childNumber){
        this.add(container);
        this.GuiInitilaze(1280,600);
        this.roomId=roomId;
        this.roomManager=new RoomManager();
        this.resManager=new ReservationManager();
        this.room = roomManager.findById(this.roomId);
        this.checkinDate=checkinDate;
        this.checkoutDate=checkoutDate;
        this.adultNumber=adultNumber;
        this.childNumber=childNumber;
        setRoomItems();
        save();
    }
    public ReservationDetailView(int resId,int roomId){

        this.add(container);
        this.GuiInitilaze(1280,600);
        this.roomId=roomId;
        this.roomManager=new RoomManager();
        this.resManager=new ReservationManager();
        this.room = roomManager.findById(this.roomId);
        this.res=this.resManager.findById(resId);
        this.checkinDate=this.res.getCheckInDate();
        this.checkoutDate= this.res.getCheckOutDate();
        setRoomItems();
        update(resId);
    }
    private void save(){
        btn_rez_submit.addActionListener(e-> { // kaydet butonunun basılmasını dınlıyoruz basılınca doldurulan alanlarla kaydedıyoruz
            String gName = fld_rez_personName.getText();
            int totalGuest  = adultNumber+childNumber;
            String gMail = fld_rez_personMail.getText();
            String gNumber = fld_rez_personNumber.getText();
            String gPhone = fld_rez_persenPhone.getText();


            if(gName.isEmpty()||gMail.isEmpty()||gNumber.isEmpty()||gPhone.isEmpty()){
                Helper.showMsg("fill");// gırılen alanlardan bırısı bos ıse doldur dıye hata verıyrouz
            }else {

                Reservation newRes= new Reservation(this.roomId,this.checkinDate,this.checkoutDate,Double.parseDouble(this.fld_rez_totalPrice.getText()),totalGuest,gName,gNumber,gMail,gPhone); //gırılen alanlarla yenı bır user nesnesı olusturuyoruz
                boolean result=this.resManager.addRes(newRes); // managerda kı methoda parametre olarak verıyoruz

                if(result){// basarıyla kaydedıldıyse basarılı dıyıp kapatıyoruz
                    Helper.showMsg("done");
                    dispose();
                }else{
                    Helper.showMsg("error");
                }
            }
        });
    }
    private void update(int id){
        btn_rez_submit.addActionListener(e-> { // kaydet butonunun basılmasını dınlıyoruz basılınca doldurulan alanlarla kaydedıyoruz
            String gName = fld_rez_personName.getText();
            int totalGuest  = adultNumber+childNumber;
            String gMail = fld_rez_personMail.getText();
            String gNumber = fld_rez_personNumber.getText();
            String gPhone = fld_rez_persenPhone.getText();


            if(gName.isEmpty()||gMail.isEmpty()||gNumber.isEmpty()||gPhone.isEmpty()){
                Helper.showMsg("fill");// gırılen alanlardan bırısı bos ıse doldur dıye hata verıyrouz
            }else {

                Reservation newRes= new Reservation(id,gName,gNumber,gMail,gPhone);
                boolean result=this.resManager.update(newRes);

                if(result){// basarıyla kaydedıldıyse basarılı dıyıp kapatıyoruz
                    Helper.showMsg("done");
                    dispose();
                }else{
                    Helper.showMsg("error");
                }
            }
        });
    }
    private void setRoomItems(){
        fld_rez_otel_name.setText(this.room.getHotelName());
        fld_rez_hotel_address.setText(this.room.getHotelAddress());
        fld_rez_hotel_stars.setText(this.room.getHotelStar());
        cb_rez_carPark.setSelected(this.room.isHotelCarPark());
        cb_rez_wifi.setSelected(this.room.isHotelWifi());
        cb_rez_pool.setSelected(this.room.isHotelPool());
        cb_rez_fitness.setSelected(this.room.isHotelFitness());
        cb_rez_concierge.setSelected(this.room.isHotelConcierge());
        cb_rez_spa.setSelected(this.room.isHotelSpa());
        cb_rez_roomService.setSelected(this.room.isHotelRoomService());
        fld_rez_roomType.setText(this.room.getRoomType());
        fld_rez_pensionType.setText(this.room.getPensionType());
        fld_rez_checkinDate.setText(this.checkinDate);
        fld_rez_checkoutDate.setText(this.checkoutDate);
        fld_rez_checkoutDate.setText(this.checkoutDate);
        calculatePrice();
        fld_rez_totalPerson.setText(String.valueOf(this.adultNumber+this.childNumber));
        fld_rez_bedCapacity.setText(String.valueOf(this.room.getBedCapacity()));
        fld_rez_m2.setText(String.valueOf(this.room.getM2()));
        cb_rez_tv.setSelected(this.room.isTv());
        cb_rez_console.setSelected(this.room.isConsole());
        cb_rez_projection.setSelected(this.room.isProjection());
        cb_rez_minibar.setSelected(this.room.isMinibar());
        cb_rez_safe.setSelected(this.room.isSafe());
        if(this.res!=null){
            fld_rez_totalPrice.setText(String.valueOf(this.res.getTotalPrice()));
            fld_rez_totalPerson.setText(String.valueOf(this.res.getGuestNumber()));
            fld_rez_personName.setText(this.res.getGuestName());
            fld_rez_personMail.setText(this.res.getMail());
            fld_rez_personNumber.setText(this.res.getGuestCitizenId());
            fld_rez_persenPhone.setText(this.res.getPhone());
        }
    }

    public void calculatePrice(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDateTime date1 = LocalDate.parse(checkinDate, dtf).atStartOfDay();
        LocalDateTime date2 = LocalDate.parse(checkoutDate,dtf).atStartOfDay();

        long totalDays = Duration.between(date1, date2).toDays();// toplam gün sayısı hesaplanıyor
        fld_rez_totalPrice.setText(String.valueOf((((childNumber*room.getChildPrice())+(adultNumber*room.getAdultPrice()))*totalDays)));
    }
}
