package top.gamewan.bms.sharedcarbms.Dao;

public interface MailDao {
    boolean setCodeToDB(String toAddress,String code);
    boolean insertCodeToDB(String toAddress,String code);
    boolean checkCode(String toAddress,String code);
}
