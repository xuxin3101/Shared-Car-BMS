package top.gamewan.bms.sharedcarbms.Services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.gamewan.bms.sharedcarbms.Bean.BranchInfo;
import top.gamewan.bms.sharedcarbms.Dao.BranchDao;
import top.gamewan.bms.sharedcarbms.Services.BranchServices;

import java.util.List;
@Component
public class BranchServicesImpl implements BranchServices {
    @Autowired
    private BranchDao branchDao;
    @Override
    public List<BranchInfo> getBranchs(int page, int count) {
        return branchDao.getBranchs(page,count);
    }

    @Override
    public boolean insertBranch(String name, String type, String place, int count, int flow) {
        BranchInfo branchInfo=new BranchInfo();
        branchInfo.setName(name);
        branchInfo.setType(type);
        branchInfo.setPlacplace(place);
        branchInfo.setCount(count);
        branchInfo.setFlow(flow);
        return branchDao.insertBranchs(branchInfo);
    }

    @Override
    public boolean deleteBranch(int id) {
       return branchDao.deleteBranch(id);
    }
}
