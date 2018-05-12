package com.witt.mapper;

import com.witt.pojo.custom.OrdersCustom;

import java.util.List;

public interface OrdersMapperCustom {

    List<OrdersCustom> findOrdersUser() throws Exception;
}
