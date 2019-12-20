package cn.bin.zhang.service.impl;

import cn.bin.zhang.dao.IFileDAO;
import cn.bin.zhang.service.IFileService;
import cn.bin.zhang.vo.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements IFileService {
    @Autowired
    private IFileDAO iFileDAO;
    @Override
    public boolean addFile(File file) throws Exception {
        return this.iFileDAO.insertFile(file);
    }

    @Override
    public boolean delFile(Integer fid) throws Exception {
        return this.iFileDAO.deleteFile(fid);
    }
}
