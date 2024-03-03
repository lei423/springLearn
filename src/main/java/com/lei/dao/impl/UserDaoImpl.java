package com.lei.dao.impl;

import com.lei.dao.UserDao;

public class UserDaoImpl implements UserDao {
        public UserDaoImpl(){
                System.out.println("UserDao实例化");
        }

        public void init(){
                System.out.println("UserDao初始化");
        }
}
