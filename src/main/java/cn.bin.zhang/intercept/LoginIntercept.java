package cn.bin.zhang.intercept;

import cn.bin.zhang.service.ILockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginIntercept implements HandlerInterceptor {
    @Autowired
    private EhCacheCacheManager ehcacheManager;
    @Autowired
    private ILockService iLockService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Integer lock = this.iLockService.getLock(request.getRemoteAddr());
        if(lock==null){
            this.iLockService.addLock(request.getRemoteAddr(),0);
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Integer lock = this.iLockService.getLock(request.getRemoteAddr());
        if(lock>=3) {//初始化判断
            this.ehcacheManager.getCache("userCache").put(request.getRemoteAddr()+"locked",request.getRemoteAddr());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if(this.iLockService.getLock(request.getRemoteAddr())>=4) {//初始化判断
            this.iLockService.updateLock(request.getRemoteAddr(),1);
        }
    }
}
