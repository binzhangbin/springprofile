package cn.bin.zhang.service;

import cn.bin.zhang.dao.IFileDAO;
import cn.bin.zhang.vo.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

//@Service
public class QuartzService {
    @Autowired
    private IFileDAO fileDAO;
    @Scheduled(cron = "0/2 * * * * ?")
    public void run() throws Exception {
        List<File> files = this.fileDAO.selFile();
        Iterator<File> iterator = files.iterator();
        Date date=new Date();
        while (iterator.hasNext()){
            File next = iterator.next();
            if(date.getYear()-next.getFdate().getYear()==0){
                System.out.println("文件已经被删除--"+next.getFname());
//                this.fileDAO.deleteFile(next.getFid());
                java.io.File delFile=new java.io.File(next.getFpath());
                if(delFile.exists()){
                    delFile.delete();
                }
            }
        }
    }
}
