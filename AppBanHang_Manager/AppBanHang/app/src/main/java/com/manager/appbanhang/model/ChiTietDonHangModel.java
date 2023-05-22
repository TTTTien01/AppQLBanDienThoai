package com.manager.appbanhang.model;

import java.util.List;

public class ChiTietDonHangModel {
    boolean success;
    String message;
    List<ChiTietDonHang> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ChiTietDonHang> getResult() {
        return result;
    }

    public void setResult(List<ChiTietDonHang> result) {
        this.result = result;
    }
}
