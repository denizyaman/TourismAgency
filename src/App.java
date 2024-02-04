package src;

import src.business.UserManager;
import src.core.Helper;
import src.view.AdminView;
import src.view.LoginView;
import src.view.UserView;

import javax.swing.*;

public class App {
    public static void  main(String[] args){
        Helper.setTheme();
        LoginView loginView= new LoginView();
    }
}
