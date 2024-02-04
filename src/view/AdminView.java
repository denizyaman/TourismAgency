package src.view;

import src.business.UserManager;
import src.core.Helper;
import src.entity.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class AdminView extends Layout{
    private JPanel container;
    private JPanel pnl_top;
    private JTabbedPane tab_menu;
    private JButton btn_logout;
    private JPanel pnl_users;
    private JScrollPane scrl_users;
    private JTable tbl_users;
    private JLabel lbl_welcome;
    private JComboBox filterCombo;
    private JLabel lbl_combo;
    private User user;
    private String filter="All";



    private DefaultTableModel umdl_user = new DefaultTableModel( );
    private UserManager userManager;
    private  JPopupMenu userPopup;

    public AdminView(User user){
        this.userManager = new UserManager();
        this.add(container);
        this.GuiInitilaze(1000,500);
        this.user=user;
        if(this.user==null){
            dispose();
        }
        this.lbl_welcome.setText("Hoşgeldiniz : "+ this.user.getUsername());

        this.loadUserTable(); // tablononun doldurulmasını bır mehtoda bagladıkkı bırden falz yerde (user ekleme sılme ve guncelleme sonrasıda bu methodu cagırarak guncel user lıstesını cekıyoruz )
        this.loadUserComponent(); // lıstenerler yuklenıyor

        this.tbl_users.setComponentPopupMenu(userPopup);
    }

    public void loadUserTable(){
        Object[] col_names = {"Kullanıcı Id", "Kullanıcı Adı", "Kullanıcı Şifresi"," Kullanıcı Rolü"};
        ArrayList<Object[]> userList = this.userManager.getForTable(col_names.length, this.getFilter());
        this.createTable(this.umdl_user,this.tbl_users,col_names,userList);
    }
    public void loadUserComponent(){


        this.filterCombo.addItem("All");
        this.filterCombo.addItem("user");
        this.filterCombo.addItem("admin");
        this.filterCombo.setSelectedIndex(0);
        filterCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JComboBox<String> combo = (JComboBox<String>) event.getSource();
                String selectedRole = (String) combo.getSelectedItem();
                setFilter(selectedRole);
                loadUserTable();
            }
        });

        this.tbl_users.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {// tıklanan satırın secılebılmesı ıcın mouse un tıklanası eventıne bır lıstener baglıyoruz
                int selectedRow  = tbl_users.rowAtPoint(e.getPoint());
                tbl_users.setRowSelectionInterval(selectedRow,selectedRow);
            }
        });
        btn_logout.addActionListener(new ActionListener() { // cıkıs yap butonu
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        this.userPopup= new JPopupMenu(); // pop olustuuryoruz
        this.userPopup.add("Yeni").addActionListener(e -> { // popup ıcın Yenı butonu olusturup buna bır lıstener baglıyoruz buda butona tıklanıp tıklanmamasını dınlıyor
            UserView userView = new UserView(null);// null vererek bır nesne olusutuyoruzkı yenı olusturulacagı anlasılsın
            userView.addWindowListener(new WindowAdapter() {// pencerenın eventı dınlenıyor
                @Override
                public void windowClosed(WindowEvent e) {
                    loadUserTable();// pencere kapatıldıgı anda guncellenen yenı degerler databaseden cekılıp tablo doluyor
                }
            });
        });
        this.userPopup.add("Güncelle").addActionListener(e -> {
            int seledtedUserId = getTableSelectedRow(tbl_users,0);
            UserView userView =new UserView(userManager.findById(seledtedUserId));
            userView.addWindowListener(new WindowAdapter() { // pencerenın eventı dınlenıyor
                @Override
                public void windowClosed(WindowEvent e) { // pencere kapatıldıgı anda guncellenen yenı degerler databaseden cekılıp tablo doluyor
                    loadUserTable();
                }
            });
        });

        this.userPopup.add("Sil").addActionListener(e -> {
            if(Helper.confirm("sure")){
                int seledtedUserId = getTableSelectedRow(tbl_users,0); // secılen satırdakı ıdyı aldık
                userManager.deleteUser(seledtedUserId);
                Helper.showMsg("done"); // basarılı gosterdık
                loadUserTable();
            }else{
                Helper.showMsg("error");
            }


        });


    }
    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
}
