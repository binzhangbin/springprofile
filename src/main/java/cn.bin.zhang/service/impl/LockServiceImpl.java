package cn.bin.zhang.service.impl;

import cn.bin.zhang.dao.ILockDAO;
import cn.bin.zhang.service.ILockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LockServiceImpl implements ILockService {
    @Autowired
    private ILockDAO iLockDAO;


    @Override
    public Integer getLock(String ip) throws Exception {
        return this.iLockDAO.getLock(ip);
    }

    @Override
    public boolean updateLock(String ip, Integer lockcount) throws Exception {
        return this.iLockDAO.updateLock(ip,lockcount)==1;
    }

    @Override
    public boolean addLock(String ip, Integer lockcount) throws Exception {
        return this.iLockDAO.insertLock(ip,lockcount)==1;
    }
}
