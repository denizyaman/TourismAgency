package src.view;

import src.business.HotelManager;
import src.business.PensionManager;
import src.business.RoomManager;
import src.business.SeasonManager;
import src.core.Helper;
import src.core.Item;
import src.entity.Hotel;
import src.entity.Pension;
import src.entity.Room;
import src.entity.Seasons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomDetailView extends Layout{
    private JPanel container;
    private JLabel lbl_title;
    private JComboBox otel_combo;
    private JComboBox season_combo;
    private JComboBox room_type_combo;
    private JTextField fld_stock;
    private JTextField fld_adult_price;
    private JTextField fld_child_price;
    private JTextField fld_bed_capacity;
    private JTextField fld_m2;
    private JCheckBox cb_tv;
    private JCheckBox cb_minibar;
    private JCheckBox cb_console;
    private JCheckBox cb_projection;
    private JCheckBox cb_safe;
    private JButton btn_save_room;
    private JComboBox pension_type_combo;

    private RoomManager roomManager;
    private HotelManager hotelManager;
    private PensionManager pensionManager;
    private SeasonManager seasonManager;
    private Room room;



    public RoomDetailView(Room room) {
        this.roomManager = new RoomManager();
        this.hotelManager = new HotelManager();
        this.pensionManager = new PensionManager();
        this.seasonManager = new SeasonManager();
        this.add(container);
        this.GuiInitilaze(900,400);
        this.room = room;
        this.loadHotelNameCombo();

        otel_combo.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Item hotelItem = (Item) otel_combo.getSelectedItem();
                loadHotelTypeCombo(hotelItem.getKey());
                loadSeasonCombo(hotelItem.getKey());
            }
        });

        btn_save_room.addActionListener(e-> { // kaydet butonunun basılmasını dınlıyoruz basılınca doldurulan alanlarla kaydedıyoruz
            boolean result=true;

            Item seasonComboSelectedItem = (Item) season_combo.getSelectedItem();
            Item otelComboSelectedItem = (Item) otel_combo.getSelectedItem();
            Item pensionTypeComboSelectedItem = (Item) pension_type_combo.getSelectedItem();

            int hotelId = otelComboSelectedItem.getKey();
            int pensionId = pensionTypeComboSelectedItem.getKey();
            int season_id = seasonComboSelectedItem.getKey();
            String room_type = room_type_combo.getSelectedItem().toString();
            int stock = Integer.parseInt(fld_stock.getText());
            double adult_price = Double.parseDouble(fld_adult_price.getText());
            double child_price = Double.parseDouble(fld_child_price.getText());
            int bedCapacity = Integer.parseInt(fld_bed_capacity.getText());
            int m2 = Integer.parseInt(fld_m2.getText());
            boolean isTv = cb_tv.isSelected();
            boolean isMiniBar = cb_minibar.isSelected();
            boolean isConsole = cb_console.isSelected();
            boolean isSafe = cb_safe.isSelected();
            boolean isProjection = cb_projection.isSelected();

            if (seasonComboSelectedItem.getKey()==-1 || pensionTypeComboSelectedItem.getKey()==-1) {
                Helper.showMsg("Bu otel için sezon ya da pansiyon girilmemiş!");
            }else{
                if(room_type.isEmpty()|| stock==0||adult_price==-1|| child_price==-1 || bedCapacity==-1 || m2==-1){
                    Helper.showMsg("fill");// gırılen alanlardan bırısı bos ıse doldur dıye hata verıyrouz
                }else {
                    if (this.room == null) {
                        // yenı oda ekleme kısmı
                        Room newRoom = new Room(hotelId,pensionId,season_id,room_type,stock,adult_price,child_price,bedCapacity,m2,isTv,isMiniBar,isConsole,isSafe,isProjection);
                        result=this.roomManager.addroom(newRoom);
                    }
                    if (result) {// basarıyla kaydedıldıyse basarılı dıyıp kapatıyoruz
                        Helper.showMsg("done");
                        dispose();
                    } else {
                        Helper.showMsg("error");
                    }
                }
                 }
        });
    }

    private void loadHotelNameCombo() {
        otel_combo.removeAllItems();
        otel_combo.addItem(new Item(0, null));
        for (Hotel obj : this.hotelManager.findAll()) {
            otel_combo.addItem(new Item(obj.getId(), obj.getName()));
        }
    }



    // oda ekleme sayfasında seçilen otele göre pansiyon türlerini combo bax a aktaran metod
    private void loadHotelTypeCombo(int selectedHotelId) {
        pension_type_combo.removeAllItems();
        pension_type_combo.addItem(new Item(0, null));
        if(!pensionManager.findByHotelId(selectedHotelId).isEmpty()){
            for (Pension obj : pensionManager.findByHotelId(selectedHotelId)) {
                pension_type_combo.addItem(new Item(obj.getId(), obj.getPensionType()));
            }
        }else{
            pension_type_combo.addItem(new Item(-1, "Pansiyon Eklenmemis"));
        }


    }

    private void loadSeasonCombo(int hotelId) {
        season_combo.removeAllItems();
        season_combo.addItem(new Item(0, null));
        if(!seasonManager.findByHotelId(hotelId).isEmpty()){
            for (Seasons obj : seasonManager.findByHotelId(hotelId)){
                season_combo.addItem(new Item(obj.getId(), (obj.getStartDate() + " - " + obj.getEndDate())));
            }
        }else{
            season_combo.addItem(new Item(-1, "Sezon Eklenmemiş"));
        }
    }

}
