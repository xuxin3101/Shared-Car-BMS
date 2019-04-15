package top.gamewan.bms.sharedcarbms.Services.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import top.gamewan.bms.sharedcarbms.Bean.Mail;
import top.gamewan.bms.sharedcarbms.Dao.MailDao;
import top.gamewan.bms.sharedcarbms.Services.MailServices;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailServicesImpl implements MailServices {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Environment env;
    @Autowired
    private MailDao mailDao;
    @Override
    public boolean sendMail(Mail mail) {
        if(mail==null){
            return false;
        }
        MimeMessage mimeMessage=null;
        try {
            mimeMessage=javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setFrom(env.getProperty("spring.mail.username"));
            mimeMessageHelper.setTo(mail.getToAddress());
            mimeMessageHelper.setSubject(mail.getTitle());
            mimeMessageHelper.setText(mail.getContent());
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    @Override
    public boolean sendRegisterMail(String toAddress) {
        Mail mail=new Mail();
        mail.setTitle("欢迎您注册");
        String code= RandomStringUtils.randomAlphabetic(6);
        mail.setContent("您的注册码是:"+code);
        mail.setToAddress(toAddress);
        boolean isSetInDB=false;
        if(mailDao.insertCodeToDB(toAddress,code)==false){
            isSetInDB=mailDao.setCodeToDB(toAddress,code);
        }else{
            isSetInDB=true;
        }
        if(isSetInDB==false){
            return false;
        }
        return sendMail(mail);
    }
}
