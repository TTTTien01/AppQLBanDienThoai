package com.example.appbanhang.model;

import java.io.Serializable;

public class SanPhamMoi implements Serializable {
    int id;
    String tensanpham;
    String giasp;
    String hinhanh;
    String mota;
    String soluongkho;
    int loai;

    public String getSoluongkho() {
        return soluongkho;
    }

    public void setSoluongkho(String soluongkho) {
        this.soluongkho = soluongkho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public String getGiasp() {
        return giasp;
    }

    public void setGiasp(String giasp) {
        this.giasp = giasp;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }
}
