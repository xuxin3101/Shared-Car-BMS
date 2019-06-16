package top.gamewan.bms.sharedcarbms.Bean;

import java.util.List;

public class CarInfoReturnMsg extends ReturnMsg {
    public CarInfoReturnMsg(String msg, int code) {
        super(msg, code);
    }

    public CarInfoReturnMsg(String msg, int code, int carCount, List<CarInfo> carInfos) {
        super(msg, code);
        CarCount = carCount;
        this.carInfos = carInfos;
    }

    public int getCarCount() {
        return CarCount;
    }

    public void setCarCount(int carCount) {
        CarCount = carCount;
    }

    public List<CarInfo> getCarInfos() {
        return carInfos;
    }

    public void setCarInfos(List<CarInfo> carInfos) {
        this.carInfos = carInfos;
    }

    private int CarCount;
    private List<CarInfo> carInfos;

}
