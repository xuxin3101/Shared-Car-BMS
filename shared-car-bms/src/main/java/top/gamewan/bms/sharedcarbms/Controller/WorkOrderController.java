package top.gamewan.bms.sharedcarbms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.gamewan.bms.sharedcarbms.Bean.ReturnMsg;
import top.gamewan.bms.sharedcarbms.Bean.WorkOrderInfoReturnMsg;
import top.gamewan.bms.sharedcarbms.Services.WorkOrderServices;
import top.gamewan.bms.sharedcarbms.utils.VerificationUtil;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("api")
public class WorkOrderController {
    @Autowired
    VerificationUtil verificationUtil;
    @Autowired
    WorkOrderServices workOrderServices;
    @RequestMapping(value = "getworkorders",method = RequestMethod.POST)
    public ReturnMsg getWorkorders(HttpServletRequest request){
        int resultcode=
                verificationUtil.checkSignAndToken(request);
        if (resultcode == 1001) {
            return new ReturnMsg("sign验证失败", 1001);
        } else if (resultcode == 1002) {
            return new ReturnMsg("token验证失败", 1002);
        } else {
            Integer page=Integer.parseInt(request.getParameter("page"));
            Integer count=Integer.parseInt(request.getParameter("count"));
            Integer type=Integer.parseInt(request.getParameter("type"));
            return new WorkOrderInfoReturnMsg("获取成功",1000,workOrderServices.getWorkOrderCount(),
                    workOrderServices.getWorkOrders(page,count,type));
        }
    }
    @RequestMapping(value="deleteworkorder",method = RequestMethod.POST)
    public ReturnMsg deleteWorkOrder(HttpServletRequest request){
        int resultcode=
                verificationUtil.checkSignAndToken(request);
        if (resultcode == 1001) {
            return new ReturnMsg("sign验证失败", 1001);
        } else if (resultcode == 1002) {
            return new ReturnMsg("token验证失败", 1002);
        } else {
            Integer id=Integer.parseInt(request.getParameter("id"));
            if(workOrderServices.deleteWorkOrder(id)){
                return new ReturnMsg("删除成功", 1000);
            }else{
                return new ReturnMsg("删除失败", 1005);
            }
        }
    }
    @RequestMapping(value = "insertworkorder",method = RequestMethod.POST)
    public ReturnMsg insertWorkOrder(HttpServletRequest request){
        int resultcode=
                verificationUtil.checkSignAndToken(request);
        if (resultcode == 1001) {
            return new ReturnMsg("sign验证失败", 1001);
        } else if (resultcode == 1002) {
            return new ReturnMsg("token验证失败", 1002);
        } else {
            if(workOrderServices.inserWorkOrder(request.getParameter("carnumber"),request.getParameter("principal"),
                    request.getParameter("status"),Integer.parseInt(request.getParameter("type"))))
            {
                return  new ReturnMsg("插入成功",1000);
            }else{
                return new ReturnMsg("插入失败",1001);
            }
        }
    }
}
