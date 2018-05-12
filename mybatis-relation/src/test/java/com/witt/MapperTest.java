package com.witt;

import static org.junit.Assert.assertTrue;

import com.witt.mapper.OrdersMapperCustom;
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
public class MapperTest {

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
}
