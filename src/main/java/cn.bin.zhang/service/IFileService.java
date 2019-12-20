package cn.bin.zhang.service;

import cn.bin.zhang.vo.File;

public interface IFileService {
    public boolean addFile(File file)throws Exception;
    public boolean delFile(Integer fid)throws Exception;
}
