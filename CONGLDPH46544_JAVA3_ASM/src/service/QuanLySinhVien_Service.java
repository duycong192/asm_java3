package service;

import java.util.ArrayList;
import java.util.List;
import model.Students;
import java.sql.*;

public class QuanLySinhVien_Service {

    List<Students> listStudent;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<Students> getAll() {
        listStudent = new ArrayList<>();
        sql = "select masv, hoten, email, sodt, gioitinh, diachi, hinh from STUDENTS";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Students sv = new Students(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getBytes(7));
                listStudent.add(sv);
            }
            return listStudent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public int insertSV(Students sv) {
        if (sv != null) {
            listStudent = new ArrayList<>();
            sql = "exec sp_insertstudents ?,?,?,?,?,?,?";
            try {
                con = DBConnect.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1, sv.getMaSV());
                ps.setString(2, sv.getHoTen());
                ps.setString(3, sv.getEmail());
                ps.setString(4, sv.getSoDT());
                ps.setInt(5, sv.getGioTinh());
                ps.setString(6, sv.getDiaChi());
                ps.setBytes(7, sv.getHinh());
                return ps.executeUpdate();
            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }
     public int upadateSV(Students sv) {
        if (sv != null) {
            listStudent = new ArrayList<>();
            sql = "exec sp_updatestudents ?,?,?,?,?,?,?";
            try {
                con = DBConnect.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1, sv.getMaSV());
                ps.setString(2, sv.getHoTen());
                ps.setString(3, sv.getEmail());
                ps.setString(4, sv.getSoDT());
                ps.setInt(5, sv.getGioTinh());
                ps.setString(6, sv.getDiaChi());
                ps.setBytes(7, sv.getHinh());
                return ps.executeUpdate();
            } catch (Exception e) {
                return 0;
            }
        }
        return 0;
    }
     public int deleteSV (String maSV){
         listStudent = new ArrayList<>();
         sql = "delete students where masv = ?";
         try {
             con = DBConnect.getConnection();
             ps = con.prepareStatement(sql);
             ps.setString(1, maSV);
             return ps.executeUpdate();
         } catch (Exception e) {
             return 0;
         }
     }

    public static void main(String[] args) {
        List<Students> list = new ArrayList<>();
        QuanLySinhVien_Service qlsv = new QuanLySinhVien_Service();
        list = qlsv.getAll();
        for (Students students : list) {
            System.out.println(students.toString());
        }

    }

}
