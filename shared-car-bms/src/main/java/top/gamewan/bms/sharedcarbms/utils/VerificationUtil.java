package top.gamewan.bms.sharedcarbms.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import top.gamewan.bms.sharedcarbms.Services.UserServices;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
@Component
public class VerificationUtil {
    @Autowired
    UserServices userServices;
    @Value(value="${top.gamewan.bms.signstring}")
    private  String signString;
    @Value("${top.gamewan.bms.timeout}")
    private int timeout;
    public boolean checkSign(Map<String,String> map){
        if(map.get("timestamp")==null || map.get("timestamp").equals(""))
            return false;
        if(map.get("sign")==null || map.get("sign").equals(""))
            return false;
        Long currenttime=System.currentTimeMillis();
        Long clienttime=Long.parseLong(map.get("timestamp"));
        if(currenttime-clienttime>timeout){
            return false;
        }
        StringBuilder signResult=new StringBuilder();
        List<String> key=new ArrayList<>();
        for(String cur:map.keySet()){
            if(!cur.equals("sign"))
            key.add(cur);
        }
        Collections.sort(key);
        for(String cur:key){
            signResult.append(cur).append(map.get(cur));
        }
        signResult.append(signString);
        System.out.println(signResult.toString());
        if(DigestUtils.md5DigestAsHex(signResult.toString().getBytes()).equals(map.get("sign"))){
            return true;
        }else{
            return false;
        }
    }
    public static Map<String,String> requestToMap(HttpServletRequest request){
        Enumeration<String> parametername=request.getParameterNames();
        Map<String,String> map=new HashMap<>();
        while (parametername.hasMoreElements()){
            String key=parametername.nextElement();
            map.put(key,request.getParameter(key));
        }
        return map;
    }
    public int checkSignAndToken(HttpServletRequest request){
        Map<String, String> map = VerificationUtil.requestToMap(request);
        if (!this.checkSign(map)) {
            return 1001;
        }
        String token = request.getParameter("token");
        String username = request.getParameter("username");
        if (!userServices.userTokenCheck(username, token)) {
            return 1002;
        }
        return 1000;
    }
}
