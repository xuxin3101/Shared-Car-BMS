package top.gamewan.bms.sharedcarbms.Bean;



public class IndexInfoReturnMsg extends ReturnMsg {
    private IndexInfo indexInfo;
    public IndexInfoReturnMsg(String msg, int code) {
        super(msg, code);
    }
    public IndexInfoReturnMsg(String msg,int code,IndexInfo indexInfo){
        super(msg,code);
        this.indexInfo=indexInfo;
    }

    public IndexInfo getIndexInfo() {
        return indexInfo;
    }

    public void setIndexInfo(IndexInfo indexInfo) {
        this.indexInfo = indexInfo;
    }
}
