/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.SinhVien;
import java.sql.*;

/**
 *
 * @author admin
 */
public class SinhVien_Service {

    List<SinhVien> listSV;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<SinhVien> getAll() {
        //lấy toàn bộ dl sql sang list
        listSV = new ArrayList<>();
        sql = " select id,masinhvien,hoten,diemtrungbinh,nganhhoc,gioitinh from sinhvien";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//thuc thi câu lệnh sql
            //lấy kết quả trả về rs
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6));
                listSV.add(sv);
            }
            return listSV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insertDataToDB(String ma, String ten, double diem, String nganh, int gioiTinh) {
        try {
            Connection con = DBConnect.getConnection();
            //lenh
            String sql = " insert into sinhvien  values (?,?,?,?,?)";
            //chuuan bi lenh
            PreparedStatement ps = con.prepareStatement(sql);
            //chuan bi tham so
            ps.setString(1, ma);
            ps.setString(2, ten);
            ps.setDouble(3, diem);
            ps.setString(4, nganh);
            ps.setInt(5, gioiTinh);

            //thuc thi lenh
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SinhVien> timTheoTen(String ten) {
        try {
            listSV = new ArrayList<>();
            con = DBConnect.getConnection();
            sql = " select id,masinhvien,hoten,diemtrungbinh,nganhhoc,gioitinh from sinhvien where hoten like ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + ten + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6));
                listSV.add(sv);
            }
            return listSV;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<SinhVien> locTheoGioiTinh(int gioiTinh) {
        try {
            listSV = new ArrayList<>();
            con = DBConnect.getConnection();
            sql = "select id,masinhvien,hoten,diemtrungbinh,nganhhoc,gioitinh from sinhvien where gioitinh = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, gioiTinh);
            rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6));
                listSV.add(sv);
            }

            return listSV;
        } catch (Exception e) {
            return null;
        }

    }

    public List<SinhVien> sapXepTheoDiem() {
        try {
            listSV = new ArrayList<>();
            con = DBConnect.getConnection();
            sql = " select id,masinhvien,hoten,diemtrungbinh,nganhhoc,gioitinh from sinhvien order by diemtrungbinh desc";
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6));
                listSV.add(sv);
            }
            return listSV;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void deleteDataToDB(String ten) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "delete sinhvien where masinhvien = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public int insertSV(SinhVien sv) {
        sql = " insert into sinhvien  values (?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, sv.getMa());
            ps.setString(2, sv.getTen());
            ps.setDouble(3, sv.getDiem());
            ps.setString(4, sv.getNganh());
            ps.setInt(5, sv.getGioiTinh());
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteSV(String ma) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = "delete sinhvien where masinhvien = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;

        }

    }

    public int updateSV(String ma, SinhVien sv) {
        String sql = "update sinhvien set hoten =?, diemtrungbinh = ?, nganh =?, gioitinh = ?\n"
                + "where masinhvien = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sv.getTen());
            ps.setDouble(2, sv.getDiem());
            ps.setString(3, sv.getNganh());
            ps.setInt(4, sv.getGioiTinh());
            ps.setString(5, sv.getMa());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;

        }
    }

    public static void main(String[] args) {
        SinhVien_Service ss = new SinhVien_Service();
        List<SinhVien> kq = ss.locTheoGioiTinh(1);
        for (SinhVien x : kq) {
            System.out.println(x.toString());

        }
    }

}
