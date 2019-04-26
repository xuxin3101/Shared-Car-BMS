package top.gamewan.bms.sharedcarbms.Bean;

import java.util.List;

public class ListBranchInfoReturnMsg extends ReturnMsg {
    List<BranchInfo> branchInfoList;
    public ListBranchInfoReturnMsg(String msg, int code) {
        super(msg, code);
    }
    public ListBranchInfoReturnMsg(String msg, int code, List<BranchInfo> branchInfos){
        super(msg,code);
        this.branchInfoList=branchInfos;
    }

    public List<BranchInfo> getBranchInfoList() {
        return branchInfoList;
    }

    public void setBranchInfoList(List<BranchInfo> branchInfoList) {
        this.branchInfoList = branchInfoList;
    }
}
