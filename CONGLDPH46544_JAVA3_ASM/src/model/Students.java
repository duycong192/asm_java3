package model;

public class Students {

    private String maSV;
    private String hoTen;
    private String email;
    private String soDT;
    private int gioTinh;
    private String diaChi;
    private String hinh;

    public Students() {
    }

    public Students(String maSV, String hoTen, String email, String soDT, int gioTinh, String diaChi, String hinh) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.email = email;
        this.soDT = soDT;
        this.gioTinh = gioTinh;
        this.diaChi = diaChi;
        this.hinh = hinh;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public int getGioTinh() {
        return gioTinh;
    }

    public void setGioTinh(int gioTinh) {
        this.gioTinh = gioTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    @Override
    public String toString() {
        return "Students{" + "maSV=" + maSV + ", hoTen=" + hoTen + ", email=" + email + ", soDT=" + soDT + ", gioTinh=" + gioTinh + ", diaChi=" + diaChi + ", hinh=" + hinh + '}';
    }

}
