package com.lei.peocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * BeanFactoryPostProcessor：Bean工厂后处理器，在BeanDefinitionMap填充完毕，Bean实例化之前执行；
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                System.out.println("MyBeanFactoryPostProcessor");

                //修改某个BeanDefinition
                //BeanDefinition userService = beanFactory.getBeanDefinition("userService");
                //userService.setBeanClassName("com.lei.dao.impl.UserDaoImpl");

                //注册Definition
                BeanDefinition beanDefinition = new RootBeanDefinition("com.lei.dao.impl.PersonDaoImpl");
                //强转成DefaultListableBeanFactory
                DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;
                defaultListableBeanFactory.registerBeanDefinition("userDao", beanDefinition);

        }
}
