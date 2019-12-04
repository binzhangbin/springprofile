package cn.bin.zhang.dao;

import cn.bin.zhang.vo.Blog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface IBlogDAO {
    @Select("select uid,bid,btxt,btitle from blog where uid=#{uid}")
    Blog findByUid(@Param("uid") Integer uid)throws Exception;
}
