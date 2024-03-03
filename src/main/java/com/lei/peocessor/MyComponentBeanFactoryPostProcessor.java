package com.lei.peocessor;

import com.lei.utils.BaseClassScanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.util.Map;

public class MyComponentBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {
        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

                //通过扫描工具去扫描指定包及其子包下的所有类，收集使用@MyComponent注解的类
                Map<String, Class> stringClassMap = BaseClassScanUtils.scanMyComponentAnnotation("com.lei");
                //遍历Map，组装BeanDefinition进行注册
                stringClassMap.forEach((beanName, beanClass) -> {
                        //获得beanClassName
                        String name = beanClass.getName();
                        //创建BeanDefinition
                        BeanDefinition beanDefinition = new RootBeanDefinition();
                        beanDefinition.setBeanClassName(name);
                        //注册
                        registry.registerBeanDefinition(beanName, beanDefinition);

                });


        }

        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        }
}
