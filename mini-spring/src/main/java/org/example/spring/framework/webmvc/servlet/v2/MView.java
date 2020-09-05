package org.example.spring.framework.webmvc.servlet.v2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/8/29 15:56
 */
public class MView {

    private Path templateFile;

    public MView(Path templateFile) {
        this.templateFile = templateFile;
    }

    public void render(Map<String, ?> model, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StringBuilder sb = new StringBuilder();
        List<String> lines = Files.readAllLines(this.templateFile);

        // 查找模版变量，替换为实际值
        for (String line : lines) {
            // 匹配被${}包裹的内容，包括${}，忽略大小写
            // 如"msg: ${msg1} ${Msg2}..." 会匹配到 ${msg1} ${Msg2}
            Pattern pattern = Pattern.compile("\\$\\{[^}]+}", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                // 将匹配的结果去掉${}，如 ${msg1} -> msg1
                String varName = matcher.group().replaceAll("\\$\\{|}", "");
                Object varValue = model.get(varName);
                String replacement = this.escapeExprSpecialWord(String.valueOf(varValue));
                // 查到一个，替换一个，然后继续匹配
                line = matcher.replaceFirst(replacement);
                matcher = pattern.matcher(line);
            }

            sb.append(line);
        }

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter()
            .write(sb.toString());
    }


    /**
     * 转义正则特殊字符 （$()*+.[]?\^{},|）
     *
     * @param keyword
     * @return
     */
    public String escapeExprSpecialWord(String keyword) {
        if ("".equals(keyword)) {
            return null;
        }

        // 注意:\\需要第一个替换，否则replace方法替换时会有逻辑bug
        String[] fbsArr = {"\\", "$", "(", ")", "*", "+", ".", "[", "]", "?", "^", "{", "}", "|"};
        for (String key : fbsArr) {
            if (keyword.contains(key)) {
                keyword = keyword.replace(key, "\\" + key);
            }
        }

        return keyword;
    }
}
