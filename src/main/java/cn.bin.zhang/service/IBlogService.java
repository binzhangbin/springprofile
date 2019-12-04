package cn.bin.zhang.service;

import cn.bin.zhang.vo.Blog;

public interface IBlogService {
    Blog findByUid(Integer uid)throws Exception;
}
