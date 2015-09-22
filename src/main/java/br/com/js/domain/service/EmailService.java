package br.com.js.domain.service;
import br.com.js.domai.email.Email;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;  
import org.springframework.stereotype.Service;
/**
 * 
 * @author fernando
 */

 @Service 
public class EmailService {  
      
    @Autowired private JavaMailSender mailSender; 
     
    public EmailService() {
    }
    public void sendMail(Email email){  
        
        MimeMessage mime  = mailSender.createMimeMessage();
        
        MimeMessageHelper message;
        try {
            message = new MimeMessageHelper(mime,true,"UTF-8");   
            message.setValidateAddresses(true);
            message.setFrom("emailservicejs@gmail.com");
            message.setTo("batista.jailson@yahoo.com.br ");
            message.setText(email.getContent());
            message.setSubject(email.getSubject());
            message.addAttachment(email.getAttachmentName(), new ByteArrayResource(email.getAttachment().getBytes()));
            mime = message.getMimeMessage();
        } catch (MessagingException ex) {
            Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.mailSender.send(mime);
    }    
 

}   
