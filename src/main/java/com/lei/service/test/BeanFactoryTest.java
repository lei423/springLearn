package com.lei.service.test;

import com.lei.dao.UserDao;
import com.lei.service.UserService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class BeanFactoryTest {
        public static void main(String[] args) {
                /**
                 * BeanFactory的开发步骤：
                 * 1）导入Spring的jar包或Maven坐标
                 * 2）定义UserService接口及其UserServiceImpl实现类
                 * 3）创建beans.xml配置文件，将UserServiceImpl的信息配置到该xml中
                 * 4）编写测试代码，创建BeanFactory，加载配置文件，获得UserService实例对象
                 */

                /**
                 * 实现DI依赖注入：
                 * 1）定义UserDao接口及其UserDaoImpl实现类
                 * 2）修改UserServiceImpl代码，添加一个setUserDao(UserDao userDao)用于接受注入的对象
                 * 3）修改beans.xml配置文件，在UserDaoImplDE的<bean>中嵌入<property>配置注入
                 * 4）修改测试代码，获得UserService时，setUserServifce方法执行了注入操作
                 */

                //创建工厂对象
                DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

                //创建一个读取器(xml)对象
                XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

                //读取器绑定工厂
                xmlBeanDefinitionReader.loadBeanDefinitions("beans.xml");

                //根据id获取Bean实例对象
                UserService userService = (UserService) defaultListableBeanFactory.getBean("userService");
                System.out.println(userService);

                UserDao userdao = (UserDao) defaultListableBeanFactory.getBean("userDao");
                System.out.println(userdao);

        }
}
