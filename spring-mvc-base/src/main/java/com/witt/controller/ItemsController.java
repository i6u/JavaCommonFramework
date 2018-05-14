package com.witt.controller;

import com.witt.entity.Items;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemsController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

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

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList);
        modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");

        return modelAndView;
    }
}
