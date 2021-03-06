package cn.bin.zhang.action;

import cn.bin.zhang.service.IBlogService;
import cn.bin.zhang.service.ILockService;
import cn.bin.zhang.service.IUserService;
import cn.bin.zhang.util.MD5Code;
import cn.bin.zhang.vo.Blog;
import cn.bin.zhang.vo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/blog")
public class LoginController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ILockService iLockService;
    @Autowired
    private EhCacheCacheManager ehcacheManager;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dataFormat, true));
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, @RequestParam("uname") String uname, @RequestParam("upasswd") String upasswd) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        String successViewName = "index";
        String failViewName = "relogin";
        boolean lockflag = false;//锁定用户标志位
        if (this.ehcacheManager.getCache("userCache").get(request.getRemoteAddr()+"locked") != null) {
            modelAndView.setViewName(failViewName);
            modelAndView.addObject("lock", "ip【" + request.getRemoteAddr() + "】被锁定，请于3分钟后重新登录");
            lockflag = true;//锁定用户
        } else {
            if (upasswd == null || "".equals(upasswd) || uname == null || "".equals(uname)) {
                modelAndView.setViewName(failViewName);
                modelAndView.addObject("relogin", "用户名或密码错误，请重新登录");
                lockflag = true;//锁定用户
            } else {
                String md5passwd = new MD5Code().getMD5ofStr(upasswd);
                try {
                    User user = this.iUserService.findByNameAndPasswd(uname, md5passwd);
                    if (user != null) {
                        modelAndView.setViewName(successViewName);
                        Blog blog = this.iBlogService.findByUid(user.getUid());
                        modelAndView.addObject("blog", blog);
                        modelAndView.addObject("user",user);
                        request.getSession().setAttribute("usr",user);
                        request.getSession().setAttribute("blg",blog);
                        this.ehcacheManager.getCache("userCache").evict(request.getRemoteAddr()+"locked");
                        String ip = request.getRemoteAddr();
                        this.iLockService.updateLock(ip, 0);
                    } else {
                        modelAndView.setViewName(failViewName);
                        modelAndView.addObject("relogin", "用户名或密码错误，请重新登录");
                        lockflag = true;//锁定用户
                    }
                    modelAndView.addObject("user", user);
                } catch (Exception e) {
                    lockflag = true;
                    e.printStackTrace();
                    throw e;//不剖出就不会被AOP截获
                }
            }
        }
        if (lockflag) {//更新字段
            String ip = request.getRemoteAddr();
            Integer lockCount = this.iLockService.getLock(ip);
            boolean updateLockFlag = this.iLockService.updateLock(ip, lockCount + 1);
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
//        int c = 1 / 0;
        return resLoc;
    }
    @RequestMapping("/update")
    public ModelAndView update(HttpServletRequest request,@RequestParam("uid")Integer uid,@RequestParam("uname") String uname, @RequestParam("ubirthday") Date ubirthday, @RequestParam("uage") Integer uage,@RequestParam("uinfo") String uinfo) throws Exception {
       ModelAndView modelAndView=new ModelAndView();
        User user1 = new User();
        user1.setUname(uname);
        user1.setUid(uid);
        user1.setUage(uage);
        user1.setUbirthday(ubirthday);
        user1.setUinfo(uinfo);
        this.iUserService.updateUser(user1);
        User byName = this.iUserService.findByName(uname);
        Blog blog = this.iBlogService.findByUid(user1.getUid());
        modelAndView.addObject("user",byName);
        modelAndView.addObject("blog",blog);
        request.getSession().setAttribute("usr",byName);
        request.getSession().setAttribute("blg",blog);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}

