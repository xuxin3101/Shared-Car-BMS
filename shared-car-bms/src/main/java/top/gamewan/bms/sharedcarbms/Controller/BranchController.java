package top.gamewan.bms.sharedcarbms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.gamewan.bms.sharedcarbms.Bean.BranchInfo;
import top.gamewan.bms.sharedcarbms.Bean.ListBranchInfoReturnMsg;
import top.gamewan.bms.sharedcarbms.Bean.ReturnMsg;
import top.gamewan.bms.sharedcarbms.Services.BranchServices;
import top.gamewan.bms.sharedcarbms.Services.UserServices;
import top.gamewan.bms.sharedcarbms.utils.VerificationUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api")
public class BranchController {
    @Autowired
    private BranchServices branchServices;
    @Autowired
    private UserServices userServices;
    @Autowired
    VerificationUtil verificationUtil;

    @RequestMapping(value = "insertbranch", method = RequestMethod.POST)
    public ReturnMsg insertBranch(HttpServletRequest request) {
        Map<String, String> map = VerificationUtil.requestToMap(request);
        if (!verificationUtil.checkSign(map)) {
            return new ReturnMsg("sign验证失败", 1001);
        }
        String token = request.getParameter("token");
        String username = request.getParameter("username");
        if (!userServices.userTokenCheck(username, token)) {
            return new ReturnMsg("token验证失败", 1002);
        }
        if (branchServices.insertBranch(request.getParameter("name"), request.getParameter("type"),
                request.getParameter("place"), Integer.parseInt(request.getParameter("count")),
                Integer.parseInt(request.getParameter("flow")))) {
            return new ReturnMsg("添加成功", 1000);
        } else {
            return new ReturnMsg("添加失败", 1005);
        }

    }

    @RequestMapping(value = "deletebranch", method = RequestMethod.POST)
    public ReturnMsg deleteBranch(HttpServletRequest request) {
        int resultcode =
                verificationUtil.checkSignAndToken(request);
        if (resultcode == 1001) {
            return new ReturnMsg("sign验证失败", 1001);
        } else if (resultcode == 1002) {
            return new ReturnMsg("token验证失败", 1002);
        } else {
            String id = request.getParameter("id");
            if (branchServices.deleteBranch(Integer.parseInt(id))) {
                return new ReturnMsg("删除成功", 1000);
            } else {
                return new ReturnMsg("删除失败", 1005);
            }
        }

    }

    @RequestMapping(value = "getbranch", method = RequestMethod.POST)
    public ListBranchInfoReturnMsg getBranches(HttpServletRequest request) {
        int resultcode = verificationUtil.checkSignAndToken(request);
        if (resultcode == 1001) {
            return new ListBranchInfoReturnMsg("sign验证失败", 1001, null);
        } else if (resultcode == 1002) {
            return new ListBranchInfoReturnMsg("token验证失败", 1002, null);
        } else {
            String page = request.getParameter("page");
            String count = request.getParameter("count");
            List<BranchInfo> branchInfos =
                    branchServices.getBranchs(Integer.parseInt(page), Integer.parseInt(count));
            return new ListBranchInfoReturnMsg("获取成功", 1000, branchInfos);
        }
    }

}
