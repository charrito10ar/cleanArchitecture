package com.nicequest.nicequesttest.domain.mappers;


import com.nicequest.nicequesttest.data.network.bodies.Item;
import com.nicequest.nicequesttest.data.network.bodies.ResponseImgur;
import com.nicequest.nicequesttest.domain.model.ItemCat;

import java.util.ArrayList;
import java.util.List;

public class MapperCats implements MapperInterface<ResponseImgur, List<ItemCat>>{

    private List<ItemCat> itemCatEntityList;
    private MapperUrlSize mapperUrlSize;

    public MapperCats() {
        init();
    }

    private void init() {
        itemCatEntityList = new ArrayList<>();
        mapperUrlSize = new MapperUrlSize();
    }

    @Override
    public List<ItemCat> map(ResponseImgur responseImgur) {
        for (Item item: responseImgur.getData().getItems()){
            if(item.getImages() != null){
                if(!mapperUrlSize.map(item.getImages().get(0).getLink()).equals("null")){
                    ItemCat itemCatEntity = new ItemCat(item.getId(), item.getTitle(),
                            mapperUrlSize.map(item.getImages().get(0).getLink()),
                            item.getViews(), item.getImages().get(0).getHeight());
                    itemCatEntityList.add(itemCatEntity);
                }
            }
        }
        return itemCatEntityList;
    }
}
