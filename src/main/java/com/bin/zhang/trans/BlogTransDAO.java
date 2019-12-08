package com.bin.zhang.trans;

import cn.bin.zhang.vo.Blog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Repository
public class BlogTransDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Transactional(readOnly = false,timeout = -1,isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    public void save(Blog blog){
        String sql="insert into blog(btxt,btitle,uid) values(?,?,?)";
        int update = jdbcTemplate.update(sql, blog.getBtxt(), blog.getBtitle(), blog.getUid());
        System.out.println("更新数目:"+update);
    }
}
