package com.nicequest.nicequesttest.data.network;

public class ApiService {

    private static AuthenticationApiEndPoint mApiEndpointAuthentication;

    public static AuthenticationApiEndPoint getAuthenticationsApiEndPoint(){
        if (mApiEndpointAuthentication==null) {
            mApiEndpointAuthentication = new AuthenticationApiEndPoint();
        }
        return mApiEndpointAuthentication;
    }
}