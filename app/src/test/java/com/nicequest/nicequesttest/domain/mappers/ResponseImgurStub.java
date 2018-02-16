package com.nicequest.nicequesttest.domain.mappers;


import com.nicequest.nicequesttest.data.network.bodies.Data;
import com.nicequest.nicequesttest.data.network.bodies.Image;
import com.nicequest.nicequesttest.data.network.bodies.Item;
import com.nicequest.nicequesttest.data.network.bodies.ResponseImgur;

import java.util.ArrayList;
import java.util.List;

public class ResponseImgurStub extends ResponseImgur{


    public ResponseImgurStub(){
        super(null, true, 200);
        this.initData();
    }

    public void initData(){
        List<Item> itemList = getItems();
        Data data = new Data("name",itemList);
        this.setData(data);
    }

    private List<Image> getImages(){
        List<Image> imageList = new ArrayList<>();
        for(int i=0; i<4; i++){
            Image image = new Image("id-" + i, "png",100, "null");
            imageList.add(image);
        }
        return imageList;
    }

    private List<Item> getItems(){
        List<Item> itemList = new ArrayList<>();
        for(int i=0; i<4; i++){
            Item item = new Item("itemId-" + i, "title", i, getImages());
            itemList.add(item);
        }
        return itemList;
    }
}
