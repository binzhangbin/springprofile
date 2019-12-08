package com.bin.zhang.dao;

import cn.bin.zhang.vo.Blog;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository(value = "u")
public class BlogDAOImpl implements IMBlogDAO {
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public Blog selectById(Integer uid) {
        return this.sqlSessionTemplate.selectOne("cn.bin.zhang.vo.UserNS.findOneById",uid);
    }
}