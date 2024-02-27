package com.lei.service.impl;

import com.lei.dao.UserDao;
import com.lei.service.UserService;

public class UserServiceImpl implements UserService {

        public UserServiceImpl() {
                System.out.println("UserService实例化");
        }
        private UserDao userDao;

        //BeanFactory去调用该方法，从容器中获得userDao设置到此处
        public void setUserDao(UserDao userDao) {
                System.out.println("BeanFactory去调用该方法，从容器中获得userDao设置到此处:" + userDao);
                this.userDao = userDao;
        }
}
