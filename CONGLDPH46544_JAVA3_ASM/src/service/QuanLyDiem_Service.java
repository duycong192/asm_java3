/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Grade;
import model.Students;

/**
 *
 * @author admin
 */
public class QuanLyDiem_Service {

    List<Grade> listDiem;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<Grade> getAll() {
        //lấy toàn bộ dl sql sang list
        listDiem = new ArrayList<>();
        sql = "select g.id, g.MaSV, s.hoten, g.Tienganh, g.Tinhoc,g.GDTC from Students s join GRADE g on s.masv = g.MaSV";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//thuc thi câu lệnh sql
            //lấy kết quả trả về rs
            while (rs.next()) {
                Grade d = new Grade(rs.getInt(1), rs.getString(2), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getString(3));
                listDiem.add(d);
            }
            return listDiem;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Grade> FindMa(String ma) {
        listDiem = new ArrayList<>();
        sql = "select g.id,s.MaSV, s.hoten, g.Tienganh, g.Tinhoc,g.GDTC from Students s full join GRADE g on s.masv = g.MaSV where s.MaSV = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                Grade d = new Grade(rs.getInt(1), rs.getString(2), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getString(3));
                listDiem.add(d);
            }
            return listDiem;
        } catch (Exception e) {
            return null;
        }
    }

   

    public int deleteGrade(String ma) {
        sql = "delete grade where MaSV = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, ma);
            return ps.executeUpdate();

        } catch (Exception e) {
            return 0;
        }
    }

    public int updateGrade(Grade g) {
        if (g != null) {
            sql = "exec sp_updatediem ?,?,?,?";
            try {
                con = DBConnect.getConnection();
                ps = con.prepareStatement(sql);
                ps.setDouble(2, g.getTiengAnh());
                ps.setDouble(3, g.getTinHoc());
                ps.setDouble(4, g.getGDTC());
                ps.setString(1, g.getMaSV());
                return ps.executeUpdate();

            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }

    public List<Grade> updateFrom() {
        //lấy toàn bộ dl sql sang list
        listDiem = new ArrayList<>();
        sql = "SELECT g.id, s.MaSV, s.hoten, g.Tienganh, g.Tinhoc, g.GDTC\n"
                + "FROM Students s\n"
                + "JOIN GRADE g ON s.masv = g.MaSV\n"
                + "WHERE (g.Tienganh + g.Tinhoc + g.GDTC) = (\n"
                + "    SELECT TOP 1 (g2.Tienganh + g2.Tinhoc + g2.GDTC)\n"
                + "    FROM GRADE g2\n"
                + "    WHERE g2.MaSV = g.MaSV\n"
                + "    ORDER BY (g2.Tienganh + g2.Tinhoc + g2.GDTC) DESC\n"
                + ")\n"
                + "ORDER BY (g.Tienganh + g.Tinhoc + g.GDTC) DESC;";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//thuc thi câu lệnh sql
            //lấy kết quả trả về rs
            while (rs.next()) {
                Grade d = new Grade(rs.getInt(1), rs.getString(2), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6), rs.getString(3));
                listDiem.add(d);
            }
            return listDiem;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
}
