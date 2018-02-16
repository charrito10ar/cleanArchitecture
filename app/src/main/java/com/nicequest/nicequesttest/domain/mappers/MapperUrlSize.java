package com.nicequest.nicequesttest.domain.mappers;


public class MapperUrlSize implements MapperInterface<String, String> {

    @Override
    public String map(String originalUrl) {
        String urlWithOutExtension = originalUrl.substring(0, originalUrl.length() - 4);
        return urlWithOutExtension + "m" + originalUrl.substring(urlWithOutExtension.length()) ;
    }
}
