package com.manager.appbanhang.model;

public class ThongKe {
    private String tensanpham;
    private int tong;
    private String tongtienthang;
    private String thang;

    public String getTongtienthang() {
        return tongtienthang;
    }

    public void setTongtienthang(String tongtienthang) {
        this.tongtienthang = tongtienthang;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensanpham) {
        this.tensanpham = tensanpham;
    }

    public int getTong() {
        return tong;
    }

    public void setTong(int tong) {
        this.tong = tong;
    }
}
