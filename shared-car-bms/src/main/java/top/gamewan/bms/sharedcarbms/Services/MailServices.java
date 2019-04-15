package top.gamewan.bms.sharedcarbms.Services;

import top.gamewan.bms.sharedcarbms.Bean.Mail;

public interface MailServices {
    boolean sendMail(Mail mail);

    boolean sendRegisterMail(String toAddress);
}
