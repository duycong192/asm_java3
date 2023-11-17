/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class SinhVien {

    private long id;
    private String ma;
    private String ten;
    private double diem;
    private String nganh;
    private int gioiTinh;

    public SinhVien() {
    }

    public SinhVien(long id, String ma, String ten, double diem, String nganh, int gioiTinh) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.diem = diem;
        this.nganh = nganh;
        this.gioiTinh = gioiTinh;
    }

    public SinhVien(String ma, String ten, double diem, String nganh, int gioiTinh) {

        this.ma = ma;
        this.ten = ten;
        this.diem = diem;
        this.nganh = nganh;
        this.gioiTinh = gioiTinh;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Object[] toDataRow() {
        return new Object[]{this.id, this.getMa(), this.ten, this.diem, this.nganh, this.gioiTinh
        };
    }

    @Override
    public String toString() {
        return "SinhVien{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", diem=" + diem + ", nganh=" + nganh + ", gioiTinh=" + gioiTinh + '}';
    }

}
