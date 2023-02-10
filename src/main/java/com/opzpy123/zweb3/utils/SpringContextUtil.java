package com.opzpy123.zweb3.utils;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class SpringContextUtil {
    private static ApplicationContext APPLICATION_CONTEXT; // Spring应用上下文环境

    public static void init(ApplicationContext applicationContext) {
        APPLICATION_CONTEXT = applicationContext;
    }

    /**
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return APPLICATION_CONTEXT;
    }

    /**
     * 获取类型为requiredType的对象
     * 如果bean不能被类型转换，相应的异常将会被抛出（BeanNotOfRequiredTypeException）
     *
     * @param name         bean注册名
     * @param requiredType 返回对象类型
     * @return Object 返回requiredType类型对象
     * @throws BeansException
     */
    public static <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return APPLICATION_CONTEXT.getBean(name, requiredType);
    }

    /**
     * 获取指定名称的容器内对象，一般不应该经常使用，而应该使用有类型的版本
     *
     * @param name bean注册名
     * @return Object 返回requiredType类型对象
     * @throws BeansException
     */
    public static Object getBean(String name) throws BeansException {
        return APPLICATION_CONTEXT.getBean(name);
    }

    /**
     * 获取类型为Class<T>的managed bean
     *
     * @param <T>
     * @param requiredType
     * @return
     */
    public static <T> T getBean(Class<T> requiredType) {
        return APPLICATION_CONTEXT.getBean(requiredType);
    }

    /**
     * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     *
     * @param name
     * @return boolean
     */
    public static boolean containsBean(String name) {
        return APPLICATION_CONTEXT.containsBean(name);
    }

    /**
     * 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
     * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
     *
     * @param name
     * @return boolean
     * @throws NoSuchBeanDefinitionException
     */
    public static boolean isSingleton(String name) throws NoSuchBeanDefinitionException {
        return APPLICATION_CONTEXT.isSingleton(name);
    }

    /**
     * @param name
     * @return Class 注册对象的类型
     * @throws NoSuchBeanDefinitionException
     */
    public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {
        return APPLICATION_CONTEXT.getType(name);
    }

    /**
     * 如果给定的bean名字在bean定义中有别名，则返回这些别名
     *
     * @param name
     * @return
     * @throws NoSuchBeanDefinitionException
     */
    public static String[] getAliases(String name) throws NoSuchBeanDefinitionException {
        return APPLICATION_CONTEXT.getAliases(name);
    }

    /**
     * 在Spring AOP情况下，可能获取到的是Dynamic Proxy类对象，需要转换成实际的类对象
     *
     * @param proxy proxy
     * @return obj
     */
    public static Object getRealInstance(Object proxy) throws RuntimeException {
        if (AopUtils.isJdkDynamicProxy(proxy) || AopUtils.isCglibProxy(proxy)) {
            try {
                return ((Advised) proxy).getTargetSource().getTarget();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return proxy;
    }

    public static String getServiceName(Class<?> beanClass) throws RuntimeException {
        String serviceName = null;
        try {
            Service serviceAnnotation = beanClass.getAnnotation(Service.class);
            if (serviceAnnotation != null) {
                serviceName = serviceAnnotation.value();
            }

            if (serviceName == null) {
                Component componentAnnotation = beanClass.getAnnotation(Component.class);
                if (componentAnnotation != null) {
                    serviceName = componentAnnotation.value();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return serviceName;
    }
}
