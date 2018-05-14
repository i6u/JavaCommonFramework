package com.witt.dao;

import com.witt.entity.Items;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemsDaoImpl {

    public List<Items> queryItems() {
        List<Items> itemsList = new ArrayList<>();

        Items items1 = new Items();
        items1.setId(110011);
        items1.setName("iPhone x");
        items1.setCreatetime(new Date());
        items1.setPrice(1998F);
        items1.setDetail("ios 12.1");

        Items items2 = new Items();
        items2.setId(110022);
        items2.setName("Galaxy ten");
        items2.setCreatetime(new Date());
        items2.setPrice(2298F);
        items2.setDetail("android 12.1");

        Items items3 = new Items();
        items3.setId(110033);
        items3.setName("OnePlus x");
        items3.setCreatetime(new Date());
        items3.setPrice(1598F);
        items3.setDetail("系统: android P 10.0");

        itemsList.add(items1);
        itemsList.add(items2);
        itemsList.add(items3);


        return itemsList;
    }
}
