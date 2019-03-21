package com.bean;

import com.common.DbHandle;
import com.vo.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginBean {
    public User login(String username, String password) throws SQLException {
//        访问数据库
        DbHandle db = new DbHandle();
        String sql = "select * from user where username='" + username +"' and password='" + password + "'";
        ResultSet rs = db.executeQuery(sql);
//        将用户信息封装在User中
        User user = new User();
        if(rs.next()){
            int userid = rs.getInt("id");
            String username1 = rs.getString("username");
            String password1 = rs.getString("password");
            String sex = rs.getString("sex");
            String profession = rs.getString("profession");
            String favourite = rs.getString("favourite");
            String type = rs.getString("type");

            user.setId(userid);
            user.setUsername(username1);
            user.setProfession(password1);
            user.setSex(sex);
            user.setProfession(profession);
            user.setFavourite(favourite);
            user.setNote(type);

            db.close();
            return user;
        }
        else {
            db.close();
            return null;
        }
    }
}
