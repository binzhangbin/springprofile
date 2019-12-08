package cn.bin.zhang.service.impl;

import cn.bin.zhang.dao.IUserDAO;
import cn.bin.zhang.service.IUserService;
import cn.bin.zhang.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO iUserDAO;

    @Override
    public User findByName(String uname) throws Exception {
        return this.iUserDAO.findByName(uname);
    }

    @Override
    public User findByNameAndPasswd(String uname, String upasswd) throws Exception {
        return this.iUserDAO.findByNameAndPasswd(uname,upasswd);
    }

    @Override
    public boolean doUpdate(User user) throws Exception {
        return this.iUserDAO.doUpdate(user)==1;
    }

    @Override
    public boolean addUser(User user) throws Exception {
//        int c = 1 / 0;
        if(this.findByName(user.getUname())==null){
            return this.iUserDAO.insertUser(user);
        }
        return false;
    }
}
