package com.nicequest.nicequesttest.domain.mappers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class MapperUrlSizeTest {
    private MapperUrlSize mapperUrlSize;

    @Before
    public void setUp() throws Exception {
        mapperUrlSize = new MapperUrlSize();
    }

    @Test
    public void mapTest() throws Exception {
        String urlWithSize = mapperUrlSize.map("https://i.imgur.com/je154sb.gif");
        assertEquals(urlWithSize, "https://i.imgur.com/je154sbm.gif");
    }

}