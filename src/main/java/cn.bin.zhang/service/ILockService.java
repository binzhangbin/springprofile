package cn.bin.zhang.service;

public interface ILockService {
    Integer getLock(String ip)throws Exception;
    boolean updateLock(String ip,Integer lockcount)throws Exception;
    boolean addLock(String ip,Integer lockcount)throws Exception;
}
