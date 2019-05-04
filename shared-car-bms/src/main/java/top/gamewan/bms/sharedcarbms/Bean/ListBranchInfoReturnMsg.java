package top.gamewan.bms.sharedcarbms.Bean;

import java.util.List;

public class ListBranchInfoReturnMsg extends ReturnMsg {
    List<BranchInfo> branchInfoList;
    int branchcount;

    public int getBranchcount() {
        return branchcount;
    }

    public void setBranchcount(int branchcount) {
        this.branchcount = branchcount;
    }

    public ListBranchInfoReturnMsg(String msg, int code) {
        super(msg, code);
    }
    public ListBranchInfoReturnMsg(String msg, int code, List<BranchInfo> branchInfos,int branchcount){
        super(msg,code);
        this.branchInfoList=branchInfos;
        this.branchcount=branchcount;
    }

    public List<BranchInfo> getBranchInfoList() {
        return branchInfoList;
    }

    public void setBranchInfoList(List<BranchInfo> branchInfoList) {
        this.branchInfoList = branchInfoList;
    }
}
