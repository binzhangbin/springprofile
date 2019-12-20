package cn.bin.zhang.dao;

import cn.bin.zhang.vo.File;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IFileDAO {

    @Insert("insert into file(fname,fpath,fdate,uid) values(#{fname},#{fpath},#{fdate},#{uid})")
    public boolean insertFile(File file)throws Exception;
    @Delete("delete * from file where fid=#{fid}")
    public boolean deleteFile(Integer fid)throws Exception;
    @Select("select * from file")
    public List<File> selFile()throws Exception;
}
