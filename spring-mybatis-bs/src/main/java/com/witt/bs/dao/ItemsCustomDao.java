package com.witt.bs.dao;

import com.witt.bs.entity.ItemsCustom;
import com.witt.bs.entity.ItemsQueryVo;

import java.util.List;

public interface ItemsCustomDao {

    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}

