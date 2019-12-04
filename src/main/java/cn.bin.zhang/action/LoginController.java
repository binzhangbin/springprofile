package cn.bin.zhang.action;

import cn.bin.zhang.service.IBlogService;
import cn.bin.zhang.service.IUserService;
import cn.bin.zhang.util.MD5Code;
import cn.bin.zhang.vo.Blog;
import cn.bin.zhang.vo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/blog/")
public class LoginController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private IBlogService iBlogService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dataFormat, true));
    }

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("uname") String uname, @RequestParam("upasswd") String upasswd) throws Exception {
        String successViewName = "index";
        String failViewName = "relogin";
        ModelAndView modelAndView = new ModelAndView();
        if (upasswd == null || "".equals(upasswd) || uname == null || "".equals(uname)) {
            modelAndView.setViewName(failViewName);
            modelAndView.addObject("relogin", "用户名或密码错误，请重新登录");
        } else {
            String md5passwd = new MD5Code().getMD5ofStr(upasswd);
            try {
                User user = this.iUserService.findByNameAndPasswd(uname, md5passwd);
                if (user != null) {
                    modelAndView.setViewName(successViewName);
                    Blog blog = this.iBlogService.findByUid(user.getUid());
                    modelAndView.addObject("blog", blog);
                } else {
                    modelAndView.setViewName(failViewName);
                    modelAndView.addObject("relogin", "用户名或密码错误，请重新登录");
                }
                modelAndView.addObject("user", user);
            } catch (Exception e) {
                e.printStackTrace();
                throw e;//不剖出就不会被AOP截获
            }
        }
        return modelAndView;
    }

    @RequestMapping("/reg")
    public String reg(@RequestParam("uname") String uname, @RequestParam("upasswd") String upasswd, @RequestParam("ubirthday") Date ubirthday, @RequestParam("uage") Integer uage) throws Exception {
        User user = new User();
        user.setUage(uage);
        user.setUbirthday(ubirthday);
        user.setUname(uname);
        user.setUpasswd(new MD5Code().getMD5ofStr(upasswd));
        String resLoc = "redirect:/reregister.html";
        boolean booladd = this.iUserService.addUser(user);
        if (booladd) {
            resLoc = "redirect:/login.html";
        }
        int c = 1 / 0;
        return resLoc;
    }
}

