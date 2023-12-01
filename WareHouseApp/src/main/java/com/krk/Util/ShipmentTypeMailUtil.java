package com.krk.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import jakarta.mail.internet.MimeMessage;
@Component
public class ShipmentTypeMailUtil {
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
        		//helper.setBcc(bcc);
        		helper.setText(text);
        		//helper.addAttachment(file.getOriginalFilename(), file);
        		helper.setFrom("Warehouse@gmail.com");
        		//helper.addAttachment("II.mp4",new ClassPathResource("II.mp4"));
        		helper.setPriority(3);
        		//helper.setSentDate(new Date());
        		 boolean b=helper.isValidateAddresses();
        		 System.out.println(++count);
        		mail.send(mime);
        		flag=true;
              	return flag;
        }
             
}

