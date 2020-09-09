package org.example.auth.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/9 23:12
 */
@Data
public class User {

    @TableId
    private Integer id;

    private String name;
}
