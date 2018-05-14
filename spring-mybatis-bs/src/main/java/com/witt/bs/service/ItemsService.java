package com.witt.bs.service;

import com.witt.bs.entity.ItemsCustom;
import com.witt.bs.entity.ItemsQueryVo;

import java.util.List;

public interface ItemsService {

    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;

    /**
     * @param id
     * @return
     * @throws Exception
     */
    ItemsCustom findItemsById(int id) throws Exception;


    /**
     * @param id
     * @param itemsCustom
     * @throws Exception
     */
    void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;

}
