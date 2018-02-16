package com.nicequest.nicequesttest.data.network

import com.nicequest.nicequesttest.data.bodies.ResponseToken
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST

interface OAuthInterface {
    @POST("oauth2/token")
    fun refreshToken(@Field("refresh_token") refreshToken: String,
                     @Field("client_id") clientId: String,
                     @Field("client_secret") clientSecret: String,
                     @Field("grant_type") grantType: String): Call<ResponseToken>

    companion object {
        const val refreshToken: String = "eaf967453831e3696067868364d0b4ee128a7337"
        const val clientId: String = "f17d2424d09ef1c"
        const val clientSecret: String = "104214f360ba4fbab63fd6870fa2bec017a52e1c"
        const val grantType: String = "refresh_token"
        const val endPoint: String = "https://api.imgur.com/"
    }
}