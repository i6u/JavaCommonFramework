package com.witt.controller;


import com.witt.dao.ItemsDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemsController1 {

    @RequestMapping("/queryItems")
    public ModelAndView queryItems() {
        ItemsDaoImpl itemsDao = new ItemsDaoImpl();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsDao.queryItems());
        modelAndView.setViewName("items/itemsList");
        return modelAndView;
    }
}
