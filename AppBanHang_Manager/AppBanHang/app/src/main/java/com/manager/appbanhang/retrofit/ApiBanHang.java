package com.manager.appbanhang.retrofit;

import com.manager.appbanhang.model.ChiTietDonHangModel;
import com.manager.appbanhang.model.DonHangModel;
import com.manager.appbanhang.model.LoaiSpModel;
import com.manager.appbanhang.model.MessageModel;
import com.manager.appbanhang.model.SanPhamMoiModel;
import com.manager.appbanhang.model.ThongKeModel;
import com.manager.appbanhang.model.ThongtinchitietKH;
import com.manager.appbanhang.model.UserModel;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiBanHang {
    @GET("getloaisp.php")
    Observable<LoaiSpModel> getLoaiSp();

    @GET("getspmoi.php")
    Observable<SanPhamMoiModel> getSpMoi();

    @GET("thongke.php")
    Observable<ThongKeModel> getthongke();

    @GET("thongkethang.php")
    Observable<ThongKeModel> getthongkeThang();

    @GET("thongkebanchay.php")
    Observable<ChiTietDonHangModel> getthongkeBanChay();

    @GET("thongtinchitietKH.php")
    Observable<ThongtinchitietKH> getthongtinchitietKH();

    @POST("chitiet.php")
    @FormUrlEncoded
    Observable<SanPhamMoiModel> getSanPham(
            @Field("page") int page,
            @Field("loai") int loai
    );

    @POST("dangki.php")
    @FormUrlEncoded
    Observable<UserModel> dangKi(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password,
            @Field("phonenumber") String phonenumber,
            @Field("uid") String uid
    );

    @POST("dangnhap.php")
    @FormUrlEncoded
    Observable<UserModel> dangNhap(
            @Field("email") String email,
            @Field("password") String password
    );

    @POST("resetpass.php")
    @FormUrlEncoded
    Observable<UserModel> resetPass(
            @Field("email") String email
    );

    @POST("donhang.php")
    @FormUrlEncoded
    Observable<UserModel> createOrder(
            @Field("iduser") int iduser,
            @Field("email") String email,
            @Field("diachi") String diachi,
            @Field("sodienthoai") String sodienthoai,
            @Field("soluong") int soluong,
            @Field("tongtien") String tongtien,
          //  @Field("tenKH") String tenKH,
            @Field("chitiet") String chitiet
    );

    @POST("lichsudonhang.php")
    @FormUrlEncoded
    Observable<DonHangModel> LsDonHang(
            @Field("iduser") int iduser
    );

    @POST("timkiem.php")
    @FormUrlEncoded
    Observable<SanPhamMoiModel> search(
            @Field("search") String search
    );

    @POST("xoasp.php")
    @FormUrlEncoded
    Observable<MessageModel> xoaSanPham(
            @Field("id") int id
    );

    @POST("themsp.php")
    @FormUrlEncoded
    Observable<MessageModel> themSp(
            @Field("tensanpham") String tensanpham,
            @Field("gia") String gia,
            @Field("hinhanh") String hinhanh,
            @Field("mota") String mota,
            @Field("loai") int id
    );

    @POST("suasp.php")
    @FormUrlEncoded
    Observable<MessageModel> suaSanPham(
            @Field("tensanpham") String tensanpham,
            @Field("giasp") String gia,
            @Field("hinhanh") String hinhanh,
            @Field("mota") String mota,
            @Field("loai") int idloai,
            @Field("id") int id
    );

    @POST("updatetoken.php")
    @FormUrlEncoded
    Observable<MessageModel> updateToken(
            @Field("id") int id,
            @Field("token") String token

    );

    @POST("updateDonHang.php")
    @FormUrlEncoded
    Observable<MessageModel> updatedonhang(
            @Field("id") int id,
            @Field("tinhtrang") int tinhtrang

    );

    @Multipart
    @POST("uploadimg.php")
    Call<MessageModel> uploadFile(@Part MultipartBody.Part file);

    @POST("gettoken.php")
    @FormUrlEncoded
    Observable<UserModel> gettoken(
            @Field("status") int status,
             @Field("iduser") int iduser
    );
}
