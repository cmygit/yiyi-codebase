package org.example.business.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Title:
 * @Author: cmy
 * @Date: 2020/9/9 22:29
 */
@Data
public class Product {

    @TableId
    private Integer productId;

    private String productName;
}
