package src.view;

import src.business.UserManager;
import src.core.Helper;
import src.entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LoginView extends Layout {
    private JPanel container;
    private JPanel w_top;
    private JLabel lbl_welcome;
    private JLabel lbl_welcome2;
    private JTextField fld_username;
    private JPasswordField fld_pass;
    private JButton btn_login;
    private JLabel lbl_username;
    private JLabel lbl_pass;
    private final UserManager userManager;

    public LoginView(){
        this.userManager=new UserManager();
        this.add(container);
        this.GuiInitilaze(400,400);

        this.setLocation(Helper.getLocationPoint("x",this.getSize()),
                (Helper.getLocationPoint("y",this.getSize())));
        this.setVisible(true);

        btn_login.addActionListener(e -> {
            JTextField[] checkFieldList = {this.fld_username, this.fld_pass};
            if (Helper.isFieldListEmpty(checkFieldList)){
                Helper.showMsg("fill");
            }else{
                User loginUser = this.userManager.findByLogin(this.fld_username.getText(),this.fld_pass.getText());
                if (loginUser==null){
                    Helper.showMsg("notFound");
                }else {
                    if(Objects.equals(loginUser.getRole(), "admin")) {// admin yada user rolüne göre giriş yapılıyor
                        AdminView adminView = new AdminView(loginUser);
                        dispose();
                    }else {
                        EmployeeView employeeView= new EmployeeView();
                        dispose();
                    }
                }
            }


        });
    }
}
