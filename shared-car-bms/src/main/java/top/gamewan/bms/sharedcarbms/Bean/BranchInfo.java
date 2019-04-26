package top.gamewan.bms.sharedcarbms.Bean;

public class BranchInfo {
    private int id;
    private String name;
    private String type;
    private String placplace;
    private int count;
    private int flow;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlacplace() {
        return placplace;
    }

    public void setPlacplace(String placplace) {
        this.placplace = placplace;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }
}
