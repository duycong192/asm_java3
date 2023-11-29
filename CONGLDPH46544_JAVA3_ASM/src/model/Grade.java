package model;

public class Grade {

    private int id;
    private String maSV;
    private double tiengAnh;
    private double tinHoc;
    private double GDTC;
    private String hoTen;

    public Grade() {
    }

    public Grade(int id, String maSV, double tiengAnh, double tinHoc, double GDTC, String hoTen) {
        this.id = id;
        this.maSV = maSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.GDTC = GDTC;
        this.hoTen = hoTen;
    }

    public Grade(int id, String maSV, double tiengAnh, double tinHoc, double GDTC) {
        this.id = id;
        this.maSV = maSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.GDTC = GDTC;
    }

    public Grade(String maSV, double tiengAnh, double tinHoc, double GDTC) {
        this.maSV = maSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.GDTC = GDTC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public double getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(double tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public double getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(double tinHoc) {
        this.tinHoc = tinHoc;
    }

    public double getGDTC() {
        return GDTC;
    }

    public void setGDTC(double GDTC) {
        this.GDTC = GDTC;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    

    

    public double getDiemTB() {
        return (tiengAnh + tinHoc + GDTC) / 3;
    }

    @Override
    public String toString() {
        return "Grade{" + "id=" + id + ", maSV=" + maSV + ", tiengAnh=" + tiengAnh + ", tinHoc=" + tinHoc + ", GDTC=" + GDTC + '}';
    }

}
