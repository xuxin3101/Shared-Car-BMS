package top.gamewan.bms.sharedcarbms.Bean;

public class IndexInfo {
    private int userCount;
    private int todayUserCarCount;
    private int todaywelcomeCount;

    public int getTodayUserCarCount() {
        return todayUserCarCount;
    }

    public void setTodayUserCarCount(int todayUserCarCount) {
        this.todayUserCarCount = todayUserCarCount;
    }

    public int getTodaywelcomeCount() {
        return todaywelcomeCount;
    }

    public void setTodaywelcomeCount(int todaywelcomeCount) {
        this.todaywelcomeCount = todaywelcomeCount;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    private int carCount;

}
