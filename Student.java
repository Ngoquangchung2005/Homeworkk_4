package QLHSJAVA;

public class Student {
    private String maSinhVien;
    private String hoTen;
    private String gioiTinh;
    private double diemPython;
    private double diemJava;
    private double diemTB;
    private String ketQua;

    public Student(String maSinhVien, String hoTen, String gioiTinh, double diemPython, double diemJava) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diemPython = diemPython;
        this.diemJava = diemJava;
        this.diemTB = (diemJava * 2 + diemPython) / 3;
        this.ketQua = (diemTB >= 5) ? "Đậu" : ((diemTB < 5 && gioiTinh.equals("Nam")) ? "Trượt" : "Đậu");
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public double getDiemPython() {
        return diemPython;
    }

    public double getDiemJava() {
        return diemJava;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public String getKetQua() {
        return ketQua;
    }

    @Override
    public String toString() {
        return maSinhVien + ", " + hoTen + ", " + gioiTinh + ", " + diemPython + ", " + diemJava + ", " + diemTB + ", " + ketQua;
    }
}
