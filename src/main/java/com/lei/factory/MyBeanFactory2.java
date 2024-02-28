package com.lei.factory;

import com.lei.dao.UserDao;
import com.lei.dao.impl.UserDaoImpl;

/**
 * 实例工厂方式实例
 */
public class MyBeanFactory2 {

        public UserDao userDao(){
                //Bean创建之前可以进行一些其他业务逻辑操作

                return new UserDaoImpl();
        }

}
