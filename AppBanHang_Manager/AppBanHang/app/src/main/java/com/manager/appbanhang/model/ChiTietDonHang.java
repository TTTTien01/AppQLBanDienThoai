package com.manager.appbanhang.model;

public class ChiTietDonHang {
    private int iddonhang;
    private int idsp;
    private int soluong;
    private String gia;
    private String Tongsoluong;
    private String tensanpham;

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getTongsoluong() {
        return Tongsoluong;
    }

    public void setTongsoluong(String tongsoluong) {
        Tongsoluong = tongsoluong;
    }

    public int getIddonhang() {
        return iddonhang;
    }

    public void setIddonhang(int iddonhang) {
        this.iddonhang = iddonhang;
    }

    public int getIdsp() {
        return idsp;
    }

    public void setIdsp(int idsp) {
        this.idsp = idsp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
