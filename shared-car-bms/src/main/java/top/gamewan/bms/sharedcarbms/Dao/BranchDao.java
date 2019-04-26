package top.gamewan.bms.sharedcarbms.Dao;

import top.gamewan.bms.sharedcarbms.Bean.BranchInfo;

import java.util.List;

public interface BranchDao {
    List<BranchInfo> getBranchs(int page,int count);
    boolean insertBranchs(BranchInfo branchInfo);
    boolean deleteBranch(int id);
}
