package top.gamewan.bms.sharedcarbms.Dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import top.gamewan.bms.sharedcarbms.Dao.MailDao;
@Component
public class MailDaoImpl implements MailDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public boolean setCodeToDB(String toAddress, String code) {
        String sql="update tmpmailcode set code=? sendtime=now() where mailaddress=?";
        int issend=-1;
        try{
            issend=jdbcTemplate.update(sql,new Object[]{code,toAddress});
        }catch (Exception e){
            e.printStackTrace();
        }
        return issend==1?true:false;
    }

    @Override
    public boolean insertCodeToDB(String toAddress, String code) {
        String sql="insert into tmpmailcode(id,mailaddress,code,sendtime) values(null,?,?,now())";
        int issend=-1;
        try {
            issend =jdbcTemplate.update(sql,new Object[]{toAddress,code});
        }catch (Exception e){
            e.printStackTrace();
        }
        return issend==1?true:false;
    }

    @Override
    public boolean checkCode(String toAddress, String code) {
        String sql="select code from tmpmailcode where mailaddress=?";
        String realcode=null;
        try{
            realcode=(String)jdbcTemplate.queryForObject(sql,new Object[]{toAddress},String.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(realcode!=null && realcode.equals(code))
            return true;
        else
            return false;
    }
}
