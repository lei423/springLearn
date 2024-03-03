package com.lei.peocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;
import java.util.Date;

public class TimeLogBeanPostPocessor implements BeanPostProcessor {
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

                //使用动态代理对目标Bean进行增强，返回proxy对象，进而存储到单例池singletonObjects中
                Object beanProxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(),
                        bean.getClass().getInterfaces(),
                        (o, method, objects) -> {
                                //1.输出开始时间
                                System.out.println("方法：" + method.getName() + "-开始时间：" + new Date());
                                //2.执行目标方法
                                Object invoke = method.invoke(bean, objects);
                                //3.输出结束时间
                                System.out.println("方法：" + method.getName() + "-结束时间：" + new Date());
                                return invoke;
                        });


                return beanProxy;
        }
}
