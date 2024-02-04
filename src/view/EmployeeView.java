package src.view;

import src.business.*;
import src.core.Helper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class EmployeeView extends Layout{
    private DefaultTableModel hmdl_hotel = new DefaultTableModel( );
    private DefaultTableModel pmdl_pension = new DefaultTableModel();
    private DefaultTableModel smdl_season = new DefaultTableModel();
    private DefaultTableModel rmdl_season = new DefaultTableModel();
    private DefaultTableModel resmdl_season = new DefaultTableModel();
    private JPanel container;
    private JTabbedPane tabbedPane1;
    private JPanel tbd_hotel;
    private JPanel tbd_room;
    private JPanel tbd_reservation;
    private JTable tbl_hotel;
    private JTable tbl_room;
    private JTable tbl_pension;
    private JTable tbl_seasons;
    private JScrollPane scl_room;
    private JScrollPane scl_hotel;
    private JTextField fld_search_hotel_name;
    private JTextField fld_searc_hotel_address;
    private JTextField fld_searc_hotel_season_check_in;
    private JTextField fld_searc_hotel_season_check_out;
    private JTextField fld_adult_number;
    private JTextField fld_child_number;
    private JButton btn_search_room;
    private JButton btn_add_room;
    private JButton btn_reset;
    private JTable tbl_reservation;
    private JButton btn_logout;
    private  JPopupMenu hotelPopup;
    private  JPopupMenu roomPopup;
    private  JPopupMenu resPopup;

    private HotelManager hotelManager;
    private PensionManager pensionManager;
    private SeasonManager seasonsManager;
    private ReservationManager reservationManager;
    private RoomManager roomManager;
private int selectedHotelRow;
    public EmployeeView() {
        this.hotelManager=new HotelManager();
        this.pensionManager=new PensionManager();
        this.seasonsManager=new SeasonManager();
        this.roomManager=new RoomManager();
        this.reservationManager=new ReservationManager();

        this.add(container);
        this.GuiInitilaze(1480,700);
        this.loadHotelTable();
        this.loadPensionTable();
        this.loadSeasonsTable();
        this.loadRoomsTable(false);
        this.loadResTable();
        this.loadUserComponent();

        this.tbl_hotel.setComponentPopupMenu(hotelPopup);
        this.tbl_room.setComponentPopupMenu(roomPopup);
        this.tbl_reservation.setComponentPopupMenu(resPopup);
    }

    public void loadHotelTable(){
        Object[] col_names = {"ID", "Name", "Address"," Mail","Phone","Star","Carpark","Wifi","Pool","Fitness","Concierge","Spa","RoomService"};
        ArrayList<Object[]> hotelList = this.hotelManager.getForTable(col_names.length);
        this.createTable(this.hmdl_hotel,this.tbl_hotel,col_names,hotelList);
    }
    public void loadPensionTable(){
        Object[] col_names = {"ID", "Hotel ID", "Pansiyon Tipi"};
        ArrayList<Object[]> pensionList = this.pensionManager.getForTable(col_names.length);
        this.createTable(this.pmdl_pension,tbl_pension,col_names,pensionList);
    }
    public void loadSeasonsTable(){
        Object[] col_names = {"ID", "Hotel ID", "Başlangıç Tarihi"," Bitiş Tarihi"};
        ArrayList<Object[]> seasonList = this.seasonsManager.getForTable(col_names.length);
        this.createTable(this.smdl_season,this.tbl_seasons,col_names,seasonList);
    }
    public void loadResTable(){
        Object[] col_names = {"ID", "Oda ID", "Giriş Tarihi","Çıkış Tarihi","Misaifr Sayısı","Misafir Adı","Misafir Kimlik no","Mail","Telefon"};
        ArrayList<Object[]> resList = this.reservationManager.getForTable(col_names.length);
        this.createTable(this.resmdl_season,this.tbl_reservation,col_names,resList);
    }
    public void loadRoomsTable(boolean isFromSearch){
        Object[] col_names = {"ID", "Hotel Adı", "Pansiyon","Oda Tipi","Stok","Yetişkin Fiyat","Çocuk Fiyat","Yatak Kapasitesi","M2","TV","Minibar","Konsol","Kasa","Projeksiyon","Sezon Baslangıc","Sezon Bitiş"};
        ArrayList<Object[]> roomList;
        if(isFromSearch){
            String searchHotelname=fld_search_hotel_name.getText();
            String searchHotelAddress=fld_searc_hotel_address.getText();
            String searchCheckInDate= fld_searc_hotel_season_check_in.getText();
            String searchCheckOutDate=fld_searc_hotel_season_check_out.getText();
            int adultNumber=Integer.parseInt(fld_adult_number.getText());
            int childNumber=Integer.parseInt(fld_child_number.getText());
            roomList= this.roomManager.getForTableBySearch(col_names.length,roomManager.findBySearchValue(searchHotelname,searchHotelAddress,searchCheckInDate,searchCheckOutDate,adultNumber,childNumber));
        }else{
            roomList= this.roomManager.getForTable(col_names.length);
        }
        this.createTable(this.rmdl_season,this.tbl_room,col_names,roomList);
    }

    public void loadUserComponent(){

        this.roomPopup= new JPopupMenu(); // pop olustuuryoruz
        this.hotelPopup= new JPopupMenu(); // pop olustuuryoruz
        this.resPopup= new JPopupMenu(); // pop olustuuryoruz
        this.tbl_hotel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow  = tbl_hotel.rowAtPoint(e.getPoint());
                tbl_hotel.setRowSelectionInterval(selectedRow,selectedRow);
            }
        });
        this.tbl_pension.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow  = tbl_pension.rowAtPoint(e.getPoint());
                tbl_pension.setRowSelectionInterval(selectedRow,selectedRow);
            }
        });
        this.tbl_room.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow  = tbl_room.rowAtPoint(e.getPoint());
                tbl_room.setRowSelectionInterval(selectedRow,selectedRow);
            }
        });
        this.tbl_reservation.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow  = tbl_reservation.rowAtPoint(e.getPoint());
                tbl_reservation.setRowSelectionInterval(selectedRow,selectedRow);
            }
        });
        btn_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        this.hotelPopup.add("Yeni").addActionListener(e -> {
            HotelDetailView hotelDetailView = new HotelDetailView(null);
            hotelDetailView.addWindowListener(new WindowAdapter() {// pencerenın eventı dınlenıyor
                @Override
                public void windowClosed(WindowEvent e) {
                    loadHotelTable();
                }
            });
        });
        this.hotelPopup.add("Yeni Pansiyon Ekle").addActionListener(e -> {
            int selectedHotelId = getTableSelectedRow(tbl_hotel,0);

            PensionDetailView pensionDetailView =new PensionDetailView(null,selectedHotelId);
            pensionDetailView.addWindowListener(new WindowAdapter() {// pencerenın eventı dınlenıyor
                @Override
                public void windowClosed(WindowEvent e) {
                    loadHotelTable();
                    loadPensionTable();
                }
            });
        });
        this.hotelPopup.add("Yeni Sezon Ekle").addActionListener(e -> {
            int selectedHotelId = getTableSelectedRow(tbl_hotel,0);

            SeasonDetailView seasonDetailView =new SeasonDetailView(null,selectedHotelId);
            seasonDetailView.addWindowListener(new WindowAdapter() {// pencerenın eventı dınlenıyor
                @Override
                public void windowClosed(WindowEvent e) {
                    loadHotelTable();
                    loadSeasonsTable();
                }
            });
        });

        btn_add_room.addActionListener(e-> { //oda tabındakı oda ekle butonu
            RoomDetailView roomDetailView =new  RoomDetailView(null);
            roomDetailView.addWindowListener(new WindowAdapter() {// pencerenın eventı dınlenıyor
                @Override
                public void windowClosed(WindowEvent e) {
                    loadRoomsTable(false);
                }
            });
        });
        btn_search_room.addActionListener(e-> { //oda tabındakı oda ara butonu
          loadRoomsTable(true);
        });

        btn_reset.addActionListener(e-> { //reset butonu
            this.resetSearchValue();
        });



        this.roomPopup.add("Yeni Rezervasyon Oluştur").addActionListener(e -> {
            int selectedRoomId = getTableSelectedRow(tbl_room,0);
            String searchCheckInDate= fld_searc_hotel_season_check_in.getText();
            String searchCheckOutDate=fld_searc_hotel_season_check_out.getText();
            int adultNumber=Integer.parseInt(fld_adult_number.getText());
            int childNumber=Integer.parseInt(fld_child_number.getText());
            if(searchCheckInDate.isEmpty()||searchCheckOutDate.isEmpty()){
                Helper.showMsg("Giriş Çıkış Tarihi Seçmedin");
            }else if (adultNumber==0&&childNumber==0){
                Helper.showMsg("En az 1 kişi seçmen gerek");
            }else {
                ReservationDetailView reservationDetailView = new ReservationDetailView(selectedRoomId,searchCheckInDate, searchCheckOutDate,adultNumber,childNumber);
                reservationDetailView.addWindowListener(new WindowAdapter() {// pencerenın eventı dınlenıyor
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadResTable();
                        resetSearchValue();
                    }
                });
            }

        });

        this.resPopup.add("Düzenle").addActionListener(e -> {
            int selectedResId = getTableSelectedRow(tbl_reservation,0);
            int selectedResRoomId = getTableSelectedRow(tbl_reservation,1);

            ReservationDetailView reservationDetailView = new ReservationDetailView(selectedResId,selectedResRoomId);
            reservationDetailView.addWindowListener(new WindowAdapter() {// pencerenın eventı dınlenıyor
                @Override
                public void windowClosed(WindowEvent e) {
                    loadResTable();
                    resetSearchValue();
                }
            });
        });

        this.resPopup.add("Sil").addActionListener(e -> {
            if(Helper.confirm("sure")){
                int selectedResId = getTableSelectedRow(tbl_reservation,0);
                int selectedResRoomId = getTableSelectedRow(tbl_reservation,1);
                reservationManager.delete(selectedResId,selectedResRoomId);
                Helper.showMsg("done"); // basarılı gosterdık
                loadResTable();
                loadRoomsTable(false);
            }else{
                Helper.showMsg("error");
            }
        });

    }
    public void resetSearchValue(){
        fld_search_hotel_name.setText("");
        fld_searc_hotel_address.setText("");
        fld_searc_hotel_season_check_in.setText("");
        fld_searc_hotel_season_check_out.setText("");
        fld_adult_number.setText("0");
        fld_child_number.setText("0");
        loadRoomsTable(false);
    }


}
