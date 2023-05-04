package com.manager.appbanhang.retrofit;

import com.manager.appbanhang.model.NotiResponse;
import com.manager.appbanhang.model.NotiSendData;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiPushNofication {
    @Headers(
            {
                    "Content-Type: application/json",
                    "Authorization: key=AAAANoAit4M:APA91bEIMXXd653ZKkTjXZl6KfQEsWxofKbkrip4xkvrKiYHCyY5umkqv8SPbi2M8iwYY6aWhsEAq6Yp97__-0E17oOO0g9eIsL72FI-KpLREDHMtvIiZbgmvAV7PtPk4_WfY5BxMVF6"
            }
    )
    @POST("fcm/send")
    Observable<NotiResponse> sendNofitication(@Body NotiSendData data);
}
