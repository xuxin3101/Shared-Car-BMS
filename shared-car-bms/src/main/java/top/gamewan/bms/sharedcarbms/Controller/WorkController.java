package top.gamewan.bms.sharedcarbms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.gamewan.bms.sharedcarbms.Bean.ReturnMsg;
import top.gamewan.bms.sharedcarbms.Bean.WorkersInfoReturnMsg;
import top.gamewan.bms.sharedcarbms.Services.WorkServices;
import top.gamewan.bms.sharedcarbms.utils.VerificationUtil;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("api")
public class WorkController {
    @Autowired
    VerificationUtil verificationUtil;
    @Autowired
    private WorkServices workServices;
    @RequestMapping(value = "getworkers",method = RequestMethod.POST)
    public ReturnMsg getworkers(HttpServletRequest request){
        int resultcode=
        verificationUtil.checkSignAndToken(request);
        if (resultcode == 1001) {
            return new ReturnMsg("sign验证失败", 1001);
        } else if (resultcode == 1002) {
            return new ReturnMsg("token验证失败", 1002);
        } else {
            int page=Integer.parseInt(request.getParameter("page"));
            int count=Integer.parseInt(request.getParameter("count"));
            return new WorkersInfoReturnMsg("获取成功",1000, workServices.
                    getWorkers(page,count),workServices.getWorkersCount());
        }
    }
}
