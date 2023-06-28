package com.example.appbanhang.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbanhang.R;
import com.example.appbanhang.model.DonHang;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class DonHangAdapter extends RecyclerView.Adapter<DonHangAdapter.MyViewHolder> {
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    Context context;
    List<DonHang> listdonhang;

    public DonHangAdapter(Context context, List<DonHang> listdonhang) {
        this.context = context;
        this.listdonhang = listdonhang;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_donhang, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DonHang donHang = listdonhang.get(position);
        //đưa id kiểu int về kiểu chuổi
        holder.txtdonhang.setText("Đơn hàng: " + donHang.getId());
        holder.lienhe.setText("Số điện thoại: "+ donHang.getSodienthoai());
        holder.emial.setText("Email: "+donHang.getEmail());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.tongtien.setText("Tổng tiền: "+ decimalFormat.format(Double.parseDouble(donHang.getTongtien()))+" VND");
        holder.diachi.setText("Địa chỉ: "+donHang.getDiachi());
        holder.tinhtrang.setText(tinhTrangDonHang(donHang.getTinhtrang()));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        holder.ngaydat.setText("Ngày đặt hàng: "+ format.format(donHang.getNgaydathang()));
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                holder.reChitiet.getContext(),
                LinearLayoutManager.VERTICAL,
                false
        );
        layoutManager.setInitialPrefetchItemCount(donHang.getItem().size());
        //adapter chi tiet
        ChiTietAdapter chiTietAdapter = new ChiTietAdapter(context, donHang.getItem());
        holder.reChitiet.setLayoutManager(layoutManager);
        holder.reChitiet.setAdapter(chiTietAdapter);
        holder.reChitiet.setRecycledViewPool(viewPool);

    }

    private String tinhTrangDonHang(int status){
        String result = "";
        switch (status){
            case 0:
                result = "Đơn hàng đang được xử lý";
                break;
            case 1:
                result =  "Đơn hàng đã được chấp nhập";
                break;
            case 2:
                result =  "Đơn hàng đã giao cho đơn vị vận chuyển";
                break;
            case 3:
                result =  "Giao hàng thành công";
                break;
            case 4:
                result =  "Đơn hàng đã hủy";
                break;
        }

        return result;
    }

    @Override
    public int getItemCount() {
        return listdonhang.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView txtdonhang, tinhtrang, diachi, lienhe, tongtien, ngaydat, emial;
        RecyclerView reChitiet;

        public  MyViewHolder(@NonNull View itemView){
            super(itemView);
            ngaydat = itemView.findViewById(R.id.tongtien_ngaydat);
            emial = itemView.findViewById(R.id.diachi_email);
            txtdonhang = itemView.findViewById(R.id.iddonhang);
            reChitiet = itemView.findViewById(R.id.recyclerview_chitiet);
            diachi = itemView.findViewById(R.id.diachi_donhang);
            lienhe = itemView.findViewById(R.id.lienhe_donhang);
            tongtien = itemView.findViewById(R.id.tongtien_donhang);
            tinhtrang = itemView.findViewById(R.id.tinhtrang);
        }
    }
}
