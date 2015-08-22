package br.com.js.domain.service;
import br.com.js.domain.service.ConfigurationEmailBuilder;
import br.com.js.domain.service.ConfigurationEmail;
import br.com.js.domai.email.Email;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;  
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;  
import javax.mail.PasswordAuthentication;   
import org.springframework.stereotype.Service;

 @Service 
public class EmailService {  
      
    private final String USUARIO = "fercampospinheiro@gmail.com";
    private final String  SENHA = "sueli2011";
    private Email email;
    
    public EmailService() {
    }
    
    private ConfigurationEmail obtemConfiguracoesEmail(){   
         return new ConfigurationEmailBuilder()
                    .getConfigurationDefault()
                    .USER(USUARIO)
                    .builder();
    }
    
    private MimeBodyPart getBodyPart() {
        try {
            MimeBodyPart body = new MimeBodyPart();
            DataSource fds=new FileDataSource(email.getAttachment());
            body.setDataHandler(new DataHandler(fds));
            body.setFileName(email.getAttachment().getAbsolutePath());
            body.setText("anexo");
            return body;
        } catch (MessagingException ex) {
            Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public void sendMail(Email email) {  
          
        this.email = email;
        
    	ConfigurationEmail configuracoes = obtemConfiguracoesEmail();
        
        Autenticadora autentica = new Autenticadora (USUARIO,SENHA);  
      
        Session sessao = Session.getDefaultInstance(configuracoes, autentica);  
        sessao.setDebug(true);  
  
        
        
        Multipart mp = new MimeMultipart();
        MimeBodyPart bodyPart = getBodyPart();
        Message mensagem = new MimeMessage(sessao);  
        
        try {
             mp.addBodyPart(bodyPart);
             mensagem.setContent(mp);       
         } catch (MessagingException e1) {
             e1.printStackTrace();
         }
        
        try {  
            mensagem.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getDestination()));  
            mensagem.setFrom(new InternetAddress(email.getOrigin())); 
            mensagem.setSubject(email.getSubject());   
            mensagem.setContent(email.getContent(),"text/html");  
        } catch (Exception e) {  
            System.out.println("Erro ao preparar conteudo do e-mail!");  
            e.printStackTrace();  
        }  
           
        Transport transportadorEmail;  
        try {  
            transportadorEmail = sessao.getTransport("smtp");  
            transportadorEmail.connect(obtemConfiguracoesEmail().getServerSMTP(), USUARIO, SENHA);  
            mensagem.saveChanges();
            transportadorEmail.sendMessage(mensagem, mensagem.getAllRecipients());  
            transportadorEmail.close();  
        } catch (Exception e) {  
            System.out.println("Erro ao enviar e-mail!");  
            e.printStackTrace();  
        }  
  
    }  
}  


class Autenticadora extends Authenticator {  
    public String usuario = null;  
    public String senha = null;  
  
    public Autenticadora(String user, String pwd) {  
        usuario = user;  
        senha = pwd;  
    }  
  
    protected PasswordAuthentication getPasswordAuthentication() {  
        return new PasswordAuthentication (usuario,senha);  
    }  
}   