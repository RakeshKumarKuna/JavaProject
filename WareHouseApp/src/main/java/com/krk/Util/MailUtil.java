package com.krk.Util;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import jakarta.mail.internet.MimeMessage;

@Component
public class MailUtil {
	@Autowired
	private JavaMailSender mail;
	Integer count=0;
        public boolean sendemail(
                                                     String to,String subject,String text
        		                                           ) throws Exception {
                 boolean flag=false;
        		MimeMessage mime=mail.createMimeMessage();
        		MimeMessageHelper helper=new MimeMessageHelper(mime,true);
        		helper.setTo(to);
        		helper.setSubject(subject);
        		helper.setText(text);
        		helper.setFrom("Warehouse@gmail.com");
        		helper.setPriority(3);
        		helper.setSentDate(new Date());
        		 boolean b=helper.isValidateAddresses();
        		 System.out.println(++count);
        		mail.send(mime);
        		flag=true;
              	return flag;
        }
}

