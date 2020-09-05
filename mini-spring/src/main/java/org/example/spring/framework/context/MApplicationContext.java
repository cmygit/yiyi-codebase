package org.example.spring.framework.context;

import org.example.spring.framework.annotation.MAutoWired;
import org.example.spring.framework.annotation.MController;
import org.example.spring.framework.annotation.MService;
import org.example.spring.framework.beans.MBeanWrapper;
import org.example.spring.framework.beans.config.MBeanDefinition;
import org.example.spring.framework.beans.support.MBeanDefinitionReader;
import org.example.spring.framework.util.CommonUtil;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/8/26 21:43
 */
public class MApplicationContext {

    private List<String> configLocations;

    private MBeanDefinitionReader reader;

    private Map<String, MBeanDefinition> beanDefinitionMap = new HashMap<>();

    private Map<String, MBeanWrapper> factoryBeanInstanceCache = new HashMap<>();

    private Map<String, Object> factoryBeanObjectCache = new HashMap<>();

    public MApplicationContext(String... configLocations) {
        this.configLocations = Arrays.asList(configLocations);
        try {
            // 1、读取配置文件，并且封装成MBeanDefinition对象
            this.reader = new MBeanDefinitionReader(this.configLocations);
            List<MBeanDefinition> beanDefinitions = this.reader.doLoadBeanDefinitions();

            // 2、将MBeanDefinition对象缓存到beanDefinitionMap中
            this.doRegistryBeanDefinition(beanDefinitions);

            // 3、触发类实例化的动作，循环调用getBean()
            this.doCreateBean();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doCreateBean() {
        for (Map.Entry<String, MBeanDefinition> entry : this.beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();

            // 1、真正完成创建动作的方法
            // 2、完成DI
            this.getBean(beanName);
        }
    }

    private void doRegistryBeanDefinition(List<MBeanDefinition> beanDefinitions) throws Exception {
        for (MBeanDefinition beanDefinition : beanDefinitions) {
            String factoryBeanName = beanDefinition.getFactoryBeanName();
            if (this.beanDefinitionMap.containsKey(factoryBeanName)) {
                throw new Exception("The " + factoryBeanName + " is exists.");
            }
            this.beanDefinitionMap.put(factoryBeanName, beanDefinition);
            this.beanDefinitionMap.put(beanDefinition.getBeanClassName(), beanDefinition);
        }
    }

    public Object getBean(String beanName) {
        // 1、拿到beanName对应的配置信息BeanDefinition
        MBeanDefinition beanDefinition = this.beanDefinitionMap.get(beanName);
        // 2、实例化对象
        Object instance = this.instantiateBean(beanName, beanDefinition);
        // 3、将对象封装成BeanWrapper
        MBeanWrapper beanWrapper = new MBeanWrapper(instance);
        // 4、将BeanWrapper缓存到ioc容器中
        this.factoryBeanInstanceCache.put(beanName, beanWrapper);
        // 5、完成依赖注入
        this.populateBean(beanName, beanDefinition, beanWrapper);

        return instance;
    }

    private void populateBean(String beanName, MBeanDefinition beanDefinition, MBeanWrapper beanWrapper) {
        Object instance = beanWrapper.getWrapperInstance();
        Class<?> clazz = beanWrapper.getWrapperClass();

        if (!clazz.isAnnotationPresent(MController.class) && !clazz.isAnnotationPresent(MService.class)) {
            return;
        }

        // 获取bean的所有字段
        for (Field field : clazz.getDeclaredFields()) {
            // 没有添加@MAutoWired，则跳过
            if (!field.isAnnotationPresent(MAutoWired.class)) {
                continue;
            }

            MAutoWired annotation = field.getAnnotation(MAutoWired.class);
            // 若注解指定了beanName，则使用指定的beanName，否则使用字段的类型作为beanName
            String autoWiredBeanName = annotation.value().trim();
            if ("".equals(autoWiredBeanName)) {
                autoWiredBeanName = field.getType().getName();
            } else {
                autoWiredBeanName = CommonUtil.toLowerFirstCase(autoWiredBeanName);
            }

            field.setAccessible(true);
            try {
                MBeanWrapper wrapper = this.factoryBeanInstanceCache.get(autoWiredBeanName);
                if (wrapper == null) {
                    continue;
                }
                field.set(instance, wrapper.getWrapperInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private Object instantiateBean(String beanName, MBeanDefinition beanDefinition) {
        String className = beanDefinition.getBeanClassName();
        Object instance = null;
        try {
            Class<?> clazz = Class.forName(className);
            instance = clazz.newInstance();

            // TODO: AOP 生成代理对象

            this.factoryBeanObjectCache.put(beanName, instance);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return instance;
    }

    public Object getBean(Class clazz) {
        return this.getBean(clazz.getName());
    }

    public int getDefinitionCount() {
        return this.beanDefinitionMap.size();
    }

    public Set<String> getDefinitionNames() {
        return this.beanDefinitionMap.keySet();
    }

    public Properties getConfig() {
        return this.reader.getConfig();
    }
}
