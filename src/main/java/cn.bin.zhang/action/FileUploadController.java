package cn.bin.zhang.action;

import cn.bin.zhang.service.IBlogService;
import cn.bin.zhang.service.IFileService;
import cn.bin.zhang.service.IUserService;
import cn.bin.zhang.vo.Blog;
import cn.bin.zhang.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;

@Controller
public class FileUploadController {
    @Autowired
    private IFileService iFileService;
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private IUserService iUserService;

    @RequestMapping(value="/fileupload")
    public ModelAndView fileUpload2(HttpServletRequest request, @RequestParam("file1") MultipartFile file) throws Exception {
        ModelAndView modelAndView=new ModelAndView("index");
        String path = "/Users/binzhang/Desktop/fixedlogs/" + file.getOriginalFilename();
        File newFile = new File(path);
        File fileParent = newFile.getParentFile();
        if (!fileParent.exists()) {
            fileParent.mkdirs();
        }
        file.transferTo(newFile);
        cn.bin.zhang.vo.File file1 = new cn.bin.zhang.vo.File();
        file1.setFdate(new Date());
        file1.setFname(file.getOriginalFilename());
        file1.setFpath(path);
        boolean fileAddFlag = this.iFileService.addFile(file1);
        User user= (User) request.getSession().getAttribute("usr");
        Blog newBlog = this.iBlogService.findByUid(user.getUid());
        User newUser=this.iUserService.findByName(user.getUname());
        modelAndView.addObject("user",newUser);
        modelAndView.addObject("blog",newBlog);
        return modelAndView;
    }
}
