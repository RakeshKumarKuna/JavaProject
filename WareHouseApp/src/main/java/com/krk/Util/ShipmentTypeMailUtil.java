package com.krk.Util;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import jakarta.mail.internet.MimeMessage;
@Component
public class ShipmentTypeMailUtil {
	@Autowired
	private JavaMailSender mail;
        public boolean sendemail(
                                                       String to,String subject,String text
        		                                           ) throws Exception {
                 boolean flag=false;
        		MimeMessage mime=mail.createMimeMessage();
        		MimeMessageHelper helper=new MimeMessageHelper(mime,true);
        		helper.setTo(to);
        		helper.setSubject(subject);
        		//helper.setBcc(bcc);
        		helper.setText(text);
        		//helper.addAttachment(file.getOriginalFilename(), file);
        		helper.setFrom("hdfcbankcarrer@gmail.com");
        		helper.addAttachment("image",new ClassPathResource("WhUserType.jpg"));
        		helper.setPriority(1);
        		helper.setSentDate(new Date());
        		mail.send(mime);
        		flag=true;
              	return flag;
        }
             
}

