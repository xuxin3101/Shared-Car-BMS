package top.gamewan.bms.sharedcarbms.Services;

import top.gamewan.bms.sharedcarbms.Bean.CarInfo;

import java.util.List;

public interface CarServices {
    List<CarInfo> getLeaseCar(int page,int count);
    List<CarInfo> getUnLeaseCar(int page,int count);
    boolean insertCar(String numberplate,String model,String color,String status,Integer endurancemail,
                      Integer statustime,String parkplace,Integer parkmoney,Integer lease);
    boolean deleteCar(Integer id);
    int getLeaseCarCount();
    int getUnLeaseCarCount();
}
