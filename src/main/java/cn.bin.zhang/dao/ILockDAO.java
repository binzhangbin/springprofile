package cn.bin.zhang.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ILockDAO {
    @Insert("insert into ulock(ip,lockcount) values(#{ip},#{lockcount})")
    int insertLock(@Param("ip")String ip,@Param("lockcount")Integer lockcount)throws Exception;
    @Update("update ulock set lockcount=#{lockcount} where ip=#{ip}")
    int updateLock(@Param("ip") String ip, @Param("lockcount") Integer lockcount)throws Exception;
    @Select("select lockcount from ulock where ip=#{ip}")
    Integer getLock(@Param("ip") String ip)throws Exception;
}
