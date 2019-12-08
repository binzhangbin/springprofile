package cn.bin.zhang.aop;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class LoginLog {
    private static Logger LOG = Logger.getLogger(LoginLog.class);
    @Autowired
    private HttpServletRequest request;

    @Pointcut("execution(* cn.bin.zhang.service.impl.UserServiceImpl.findByNameAndPasswd(..))")
    public void loginLog1() {
    }

    @Pointcut("execution(* cn.bin.zhang.service.impl.UserServiceImpl.findByNameAndPasswd(..))&&args(name,passwd)")
    public void loginLog(String name, String passwd) {
    }

    @Pointcut("execution(* cn.bin.zhang.action.LoginController.*(..))")
    public void exception() {
    }

    @Before(value = "loginLog(name,passwd)", argNames = "name,passwd")
    public void before(
            String name, String passwd) {
        LOG.info("【before】登录" + name + "," + passwd);
        LOG.error("用户:" + name + "登录,登录信息:" + request.getRemoteAddr());
    }

    //    @Around("loginLog1()")//与@AfterThrowing不共融
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object obj = null;
        Object[] args = proceedingJoinPoint.getArgs();
        LOG.info("【around】获取参数：1.长度:" + args.length + ",2.参数:" + args[0] + "," + args[1]);
        LOG.info("【around】执行目标：" + proceedingJoinPoint.getSourceLocation());
        try {
            obj = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        LOG.info("【around】目标方法执行结束");
        return obj;
    }

    @After("loginLog1()")
    public void after() {
        System.out.println("【after】登录");
        LOG.info("【after】获取登录者IP：" + request.getRemoteAddr());
    }

    @AfterThrowing(value = "exception()",throwing = "e")
    public void ControllerException(Exception e){
        LOG.info("错误日志："+e.getMessage());
        LOG.error("【Wrong】"+request.getRequestURI()+","+e.getMessage());
    }
}
