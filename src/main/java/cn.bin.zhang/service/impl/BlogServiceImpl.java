package cn.bin.zhang.service.impl;

import cn.bin.zhang.dao.IBlogDAO;
import cn.bin.zhang.service.IBlogService;
import cn.bin.zhang.vo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogDAO iBlogDAO;

    @Override
    public Blog findByUid(Integer uid) throws Exception {
        return this.iBlogDAO.findByUid(uid);
    }
}
