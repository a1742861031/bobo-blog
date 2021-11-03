package com.bobo.blog.common.entity.dto;

import lombok.Data;

/**
 * @Description 后台数据展示DTO
 * @Date 2021/11/1 18:09
 * @Created by bobo
 */
@Data
public class IndexPageDataDto {
    private Integer pageCount;
    private Integer messageCount;
    private Integer CategoryCount;
    private Integer tagCount;
}
