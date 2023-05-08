package com.manager.appbanhang.model.EventBus;

import com.manager.appbanhang.model.DonHang;

public class Sua_Xoa_Event_2 {
    DonHang donHang;

    public Sua_Xoa_Event_2(DonHang donHang) {
        this.donHang = donHang;
    }

    public DonHang getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang donHang) {
        this.donHang = donHang;
    }
}