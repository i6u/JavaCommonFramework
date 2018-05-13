package com.witt.mapper;

import com.witt.pojo.Orders;
import com.witt.pojo.User;
import com.witt.pojo.custom.OrdersCustom;

import java.util.List;

public interface OrdersMapperCustom {

    List<OrdersCustom> findOrdersUser() throws Exception;

    List<Orders> findOrdersUserResultMap() throws Exception;

    List<Orders> findOrdersAndOrderDetailResultMap() throws Exception;

    List<User> findUserAndItemsResultMap() throws Exception;

    List<Orders> findOrdersUserLazyLoading() throws Exception;
}

