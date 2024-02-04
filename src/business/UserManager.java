package src.business;

import src.core.Helper;
import src.dao.UserDao;
import src.entity.User;

import java.util.ArrayList;
import java.util.Objects;

public class UserManager {
    private final UserDao userDao;

    public UserManager() { this.userDao = new UserDao(); }


    public User findByLogin(String username, String password) {
        return this.userDao.findByLogin(username, password);
    }
    public User findById(int userId) {
        return this.userDao.findById(userId);
    }

    public ArrayList<User> findAll() {
        return this.userDao.findAll();
    }
    public ArrayList<Object[]> getForTable(int size, String role){
        ArrayList<Object[]> userRowList=new ArrayList<>();
        for (User user: this.findItems(role)){
            Object[] rowObject=new Object[size];
            int i=0;
            rowObject[i++]=user.getId();
            rowObject[i++]=user.getUsername();
            rowObject[i++]=user.getPassword();
            rowObject[i++]=user.getRole();
            userRowList.add(rowObject);
        }
        return userRowList;
    }
    public ArrayList<User> findItems(String role){
        if(Objects.equals(role, "All")){
            return this.findAll();
        }else{
            return this.findByRole(role);
        }
    }
    public ArrayList<User> findByRole(String role) {
        return this.userDao.findByRole(role);
    }

    public boolean saveUser(User user){
        return this.userDao.addUser(user);
    }
    public boolean updateUser(User user){
        if(this.userDao.findById(user.getId())==null){
            Helper.showMsg("notFound");
        }{
            return this.userDao.updateUser(user);
        }
    }
    public boolean deleteUser(int userId){
        return this.userDao.deleteUser(userId);
    }
}
