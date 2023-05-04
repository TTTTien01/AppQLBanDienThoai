package com.manager.appbanhang.model.EventBus;

import com.manager.appbanhang.model.SanPhamMoi;

public class Sua_Xoa_Event {
    SanPhamMoi sanPhamMoi;

    public Sua_Xoa_Event(SanPhamMoi sanPhamMoi) {
        this.sanPhamMoi = sanPhamMoi;
    }

    public SanPhamMoi getSanPhamMoi() {
        return sanPhamMoi;
    }

    public void setSanPhamMoi(SanPhamMoi sanPhamMoi) {
        this.sanPhamMoi = sanPhamMoi;
    }
}
