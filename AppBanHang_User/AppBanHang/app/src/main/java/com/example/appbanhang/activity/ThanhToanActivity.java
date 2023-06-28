package com.example.appbanhang.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appbanhang.R;
import com.example.appbanhang.model.CreateOrder;
import com.example.appbanhang.model.GioHang;
import com.example.appbanhang.model.NotiSendData;
import com.example.appbanhang.retrofit.ApiBanHang;
import com.example.appbanhang.retrofit.ApiPushNofication;
import com.example.appbanhang.retrofit.RetrofitClient;
import com.example.appbanhang.retrofit.RetrofitClientNoti;
import com.example.appbanhang.utils.Utils;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import io.paperdb.Paper;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import vn.momo.momo_partner.AppMoMoLib;
import vn.zalopay.sdk.Environment;
import vn.zalopay.sdk.ZaloPayError;
import vn.zalopay.sdk.ZaloPaySDK;
import vn.zalopay.sdk.listeners.PayOrderListener;

public class ThanhToanActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView txttongtien, txtsodt, txtemail,txttenKH;
    EditText edtdiachi;
    ImageView btnzalopay, btnmomo;
    AppCompatButton btndathang;//btnzalopay
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiBanHang apiBanHang;
    long tongtien;
    int soluong;
    int iddonhang;

    private String amount = "10000";
    private String fee = "0";
    int environment = 0;//developer default
    private String merchantName = "HoangNgoc";
    private String merchantCode = "MOMOC2IC20220510";
    private String merchantNameLabel = "HoangNgoc";
    private String description = "Mua hàng online";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);
        //momo
        AppMoMoLib.getInstance().setEnvironment(AppMoMoLib.ENVIRONMENT.DEVELOPMENT); // AppMoMoLib.ENVIRONMENT.PRODUCTION

        //zalopay
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        // ZaloPay SDK Init
        ZaloPaySDK.init(2554, Environment.SANDBOX);

        initView();
        countItem();
        initControl();
    }

    private void countItem() {
        soluong = 0;
        for(int i=0; i<Utils.mangmuahang.size(); i++){
            soluong = soluong+ Utils.mangmuahang.get(i).getSoluong();
        }
    }

    //Get token through MoMo app
    private void requestPayment(String iddonhang) {
        AppMoMoLib.getInstance().setAction(AppMoMoLib.ACTION.PAYMENT);
        AppMoMoLib.getInstance().setActionType(AppMoMoLib.ACTION_TYPE.GET_TOKEN);

        Map<String, Object> eventValue = new HashMap<>();
        //client Required
        eventValue.put("merchantname", merchantName); //Tên đối tác. được đăng ký tại https://business.momo.vn. VD: Google, Apple, Tiki , CGV Cinemas
        eventValue.put("merchantcode", merchantCode); //Mã đối tác, được cung cấp bởi MoMo tại https://business.momo.vn
        eventValue.put("amount", amount); //Kiểu integer
        eventValue.put("orderId", iddonhang); //uniqueue id cho Bill order, giá trị duy nhất cho mỗi đơn hàng
        eventValue.put("orderLabel", iddonhang); //gán nhãn

        //client Optional - bill info
        eventValue.put("merchantnamelabel", "Dịch vụ");//gán nhãn
        eventValue.put("fee", "0"); //Kiểu integer
        eventValue.put("description", description); //mô tả đơn hàng - short description

        //client extra data
        eventValue.put("requestId",  merchantCode+"merchant_billId_"+System.currentTimeMillis());
        eventValue.put("partnerCode", merchantCode);
        //Example extra data
        JSONObject objExtraData = new JSONObject();
        try {
            objExtraData.put("site_code", "008");
            objExtraData.put("site_name", "CGV Cresent Mall");
            objExtraData.put("screen_code", 0);
            objExtraData.put("screen_name", "Special");
            objExtraData.put("movie_name", "Kẻ Trộm Mặt Trăng 3");
            objExtraData.put("movie_format", "2D");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        eventValue.put("extraData", objExtraData.toString());

        eventValue.put("extra", "");
        AppMoMoLib.getInstance().requestMoMoCallBack(this, eventValue);


    }
    //Get token callback from MoMo app an submit to server side
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == AppMoMoLib.getInstance().REQUEST_CODE_MOMO && resultCode == -1) {
            if(data != null) {
                if(data.getIntExtra("status", -1) == 0) {
                    //TOKEN IS AVAILABLE
                    Log.d("thanhcong", data.getStringExtra("message"));
                    String token = data.getStringExtra("data"); //Token response
                    compositeDisposable.add(apiBanHang.updateMomo(iddonhang, token)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    messageModel -> {
                                        if (messageModel.isSuccess()){
                                            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    },
                                    throwable -> {
                                        Log.d("erro", throwable.getMessage());
                                    }
                            ));


                    String phoneNumber = data.getStringExtra("phonenumber");
                    String env = data.getStringExtra("env");
                    if(env == null){
                        env = "app";
                    }

                    if(token != null && !token.equals("")) {
                        // TODO: send phoneNumber & token to your server side to process payment with MoMo server
                        // IF Momo topup success, continue to process your order
                    } else {
                        Log.d("thanhcong","khong thanh cong" );
                    }
                } else if(data.getIntExtra("status", -1) == 1) {
                    //TOKEN FAIL
                    String message = data.getStringExtra("message") != null?data.getStringExtra("message"):"Thất bại";
                    Log.d("thanhcong","khong thanh cong" );
                } else if(data.getIntExtra("status", -1) == 2) {
                    //TOKEN FAIL
                    Log.d("thanhcong","khong thanh cong" );
                } else {
                    //TOKEN FAIL
                    Log.d("thanhcong","khong thanh cong" );
                }
            } else {
                Log.d("thanhcong","khong thanh cong" );
            }
        } else {
            Log.d("thanhcong","khong thanh cong" );
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
        txttongtien.setText(decimalFormat.format(tongtien));
        txttenKH.setText(Utils.user_current.getUsername());
        txtemail.setText(Utils.user_current.getEmail());
        txtsodt.setText(Utils.user_current.getPhonenumber());


        btndathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_diachi = edtdiachi.getText().toString().trim();
                if(TextUtils.isEmpty(str_diachi)){
                Toast.makeText(getApplicationContext(), "Bạn chưa nhập địa chỉ!!", Toast.LENGTH_SHORT).show();
                 }else{
                    //post data
                    String str_email = Utils.user_current.getEmail();
                    String str_sdt = Utils.user_current.getPhonenumber();
                    int iduser = Utils.user_current.getId();

                    Log.d("test", new Gson().toJson(Utils.mangmuahang)); //Kiểm tra
                    compositeDisposable.add(apiBanHang.createOrder(iduser,str_email,str_diachi,str_sdt,soluong,String.valueOf(tongtien),new Gson().toJson(Utils.mangmuahang))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    messageModel -> {
                                        //gui thong bao
                                        pushNotiToUser();
                                        Toast.makeText(getApplicationContext(),"Đặt hàng thành công!!!",Toast.LENGTH_SHORT).show();
                                        //xao mang gio hang
                                        for(int i=0; i<Utils.mangmuahang.size(); i++){
                                            GioHang gioHang = Utils.mangmuahang.get(i);
                                            if(Utils.manggiohang.contains(gioHang)){
                                                Utils.manggiohang.remove(gioHang);
                                            }
                                        }
                                        Utils.mangmuahang.clear();
                                        Paper.book().write("giohang", Utils.manggiohang);
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                        },
                                    throwable -> {
                                        Toast.makeText(getApplicationContext(),throwable.getMessage(),Toast.LENGTH_SHORT).show();
                                    }
                            ));
                }
            }
        });

        btnzalopay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_diachi = edtdiachi.getText().toString().trim();
                if(TextUtils.isEmpty(str_diachi)){
                    Toast.makeText(getApplicationContext(), "Bạn chưa nhập địa chỉ!!", Toast.LENGTH_SHORT).show();
                }else{
                    //post data
                    String str_email = Utils.user_current.getEmail();
                    String str_sdt = Utils.user_current.getPhonenumber();
                    int iduser = Utils.user_current.getId();
                    Log.d("test", new Gson().toJson(Utils.mangmuahang)); //Kiểm tra
                    compositeDisposable.add(apiBanHang.createOrder(iduser,str_email,str_diachi,str_sdt,soluong,String.valueOf(tongtien),new Gson().toJson(Utils.mangmuahang))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    messageModel -> {
                                        //gui thong bao
                                        pushNotiToUser();
                                        //Toast.makeText(getApplicationContext(),"Đặt hàng thành công!!!",Toast.LENGTH_SHORT).show();
                                        for(int i=0; i<Utils.mangmuahang.size(); i++){
                                            GioHang gioHang = Utils.mangmuahang.get(i);
                                            if(Utils.manggiohang.contains(gioHang)){
                                                Utils.manggiohang.remove(gioHang);
                                            }
                                        }
                                        Utils.mangmuahang.clear();
                                        Paper.book().write("giohang", Utils.manggiohang);
                                        iddonhang = Integer.parseInt(messageModel.getIddonhang());
                                        requestZalo();
                                    },
                                    throwable -> {
                                        Log.d("error",throwable.getMessage());
                                    }
                            ));
                }
            }
        });
        btnmomo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_diachi =edtdiachi.getText().toString().trim();
                if (TextUtils.isEmpty(str_diachi)){
                    Toast.makeText(getApplicationContext(), "Bạn chưa nhập địa chỉ", Toast.LENGTH_SHORT).show();
                }else {
                    //post data
                    String str_email=Utils.user_current.getEmail();
                    String str_sdt= Utils.user_current.getPhonenumber();
                    int id=Utils.user_current.getId();
                    Log.d("test", new Gson().toJson(Utils.mangmuahang));
                    compositeDisposable.add(apiBanHang.createOrder(id,str_email,str_diachi,str_sdt,soluong,String.valueOf(tongtien),new Gson().toJson(Utils.mangmuahang))
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    messageModel -> {
                                        pushNotiToUser();
                                       // Toast.makeText(getApplicationContext(),"Đặt hàng thành công", Toast.LENGTH_SHORT).show();
                                        //clear manggiohang bang cach chay qua mangmuahang va clear item trung
                                        for (int i=0;i<Utils.mangmuahang.size(); i++){
                                            GioHang gioHang = Utils.mangmuahang.get(i);
                                            if (Utils.mangmuahang.contains(gioHang)){
                                                Utils.manggiohang.remove(gioHang);
                                            }
                                        }
                                        Utils.mangmuahang.clear();
                                        iddonhang= Integer.parseInt(messageModel.getIddonhang());
                                        requestPayment(messageModel.getIddonhang());

                                    },
                                    throwable -> {
                                        Toast.makeText(getApplicationContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                            ));
                }
            }
        });
    }

    private void requestZalo() {
        CreateOrder orderApi = new CreateOrder();
        try {
            JSONObject data = orderApi.createOrder("100000");
            String code = data.getString("return_code");
            Log.d("test", code);
            if (code.equals("1")) {
                String token = data.getString("zp_trans_token");
                Log.d("test", token);

                ZaloPaySDK.getInstance().payOrder(ThanhToanActivity.this, token, "demozpdk://app", new PayOrderListener() {
                    @Override
                    public void onPaymentSucceeded(String s, String s1, String s2) {
                        compositeDisposable.add(apiBanHang.updateZalopay(iddonhang, token)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(
                                        messageModel -> {
                                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                            startActivity(intent);
                                            finish();
                                        },
                                        throwable -> {
                                            Log.d("error",throwable.getMessage());
                                        }
                                ));
                    }

                    @Override
                    public void onPaymentCanceled(String s, String s1) {

                    }

                    @Override
                    public void onPaymentError(ZaloPayError zaloPayError, String s, String s1) {

                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pushNotiToUser() {
        //getToken
        compositeDisposable.add(apiBanHang.gettoken(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        userModel -> {
                            if(userModel.isSuccess()){
                                for(int i = 0; i<userModel.getResult().size();i++){
                                    Map<String, String> data = new HashMap<>();
                                    data.put("title","Thông báo");
                                    data.put("body","Bạn có đơn hàng mới.");
                                    NotiSendData notiSendData = new NotiSendData(userModel.getResult().get(i).getToken(),data);
                                    ApiPushNofication apiPushNofication = RetrofitClientNoti.getInstance().create(ApiPushNofication.class);
                                    compositeDisposable.add(apiPushNofication.sendNofitication(notiSendData)
                                            .subscribeOn(Schedulers.io())
                                            .observeOn(AndroidSchedulers.mainThread())
                                            .subscribe(
                                                    notiResponse -> {

                                                    },
                                                    throwable -> {
                                                        Log.d("log",throwable.getMessage());

                                                    }
                                            ));
                                }
                            }
                        },
                        throwable -> {
                            Log.d("log", throwable.getMessage());

                        }
                ));
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
        btnzalopay = findViewById(R.id.imgzalopay);
        btnmomo=findViewById(R.id.imgmomo);
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ZaloPaySDK.getInstance().onResult(intent);
    }
}