package com.manager.appbanhang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.manager.appbanhang.R;
import com.manager.appbanhang.model.ChatMessage;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ChatMessage> chatMessages;
    private String sendid;
    private static final  int TYPE_SEND = 1;
    private static final  int TYPE_RECEIVED = 2;

    public ChatAdapter(Context context, List<ChatMessage> chatMessages, String sendid) {
        this.context = context;
        this.chatMessages = chatMessages;
        this.sendid = sendid;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view;
        if(viewType == TYPE_SEND){
            view = LayoutInflater.from(context).inflate(R.layout.item_send_mess, parent, false);
            return new SendMessViewHolder(view);

        }else {
            view = LayoutInflater.from(context).inflate(R.layout.item_received, parent, false);
            return new ReceivedViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position) == TYPE_SEND){
            ((SendMessViewHolder) holder).txtmess.setText(chatMessages.get(position).mess);
            ((SendMessViewHolder) holder).txttime.setText(chatMessages.get(position).datatime);
        }else {
            ((ReceivedViewHolder) holder).txtmess.setText(chatMessages.get(position).mess);
            ((ReceivedViewHolder) holder).txttime.setText(chatMessages.get(position).datatime);
        }

    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(chatMessages.get(position).sendid.equals(sendid)){
            return TYPE_SEND;
        }else{
            return TYPE_RECEIVED;
        }
    }

    class SendMessViewHolder extends RecyclerView.ViewHolder{
        TextView txtmess, txttime;
        public SendMessViewHolder(@NonNull View itemView){
            super(itemView);
            txtmess = itemView.findViewById(R.id.txtmesssend);
            txttime = itemView.findViewById(R.id.txttimesend);
        }
    }
    class ReceivedViewHolder extends RecyclerView.ViewHolder{
        TextView txtmess, txttime;
        public ReceivedViewHolder(@NonNull View itemView) {
            super(itemView);
            txtmess = itemView.findViewById(R.id.txtmessrec);
            txttime = itemView.findViewById(R.id.txttimerec);
        }
    }
}
