package model;

public class Grade {

    private int id;
    private String maSV;
    private int tiengAnh;
    private int tinHoc;
    private int GDTC;

    public Grade() {
    }

    public Grade(int id, String maSV, int tiengAnh, int tinHoc, int GDTC) {
        this.id = id;
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

    public int getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(int tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public int getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(int tinHoc) {
        this.tinHoc = tinHoc;
    }

    public int getGDTC() {
        return GDTC;
    }

    public void setGDTC(int GDTC) {
        this.GDTC = GDTC;
    }

    @Override
    public String toString() {
        return "Grade{" + "id=" + id + ", maSV=" + maSV + ", tiengAnh=" + tiengAnh + ", tinHoc=" + tinHoc + ", GDTC=" + GDTC + '}';
    }

}
