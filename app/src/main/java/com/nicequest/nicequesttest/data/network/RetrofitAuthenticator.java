package com.nicequest.nicequesttest.data.network;


import android.support.annotation.NonNull;

import com.marcelo.privalia.moviesapp.data.network.interfaces.RetrofitImageService;
import com.nicequest.nicequesttest.data.bodies.ResponseToken;

import org.json.JSONObject;

import java.io.IOException;

import javax.annotation.Nullable;

import io.reactivex.Observable;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Call;

/**
 * When response is 401 this authentication is executed.
 * Here we could save the access token for use it in queries that require it
 *
 */

public class RetrofitAuthenticator implements Authenticator{

    @Nullable
    @Override
    public Request authenticate(@NonNull Route route, @NonNull Response response) throws IOException {

        Call<ResponseToken> jsonObjectCall =  ApiService.
                getAuthenticationsApiEndPoint().refreshToken(OAuthInterface.refreshToken,
                OAuthInterface.clientId, OAuthInterface.clientSecret, OAuthInterface.grantType);

        retrofit2.Response<ResponseToken> responseTokenResponse = jsonObjectCall.execute();

        if(responseTokenResponse.code() == 200){
            //String newAccessToken = responseTokenResponse.body().getAccess_token();
            //Save newAccessToken
            return response.request().newBuilder()
                    .build();
        }else {
            return response.request().newBuilder()
                    .build();
        }
    }
}
