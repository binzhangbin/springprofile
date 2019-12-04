package cn.bin.zhang.service;

import cn.bin.zhang.vo.User;

public interface IUserService {
     User findByName(String uname)throws Exception;
     User findByNameAndPasswd(String uname, String upasswd)throws Exception;
     boolean doUpdate(User user)throws Exception;
     boolean addUser(User user)throws Exception;
}
