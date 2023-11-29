/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Login;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Login_Service {

    List<Login> listLogin;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<Login> getAll() {
        listLogin = new ArrayList<>();
        sql = "select Username, Password,Role from USERS";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Login lg = new Login(rs.getString(1), rs.getString(2), rs.getString(3));
                listLogin.add(lg);

            }
            return listLogin;
        } catch (Exception e) {
            return null;
        }
    }

}
