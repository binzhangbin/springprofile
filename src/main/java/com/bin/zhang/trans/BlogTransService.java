package com.bin.zhang.trans;

import cn.bin.zhang.vo.Blog;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service(value = "blogTransService")
@Transactional
public class BlogTransService {
    @Resource
    private BlogTransDAO blogTransDAO;

    public void save(Blog blog)throws Exception{
        this.blogTransDAO.save(blog);
        System.out.println(1/0);
        this.blogTransDAO.save(blog);
    }
}
