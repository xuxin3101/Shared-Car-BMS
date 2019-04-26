package top.gamewan.bms.sharedcarbms.Services;

import top.gamewan.bms.sharedcarbms.Bean.BranchInfo;

import java.util.List;

public interface BranchServices {
    List<BranchInfo> getBranchs(int page, int count);
    boolean insertBranch(String name,String type,String place,int count,int flow);
    boolean deleteBranch(int id);
}
