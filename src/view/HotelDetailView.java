package src.view;

import src.business.HotelManager;
import src.core.Helper;
import src.entity.Hotel;
import src.entity.User;

import javax.swing.*;

public class HotelDetailView extends Layout{
    private JPanel container;
    private JPanel pnl_hotelDetail;
    private JTextField fld_hotelName;
    private JTextField fld_mail;
    private JTextField fld_phone;
    private JTextField fld_address;
    private JComboBox combo_star;
    private JCheckBox cb_carpark;
    private JCheckBox cb_wifi;
    private JCheckBox cb_pool;
    private JCheckBox cb_fitness;
    private JCheckBox cb_concierge;
    private JCheckBox cb_spa;
    private JCheckBox cb_roomService;
    private JPanel pnl_left;
    private JPanel pnl_right;
    private JLabel lbl_hotelName;
    private JLabel lbl_mail;
    private JLabel lbl_phone;
    private JLabel lbl_address;
    private JLabel lbl_star;
    private JButton btn_hotel_save;
    private Hotel hotel;
    private HotelManager hotelManager;
    public HotelDetailView(Hotel hotel) {
        this.hotelManager = new HotelManager();
        this.add(container);
        this.GuiInitilaze(700,400);
        this.hotel = hotel;

        if(this.hotel!=null){
            this.fld_hotelName.setText(this.hotel.getName());
            this.fld_address.setText(this.hotel.getAddress());
            this.fld_mail.setText(this.hotel.getMail());
            this.fld_phone.setText(this.hotel.getPhone());

            this.combo_star.getModel().setSelectedItem(this.hotel.getStar());
            this.cb_carpark.setSelected(this.hotel.isCarpark());
            this.cb_wifi.setSelected(this.hotel.isWifi());
            this.cb_pool.setSelected(this.hotel.isPool());
            this.cb_fitness.setSelected(this.hotel.isFitness());
            this.cb_spa.setSelected(this.hotel.isSpa());
            this.cb_concierge.setSelected(this.hotel.isConcierge());
            this.cb_roomService.setSelected(this.hotel.isRoomService());
        }

        btn_hotel_save.addActionListener(e-> { // kaydet butonunun basılmasını dınlıyoruz basılınca doldurulan alanlarla kaydedıyoruz
            if(Helper.isFieldListEmpty(new JTextField[]{this.fld_hotelName,this.fld_address,this.fld_mail,this.fld_phone})){
                Helper.showMsg("fill");// gırılen alanlardan bırısı bos ıse doldur dıye hata verıyrouz
            }else {

                Hotel newHotel= new Hotel(fld_hotelName.getText(),fld_address.getText(),fld_mail.getText(),fld_phone.getText(),String.valueOf(combo_star.getSelectedItem()),cb_carpark.isSelected(),cb_wifi.isSelected(),cb_pool.isSelected(),cb_fitness.isSelected(),cb_concierge.isSelected(),cb_spa.isSelected(),cb_roomService.isSelected()); //gırılen alanlarla yenı bır user nesnesı olusturuyoruz
               boolean result=this.hotelManager.saveHotel(newHotel); // managerda kı methoda parametre olarak verıyoruz

                if(result){// basarıyla kaydedıldıyse basarılı dıyıp kapatıyoruz
                    Helper.showMsg("done");
                    dispose();
                }else{
                    Helper.showMsg("error");
                }
            }
        });

    }
}
