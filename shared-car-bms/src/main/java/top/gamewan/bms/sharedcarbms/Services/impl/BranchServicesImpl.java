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
        branchInfo.setPlace(place);
        branchInfo.setCount(count);
        branchInfo.setFlow(flow);
        return branchDao.insertBranchs(branchInfo);
    }

    @Override
    public boolean deleteBranch(int id) {
       return branchDao.deleteBranch(id);
    }

    @Override
    public int getBranchCount() {
       return branchDao.getBranchCount();
    }

    @Override
    public boolean editBranch(int id, String name, String type, String place, int count, int flow) {
       if(id<=0 ||name==null ||name.equals("") ||type==null||type.equals("")||place==null||place.equals("")
       ||count<0||flow<0)
           return false;

       return  branchDao.editBranch(id, name, type, place, count, flow);
    }


}
