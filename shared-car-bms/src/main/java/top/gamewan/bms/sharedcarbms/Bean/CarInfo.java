package top.gamewan.bms.sharedcarbms.Bean;

public class CarInfo {
    private Integer id;
    private  String numberplate;
    private String model;
    private String color;
    private String status;
    private Integer endurancemail;
    private Integer statustime;

    public Integer getLease() {
        return lease;
    }

    public void setLease(Integer lease) {
        this.lease = lease;
    }

    private String parkplace;
    private Integer lease;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getEndurancemail() {
        return endurancemail;
    }

    public void setEndurancemail(Integer endurancemail) {
        this.endurancemail = endurancemail;
    }

    public Integer getStatustime() {
        return statustime;
    }

    public void setStatustime(Integer statustime) {
        this.statustime = statustime;
    }

    public String getParkplace() {
        return parkplace;
    }

    public void setParkplace(String parkplace) {
        this.parkplace = parkplace;
    }

    public Integer getParkmoney() {
        return parkmoney;
    }

    public void setParkmoney(Integer parkmoney) {
        this.parkmoney = parkmoney;
    }

    private Integer parkmoney;




}
