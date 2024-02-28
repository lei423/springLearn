package com.lei.service.impl;

import com.lei.dao.UserDao;
import com.lei.service.UserService;
import org.springframework.beans.factory.InitializingBean;

public class UserServiceImpl implements UserService, InitializingBean {

        public void init() {
                System.out.println("初始化中");
        }
        public void destroy() {
                System.out.println("销毁中");
        }
        public UserServiceImpl() {
                System.out.println("UserService实例化");
        }

        public UserServiceImpl(String name) {
                System.out.println("UserService有参构造方法" + name);
        }
        private UserDao userDao;

        //BeanFactory去调用该方法，从容器中获得userDao设置到此处
        public void setUserDao(UserDao userDao) {
                System.out.println("BeanFactory去调用该方法，从容器中获得userDao设置到此处:" + userDao);
                this.userDao = userDao;
        }

        @Override
        public void afterPropertiesSet() throws Exception {
                System.out.println("afterPropertiesSet");
        }
}
