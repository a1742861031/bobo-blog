package com.bobo.blog.service;

import com.bobo.blog.entity.BlogTag;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description tag Service接口
 * @Date 2021/10/28 21:46
 * @Created by bobo
 */
@Service
public interface BlogTagService {
    //获取tag列表
    List<BlogTag> getTagList(@Nullable String tagName);

    //修改tag
    boolean updateTag(BlogTag tag);

    //新增tag
    boolean addTag(BlogTag tag);

    //删除tag
    boolean deleteTag(Integer id);

    //根据id获取tag
    BlogTag getTagById(Integer id);
}
