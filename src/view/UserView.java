package src.view;

import src.business.UserManager;
import src.core.Helper;
import src.entity.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserView extends Layout{
    private JPanel container;
    private JLabel lbl_user;
    private JLabel lbl_userName;
    private JTextField fld_userName;
    private JLabel lbl_userPass;
    private JTextField fld_userPass;
    private JLabel lbl_userRole;
    private JTextField fld_userRole;
    private JButton btn_user_save;
    private User user;
    private UserManager userManager;

    public UserView(User user) {
        this.userManager = new UserManager();
        this.add(container);
        this.GuiInitilaze(300,300);
        this.user = user;

        if(this.user!=null){
            this.fld_userName.setText(this.user.getUsername());
            this.fld_userPass.setText(this.user.getPassword());
            this.fld_userRole.setText(this.user.getRole());
        }


        btn_user_save.addActionListener(e-> { // kaydet butonunun basılmasını dınlıyoruz basılınca doldurulan alanlarla kaydedıyoruz
           if(Helper.isFieldListEmpty(new JTextField[]{this.fld_userName,this.fld_userPass,this.fld_userRole})){
               Helper.showMsg("fill");// gırılen alanlardan bırısı bos ıse doldur dıye hata verıyrouz
           }else {
               boolean result;
               if(this.user==null){
                   User newUser= new User(fld_userName.getText(),fld_userPass.getText(),fld_userRole.getText()); //gırılen alanlarla yenı bır user nesnesı olusturuyoruz
                   result=this.userManager.saveUser(newUser); // managerda kı methoda parametre olarak verıyoruz
               }else{
                   this.user.setUsername(fld_userName.getText());
                   this.user.setPassword(fld_userPass.getText());
                   result = this.userManager.updateUser(this.user);

               }

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
