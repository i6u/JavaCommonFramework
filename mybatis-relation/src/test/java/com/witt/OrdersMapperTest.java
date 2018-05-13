package com.witt;

import static org.junit.Assert.assertTrue;

import com.witt.mapper.OrdersMapperCustom;
import com.witt.pojo.Orders;
import com.witt.pojo.User;
import com.witt.pojo.custom.OrdersCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class OrdersMapperTest {

    SqlSession sqlSession = null;
    OrdersMapperCustom ordersMapper = null;

    @Before
    public void setUp() throws IOException {

        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        sqlSession = factory.openSession();
        ordersMapper = sqlSession.getMapper(OrdersMapperCustom.class);
    }

    @After
    public void finish() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void findOrdersUserTest() throws Exception {

        List<OrdersCustom> ordersCustoms = ordersMapper.findOrdersUser();

        for (OrdersCustom ordersCustom : ordersCustoms) {
            System.out.println(ordersCustom);
        }
    }

    @Test
    public void findOrdersUserResultMapTest() throws Exception {
        List<Orders> orders = ordersMapper.findOrdersUserResultMap();
        for (Orders order : orders) {
            System.out.println(order.toString());
        }
    }

    @Test
    public void findOrdersAndOrderDetailResultMapTest() throws Exception {
        List<Orders> orders = ordersMapper.findOrdersAndOrderDetailResultMap();
        for (Orders order : orders) {
            System.out.println(order.toString());
        }
    }

    @Test
    public void findUserAndItemsResultMapTest() throws Exception {
        List<User> users = ordersMapper.findUserAndItemsResultMap();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void findOrdersUserLazyLoadingTest() throws Exception {
        List<Orders> orders = ordersMapper.findOrdersUserLazyLoading();
        for (Orders order : orders) {
            //System.out.println(order.getUser());
            System.out.println(order);
        }
    }
}
