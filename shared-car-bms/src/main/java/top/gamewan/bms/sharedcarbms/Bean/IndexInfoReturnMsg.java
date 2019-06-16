package top.gamewan.bms.sharedcarbms.Bean;


import java.util.List;

public class IndexInfoReturnMsg extends ReturnMsg {
    private IndexInfo indexInfo;
    private List<Integer> expected;

    public List<Integer> getExpected() {
        return expected;
    }

    public void setExpected(List<Integer> expected) {
        this.expected = expected;
    }

    public List<Integer> getActual() {
        return actual;
    }

    public void setActual(List<Integer> actual) {
        this.actual = actual;
    }

    private List<Integer> actual;
    public IndexInfoReturnMsg(String msg, int code) {
        super(msg, code);
    }
    public IndexInfoReturnMsg(String msg,int code,IndexInfo indexInfo,List<Integer> expected,List<Integer> actual){
        super(msg,code);
        this.indexInfo=indexInfo;
        this.expected=expected;
        this.actual=actual;
    }

    public IndexInfo getIndexInfo() {
        return indexInfo;
    }

    public void setIndexInfo(IndexInfo indexInfo) {
        this.indexInfo = indexInfo;
    }
}
