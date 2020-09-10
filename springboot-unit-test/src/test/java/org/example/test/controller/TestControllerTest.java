package org.example.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.test.AppTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/10 20:22
 */
@Slf4j
public class TestControllerTest extends AppTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void hi() throws Exception {
        // 构造一个post请求，请求路径为 /hello
        MockHttpServletRequestBuilder get = MockMvcRequestBuilders.get("/hi")
                                                                  .param("name", "world");

        // mockMvc 执行请求
        // perform 执行一个RequestBuilders请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理
        this.mockMvc.perform(get)
                    // andExpect，断言，添加验证规则，验证控制器执行完成后结果是否正确。
                    // 如果实际结果与预期不符，会抛出异常java.lang.AssertionError，并给出期望值和实际值。
                    // 断言 Status 为 200，表示请求成功
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    // 打印结果到控制台
                    .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void hello() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "world");

        // 构造一个post请求，请求路径为 /hello
        MockHttpServletRequestBuilder post = MockMvcRequestBuilders.post("/hello")
                                                                   // 设置 Content type 为 application/json;charset=UTF-8
                                                                   .contentType(MediaType.APPLICATION_JSON_UTF8)
                                                                   // 设置请求体，传输json数据
                                                                   .content(mapper.writeValueAsString(map));

        String result = this.mockMvc.perform(post)
                                    // 断言 Status 为 200，表示请求成功
                                    .andExpect(MockMvcResultMatchers.status().isOk())
                                    // 断言 Content type 为 application/json;charset=UTF-8
                                    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                                    // 断言 Body 中含有 "msg":"hello world" 的内容
                                    .andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("hello world"))
                                    // 打印结果到控制台
                                    .andDo(MockMvcResultHandlers.print())
                                    // 获取响应内容
                                    .andReturn()
                                    .getResponse()
                                    .getContentAsString();

        log.info("result: {}", result);
    }
}
