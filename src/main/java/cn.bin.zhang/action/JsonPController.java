package cn.bin.zhang.action;

import cn.bin.zhang.vo.User;
import com.bin.zhang.vo.JsonP;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class JsonPController {//vue进行跨域访问
    private final static String CHARSET = ";charset=UTF-8";
    //produces返回数据的类型以及编码
    @RequestMapping(value = "/jsonp",produces = MediaType.APPLICATION_JSON_VALUE + CHARSET )
    public Object jsonP(@RequestParam("callback") String callback, HttpServletResponse response){
        List<JsonP> jsonPList=new ArrayList<>();
        for(int x=0;x<3;x++){
            JsonP jsonP=new JsonP();
            jsonP.setDeptno(x+"");
            jsonP.setDname("部门:"+x+"");
            jsonP.setDesc("描述:"+x+"");
            jsonPList.add(jsonP);
        }
        response.setCharacterEncoding("utf-8");
        return "backFun"+"("+JSONObject.toJSONString(jsonPList)+")";
    }
//    @RequestMapping(path = "/test1")
//    public String test(@ModelAttribute("user")User user){
    //      此时前台可以直接使用user
//        return "index";
//    }
}
