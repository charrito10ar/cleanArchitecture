package com.nicequest.nicequesttest.data.network;

import com.nicequest.nicequesttest.data.bodies.ResponseToken;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AuthenticationApiEndPoint {

    private OAuthInterface mApi;

    public AuthenticationApiEndPoint() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(OAuthInterface.endPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mApi = retrofit.create(OAuthInterface.class);
    }

    public Call<ResponseToken> refreshToken(String refreshToken, String clientId, String clientSecret, String grantType) {
        return mApi.refreshToken(refreshToken, clientId, clientSecret, grantType);
    }
}