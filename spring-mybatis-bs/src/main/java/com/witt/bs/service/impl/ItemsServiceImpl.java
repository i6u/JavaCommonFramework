package com.witt.bs.service.impl;

import com.witt.bs.dao.ItemsCustomDao;
import com.witt.bs.dao.ItemsDao;
import com.witt.bs.entity.Items;
import com.witt.bs.entity.ItemsCustom;
import com.witt.bs.entity.ItemsQueryVo;
import com.witt.bs.service.ItemsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsCustomDao itemsCustomDao;
    @Autowired
    private ItemsDao itemsDao;

    @Override
    public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception {
        return itemsCustomDao.findItemsList(itemsQueryVo);
    }

    @Override
    public ItemsCustom findItemsById(int id) throws Exception {
        Items items = itemsDao.selectByPrimaryKey(id);
        //TODO
        ItemsCustom itemsCustom = new ItemsCustom();
        BeanUtils.copyProperties(items, itemsCustom);
        return itemsCustom;
    }

    @Override
    public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {

        if (id == null) {
            throw new RuntimeException("id 不能为空...");
        }
        itemsCustom.setId(id);
        itemsDao.updateByPrimaryKeyWithBLOBs(itemsCustom);
    }
}
