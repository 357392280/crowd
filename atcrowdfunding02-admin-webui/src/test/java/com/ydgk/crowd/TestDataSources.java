package com.ydgk.crowd;

import com.ydgk.crowd.entity.Admin;
import com.ydgk.crowd.mapper.AdminMapper;
import com.ydgk.crowd.service.api.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml"})
public class TestDataSources {
    @Autowired
    private DataSource dataSource;

    @Test
    public void testDataSource() throws SQLException {
        // 1.通过数据源对象获取数据源连接
        Connection connection = dataSource.getConnection();
        // 2.打印数据库连接 System.out.println(connection);
        // }
        //System.out.println(connection);

     }

    @Autowired
    private  AdminMapper adminMapper;
    @Test
    public void testAdminMapperAutowired() {
        Admin admin = adminMapper.selectByPrimaryKey(1);
        //System.out.println(admin);
        Logger logger=LoggerFactory.getLogger(TestDataSources.class);
        logger.debug(admin.toString());
        logger.info(
                admin.toString()
        );
//        System.out.println(admin.getEmail());

    }



}


