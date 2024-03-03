package com.lei.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.lei.beans.OtherBean;
import com.lei.dao.PersonDao;
import com.lei.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;

public class ApplicationContextTest {
        public static void main(String[] args) {

                /**
                 * BeanFactory与ApplicationContext的关系
                 * 1）BeanFactory是Spring的早期接口，称为Spring的Bean工厂，ApplicationContext是后期更高级接口，称之为
                 * Spring 容器；
                 * 2）ApplicationContext在BeanFactory基础上对功能进行了扩展，例如：监听功能、国际化功能等。BeanFactory的
                 * API更偏向底层，ApplicationContext的API大多数是对这些底层API的封装；
                 * 3）Bean创建的主要逻辑和功能都被封装在BeanFactory中，ApplicationContext不仅继承了BeanFactory，而且
                 * ApplicationContext内部还维护着BeanFactory的引用，所以，ApplicationContext与BeanFactory既有继承关系，又
                 * 有融合关系。
                 * 4）Bean的初始化时机不同，原始BeanFactory是在首次调用getBean时才进行Bean的创建，而ApplicationContext则
                 * 是配置文件加载，容器一创建就将Bean都实例化并初始化好。
                 */

                /**
                 * Bean 实例化的基本流程
                 * Spring容器在进行初始化时，会将xml配置的<bean>的信息封装成一个BeanDefinition对象，所有的
                 * BeanDefinition存储到一个名为beanDefinitionMap的Map集合中去，Spring框架在对该Map进行遍历，使用反
                 * 射创建Bean实例对象，创建好的Bean对象存储在一个名为singletonObjects的Map集合中，当调用getBean方法
                 * 时则最终从该Map集合中取出Bean实例对象返回
                 */

                //ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("applicationContext.xml");
                ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

                //构造方式实例化
//                UserService userService = (UserService) applicationContext.getBean("userService");
//                System.out.println(userService);

                UserService userService = applicationContext.getBean("userService", UserService.class);
                System.out.println(userService);

                //静态工厂方式实例化
                Object userDao1 = applicationContext.getBean("userDao1");
                System.out.println(userDao1);

                //实例工厂方式实例化
//                Object userDao2 = applicationContext.getBean("userDao2");
//                System.out.println(userDao2);

                //FactoryBean方式实例化
                Object userDao3 = applicationContext.getBean("userDao3");
                System.out.println(userDao3);

                DruidDataSource druidDataSource = new DruidDataSource();

                PersonDao personDao = applicationContext.getBean(PersonDao.class);
                System.out.println(personDao);

                //自定义注解
//                OtherBean bean = applicationContext.getBean(OtherBean.class);
//                System.out.println(bean);

                applicationContext.close();
        }
}
