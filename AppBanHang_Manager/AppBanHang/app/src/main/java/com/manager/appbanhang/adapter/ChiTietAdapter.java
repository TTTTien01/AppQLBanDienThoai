package com.manager.appbanhang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.manager.appbanhang.R;
import com.manager.appbanhang.model.Item;
import com.manager.appbanhang.utils.Utils;

import java.util.List;

public class ChiTietAdapter extends RecyclerView.Adapter<ChiTietAdapter.MyViewHodel> {
    Context context;
    List<Item> itemList;

    public ChiTietAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    public ChiTietAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chi_tiet,parent,false);
        return new MyViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHodel holder, int position) {
        Item item = itemList.get(position);
        holder.txtten.setText(item.getTensanpham() + "");
        holder.txtsoluong.setText("Số lương: "+ item.getSoluong()+ "");
        if(item.getHinhanh().contains("http")){
            Glide.with(context).load(item.getHinhanh()).into(holder.imagechitiet);
        }else{
            Glide.with(context).load(Utils.BASE_URL+"images/"+item.getHinhanh()).into(holder.imagechitiet);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHodel extends  RecyclerView.ViewHolder {
        ImageView imagechitiet;
        TextView txtten, txtsoluong;

        public MyViewHodel(@NonNull View itemView) {
            super(itemView);
            imagechitiet  = itemView.findViewById(R.id.item_imgchitiet);
            txtten = itemView.findViewById(R.id.item_tenspchitiet);
            txtsoluong = itemView.findViewById(R.id.item_soluongspchitiet);


        }
    }
}
