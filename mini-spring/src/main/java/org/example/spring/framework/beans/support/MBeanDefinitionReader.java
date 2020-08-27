package org.example.spring.framework.beans.support;

import org.example.spring.framework.beans.config.MBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/8/26 21:47
 */
public class MBeanDefinitionReader {

    private Properties contextConfig = new Properties();

    private List<String> registryBeanClasses = new ArrayList<>();

    public MBeanDefinitionReader(List<String> configLocations) {
        // 读取配置文件
        this.doLoadConfig(configLocations.get(0));
        // 扫描相关的类
        this.doScanner(this.contextConfig.getProperty("scanPackage"));
    }

    public List<MBeanDefinition> doLoadBeanDefinitions() {
        List<MBeanDefinition> result = new ArrayList<>();

        try {
            for (String className : this.registryBeanClasses) {
                Class<?> beanClass = Class.forName(className);
                if (beanClass.isInterface()) {
                    continue;
                }

                String beanName = this.toLowerFirstCase(beanClass.getSimpleName());
                result.add(this.doCreateBeanDefinition(beanName, beanClass.getName()));

                for (Class<?> anInterface : beanClass.getInterfaces()) {
                    result.add(this.doCreateBeanDefinition(anInterface.getName(), beanClass.getName()));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 将字符串首字母转为小写
     *
     * @param str
     * @return
     */
    private String toLowerFirstCase(String str) {
        char[] chars = str.toCharArray();
        // 通过修改ASCII 编码表中对应的码值进行转换
        // 大小写码值相差32
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private MBeanDefinition doCreateBeanDefinition(String factoryBeanName, String beanClassName) {
        MBeanDefinition beanDefinition = new MBeanDefinition();
        beanDefinition.setFactoryBeanName(factoryBeanName);
        beanDefinition.setBeanClassName(beanClassName);
        return beanDefinition;
    }

    /**
     * 读取配置文件
     *
     * @param contextConfigLocation 配置文件名
     */
    private void doLoadConfig(String contextConfigLocation) {
        // 到classPath中找到配置文件，装换为文件流
        try (InputStream inputStream = this.getClass()
                                           .getClassLoader()
                                           .getResourceAsStream(contextConfigLocation)) {
            // 加载配置文件
            this.contextConfig.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 扫描相关的类
     *
     * @param scanPackage 需要扫描的包路径
     */
    private void doScanner(String scanPackage) {
        // 把包路径的“.”替换为“/”
        String path = "/" + scanPackage.replaceAll("\\.", "/");
        URL url = this.getClass().getClassLoader().getResource("/" + path);
        // 获取class文件
        File classFile = new File(url.getFile());

        for (File file : classFile.listFiles()) {
            // 如果是文件夹，则将文件夹名字拼接到类的限定名，递归寻找class文件
            if (file.isDirectory()) {
                this.doScanner(scanPackage + "." + file.getName());
            }

            // 跳过非class文件
            if (!file.getName().endsWith(".class")) {
                continue;
            }

            // 拼接类的限定名，用于Class.forName()获取类
            String className = scanPackage + "." + file.getName().replace(".class", "");
            this.registryBeanClasses.add(className);
        }
    }
}
