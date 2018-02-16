package com.nicequest.nicequesttest.data.network;

public class ApiService {

    private static MetaApiEndPoint mApiEndpoint;
    private static AuthenticationApiEndPoint mApiEndpointAuthentication;

    public ApiService(){}

    public static MetaApiEndPoint getApiEndPoint(){
        if (mApiEndpoint==null) {
            mApiEndpoint = new MetaApiEndPoint();
        }
        return mApiEndpoint;
    }

    public static AuthenticationApiEndPoint getAuthenticationsApiEndPoint(){
        if (mApiEndpointAuthentication==null) {
            mApiEndpointAuthentication = new AuthenticationApiEndPoint();
        }
        return mApiEndpointAuthentication;
    }
}