package com.bean;
import com.vo.User;
import com.common.DbHandle;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterBean {
    public boolean checkRepeatUsername(User user) throws SQLException{
        DbHandle db = new DbHandle();
        String sql_username = "select * from user where username='" + user.getUsername() +"'";
        ResultSet rs = db.executeQuery(sql_username);
        return !rs.next();
    }
    public void registerUser(User user){
        DbHandle db = new DbHandle();
        String sql = "insert into user(username, password, sex, profession, favourite, note)" +
                "values('"+user.getUsername() + "','" + user.getPassword() + "','" + user.getSex() +
                "','" + user.getProfession() + "','" + user.getFavourite() + "','" +
                user.getNote() + "')";
        db.executeUpdate(sql);
        db.close();

    }
}
