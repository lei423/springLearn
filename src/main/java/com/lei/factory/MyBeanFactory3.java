package com.lei.factory;

import com.lei.dao.UserDao;
import com.lei.dao.impl.UserDaoImpl;
import org.springframework.beans.factory.FactoryBean;

/**
 * FactoryBean方式实例化，会规范延迟实例化Bean
 * */
public class MyBeanFactory3 implements FactoryBean<UserDao> {

        @Override
        public UserDao getObject() throws Exception {
                return new UserDaoImpl();
        }

        @Override
        public Class<?> getObjectType() {
                return null;
        }
}
