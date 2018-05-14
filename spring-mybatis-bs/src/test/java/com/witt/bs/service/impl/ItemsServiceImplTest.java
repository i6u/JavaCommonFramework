package com.witt.bs.service.impl;

import com.witt.bs.BaseTest;
import com.witt.bs.service.ItemsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class ItemsServiceImplTest extends BaseTest {

    @Autowired
    private ItemsService itemsService;
    @Test
    public void findItemsList() throws Exception {
        itemsService.findItemsList(null);
    }
}