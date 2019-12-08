package com.bin.zhang.dao;

import cn.bin.zhang.vo.Blog;

public interface IMBlogDAO {
    Blog selectById(Integer uid);
}