package com.nicequest.nicequesttest.presentation.display;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.nicequest.nicequesttest.R;

public class LoaderImage implements LoaderImageInterface{
    private static LoaderImage instance;

    public static synchronized LoaderImage getInstance(){
        if(instance == null){
            instance = new LoaderImage();
        }
        return instance;
    }

    @Override
    public void loadCoverMovie(View context, String url, ImageView imageView) {
        Glide.with(context.getContext())
                .load(url)
                .apply(new RequestOptions().placeholder(R.drawable.placeholder_waiting).error(R.drawable.placeholder_waiting))
                .into(imageView);
    }
}