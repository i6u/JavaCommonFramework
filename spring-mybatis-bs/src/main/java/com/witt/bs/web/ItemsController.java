package com.witt.bs.web;

import com.witt.bs.entity.ItemsCustom;
import com.witt.bs.entity.ItemsQueryVo;
import com.witt.bs.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/item")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping(value = "/queryItems", method = RequestMethod.GET)
    public String queryItems(Model model) throws Exception {
        ItemsQueryVo vo = new ItemsQueryVo();
        ItemsCustom items = new ItemsCustom();
        items.setName("");
        vo.setItemsCustom(items);
        List<ItemsCustom> itemsCustomList = itemsService.findItemsList(vo);
        model.addAttribute("itemsList", itemsCustomList);
        return "items/itemsList";
    }

    @RequestMapping("/editItems")
    public String editItems(Model model, @RequestParam(value = "id") Integer id) throws Exception {

        ItemsCustom item = itemsService.findItemsById(id);
        model.addAttribute("items", item);

        return "items/editItems";
    }

    @RequestMapping(value = "/editItemsSubmit", method = RequestMethod.POST)
    public String editItemsSubmit(@RequestParam(value = "id") Integer id, ItemsCustom items) throws Exception {

        itemsService.updateItems(id, items);
        // forward redirect
        return "redirect:queryItems";
    }

}
