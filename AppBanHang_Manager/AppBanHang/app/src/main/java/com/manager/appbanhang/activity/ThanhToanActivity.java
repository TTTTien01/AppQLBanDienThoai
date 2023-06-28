package com.manager.appbanhang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import com.google.gson.Gson;
import com.manager.appbanhang.R;
import com.manager.appbanhang.model.GioHang;
import com.manager.appbanhang.model.SanPhamMoi;
import com.manager.appbanhang.retrofit.ApiBanHang;
import com.manager.appbanhang.retrofit.RetrofitClient;
import com.manager.appbanhang.utils.Utils;

import java.text.DecimalFormat;

import io.paperdb.Paper;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ThanhToanActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView txttongtien, txtsodt, txtemail,txttenKH;
    EditText edtdiachi;
    AppCompatButton btndathang;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiBanHang apiBanHang;
    SanPhamMoi sanPhamMoi;
    long tongtien;
    int soluong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);
        initView();
        countItem();
        initControl();
    }

    private void countItem() {
        soluong = 0;
        for(int i = 0; i< Utils.mangmuahang.size(); i++){
            soluong = soluong+ Utils.mangmuahang.get(i).getSoluong();
        }
    }

    private void initControl() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tongtien = getIntent().getLongExtra("tongtien",0);
        txttenKH.setText(Utils.user_current.getUsername());
        txttongtien.setText(decimalFormat.format(tongtien));
        txtemail.setText(Utils.user_current.getEmail());
        txtsodt.setText(Utils.user_current.getPhonenumber());



        btndathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_diachi = edtdiachi.getText().toString().trim();
                if(TextUtils.isEmpty(str_diachi) ){
                Toast.makeText(getApplicationContext(), "Bạn chưa nhập địa chỉ!!", Toast.LENGTH_SHORT).show();
                 }else{
                    //post data
                    String str_email = Utils.user_current.getEmail();
                    String str_sdt = Utils.user_current.getPhonenumber();
                    String str_tenKH = Utils.user_current.getUsername();
                    int iduser = Utils.user_current.getId();

                    Log.d("test", new Gson().toJson(Utils.mangmuahang)); //Kiểm tra
                    compositeDisposable.add(apiBanHang.createOrder(iduser,str_email,str_diachi,str_sdt,soluong,String.valueOf(tongtien),new Gson().toJson(Utils.mangmuahang))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    userModel -> {
                                        Toast.makeText(getApplicationContext(),"Đặt hàng thành công!!!",Toast.LENGTH_SHORT).show();
                                        //xao mang gio hang
                                        for(int i=0; i<Utils.mangmuahang.size(); i++){
                                            GioHang gioHang = Utils.mangmuahang.get(i);

                                          //soluong =  Utils.mangmuahang.get(i).getSoluong();
                                            //gioHang.setSoluongkho(sanPhamMoi.getSoluongkho());
                                           // long soluongkho = Long.parseLong(Utils.mangmuahang.get(i).getSoluongkho()) - soluong;
                                            //gioHang.setSoluongkho(String.valueOf(soluongkho));

                                            //gioHang.setSoluong(soluong + gioHang.getSoluong());
                                            long soluongkho = Long.parseLong(gioHang.getSoluongkho()) - soluong;
                                            gioHang.setSoluongkho(String.valueOf(soluongkho));

                                            if(Utils.manggiohang.contains(gioHang)){
                                                Utils.manggiohang.remove(gioHang);
                                            }
                                        }
                                        Utils.mangmuahang.clear();
                                        Paper.book().write("giohang", Utils.manggiohang);
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        //updatesoluongkho();
                                        finish();
                                        },
                                    throwable -> {
                                        Toast.makeText(getApplicationContext(),throwable.getMessage(),Toast.LENGTH_SHORT).show();
                                    }
                            ));
                }
            }
        });
    }
private void updatesoluongkho() {
    GioHang gioHang = new GioHang();
    int soluongkho = Integer.parseInt(gioHang.getSoluongkho());
    // gioHang.setSoluongkho(String.valueOf(soluongkho));
    gioHang.setSoluongkho(String.valueOf(soluongkho - soluong));
}

    private void initView() {
        apiBanHang = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanHang.class);
        toolbar = findViewById(R.id.toobar);
        txttongtien = findViewById(R.id.txttongtien);
        txttenKH = findViewById(R.id.txttenKH);
        txtemail = findViewById(R.id.txtemail);
        txtsodt = findViewById(R.id.txtsodienthoai);
        edtdiachi = findViewById(R.id.editdiachi);
        btndathang = findViewById(R.id.btndathang);
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}