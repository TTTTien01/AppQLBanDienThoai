package com.manager.appbanhang.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.manager.appbanhang.Interface.ItemClickListener;
import com.manager.appbanhang.R;
import com.manager.appbanhang.model.DonHang;
import com.manager.appbanhang.model.EventBus.DonHangEvent;

import org.greenrobot.eventbus.EventBus;

import java.text.DecimalFormat;
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
        holder.tenuser.setText("Khách hàng: " + donHang.getIduser());
        holder.lienhe.setText("Số điện thoại: "+ donHang.getSodienthoai());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.tongtien.setText("Tổng tiền: "+ decimalFormat.format(Double.parseDouble(donHang.getTongtien()))+" VND");
        holder.diachi.setText("Địa chỉ: "+donHang.getDiachi());
        holder.tinhtrang.setText(tinhTrangDonHang(donHang.getTinhtrang()));
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
        //post xem tình trang don hang
        holder.setListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int pos, boolean isLongClick) {
                if(isLongClick){
                    EventBus.getDefault().postSticky(new DonHangEvent(donHang));
                }
            }
        });


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

    public class MyViewHolder extends  RecyclerView.ViewHolder implements View.OnLongClickListener {
        TextView txtdonhang, tinhtrang, diachi, tenuser, lienhe, tongtien;
        RecyclerView reChitiet;
        ItemClickListener listener;

        public  MyViewHolder(@NonNull View itemView){
            super(itemView);
            txtdonhang = itemView.findViewById(R.id.iddonhang);
            reChitiet = itemView.findViewById(R.id.recyclerview_chitiet);
            diachi = itemView.findViewById(R.id.diachi_donhang);
            tenuser = itemView.findViewById(R.id.ten_donhang);
            lienhe = itemView.findViewById(R.id.lienhe_donhang);
            tongtien = itemView.findViewById(R.id.tongtien_donhang);
            tinhtrang = itemView.findViewById(R.id.tinhtrang);
            itemView.setOnLongClickListener(this);
        }

        public void setListener(ItemClickListener listener) {
            this.listener = listener;
        }

        @Override
        public boolean onLongClick(View view) {
            listener.onClick(view, getAdapterPosition(), true);
            return false;
        }
    }
}
