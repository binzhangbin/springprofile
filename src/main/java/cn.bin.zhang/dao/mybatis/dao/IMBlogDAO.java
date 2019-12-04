package cn.bin.zhang.dao.mybatis.dao;

import cn.bin.zhang.vo.Blog;

public interface IMBlogDAO {
    Blog selectById(Integer uid);
}
