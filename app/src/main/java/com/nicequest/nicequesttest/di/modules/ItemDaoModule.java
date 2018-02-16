package com.nicequest.nicequesttest.di.modules;

import com.nicequest.nicequesttest.di.ActivityScope;


//@Module
//public class ItemDaoModule {
//    @Provides
//    @ActivityScope
//    public ItemDAO getItemDao(CatsRestAdapter catsRestAdapter){
//        return new ItemDaoImpl(catsRestAdapter);
//    }
//
//    @Provides
//    @ActivityScope
//    Retrofit networkManager() {
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.authenticator(new RetrofitAuthenticator());
//        builder.addInterceptor(chain -> {
//            Request request = chain.request().newBuilder()
//                    .addHeader("Authorization", "Client-ID f17d2424d09ef1c").build();
//            return chain.proceed(request);
//        });
//        OkHttpClient okHttpClient = builder.build();
//
//        return new Retrofit.Builder()
//                .baseUrl("https://api.imgur.com/")
//                .client(okHttpClient)
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//    }
//}
