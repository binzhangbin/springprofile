package cn.bin.zhang.dao;
import cn.bin.zhang.vo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface IUserDAO {
        @Select("select uid,uname,uage,ubirthday,upasswd,uphoto,uinfo from user where uname=#{uname}")
        User findByName(@Param("uname") String uname)throws Exception;
        @Select("select uid,uname,uage,ubirthday,upasswd,uphoto,uinfo from user where uname=#{uname} and upasswd=#{upasswd}")
        User findByNameAndPasswd(@Param("uname") String uname, @Param("upasswd") String upasswd)throws Exception;
        @Update("update user set uage=#{uage},uname=#{uname},ubirthday=#{ubirthday},upasswd=#{upasswd},uphoto=#{uphoto},uinfo=#{uinfo} where uid=#{uid}")
        int doUpdate(User user)throws Exception;
        @Insert("insert into user(uname,uage,ubirthday,upasswd) values(#{uname},#{uage},#{ubirthday},#{upasswd})")
        boolean insertUser(User user)throws Exception;
}
