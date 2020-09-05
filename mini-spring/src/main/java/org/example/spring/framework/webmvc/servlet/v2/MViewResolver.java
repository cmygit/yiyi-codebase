package org.example.spring.framework.webmvc.servlet.v2;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/8/29 15:55
 */
public class MViewResolver {

    private final static String DEFAULT_TEMPLATE_SUFFIX = ".html";

    private Path templateRootDir;

    public MViewResolver(String templateRoot) {
        String templateRootPath = this.getClass()
                                      .getClassLoader()
                                      .getResource(templateRoot)
                                      .getFile();

        this.templateRootDir = new File(templateRootPath).toPath();
    }

    public MView resolve(String viewName) {
        if (viewName == null || "".equals(viewName.trim())) {
            return null;
        }

        viewName = viewName.endsWith(DEFAULT_TEMPLATE_SUFFIX) ? viewName : viewName + DEFAULT_TEMPLATE_SUFFIX;


        String path = (this.templateRootDir.toString() + "/" + viewName).replaceAll("/+", "/");

        return new MView(Paths.get(path));
    }
}
