package com.nicequest.nicequesttest.domain.mappers;


import com.nicequest.nicequesttest.domain.model.ItemCat;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MapperCatsTest {

    private List<ItemCat> itemCatEntityList;
    private ResponseImgurStub responseImgurStub;
    private MapperCats mapperCats;
    private MapperUrlSize mapperUrlSize;

    @Before
    public void setUp() throws Exception {
        mapperCats = new MapperCats();
        itemCatEntityList = new ArrayList<>();
        responseImgurStub = new ResponseImgurStub();
        mapperUrlSize = new MapperUrlSize();
    }

    @Test
    public void mapSizeListTest() throws Exception {
        itemCatEntityList = mapperCats.map(responseImgurStub);
        assertEquals(itemCatEntityList.size(), responseImgurStub.getData().getItems().size());
    }

    @Test
    public void mapIdContentListTest() throws Exception {
        itemCatEntityList = mapperCats.map(responseImgurStub);
        assertEquals(itemCatEntityList.get(0).getId(), responseImgurStub.getData().getItems().get(0).getId());
    }

    @Test
    public void mapTitleContentListTest() throws Exception {
        itemCatEntityList = mapperCats.map(responseImgurStub);
        assertEquals(itemCatEntityList.get(0).getTitle(), responseImgurStub.getData().getItems().get(0).getTitle());
    }

    /**
     * Verify that first image from data model set in domain model
     * @throws Exception
     */
    @Test
    public void mapFirstImageContentListTest() throws Exception {
        itemCatEntityList = mapperCats.map(responseImgurStub);
        assertEquals(itemCatEntityList.get(0).getUrl(), mapperUrlSize.map(responseImgurStub.getData().getItems().get(0).getImages().get(0).getLink()));
    }


}