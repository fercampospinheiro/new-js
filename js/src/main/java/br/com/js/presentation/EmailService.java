package br.com.js.presentation;
import java.util.Properties;  

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;  
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;   
import javax.mail.Authenticator;  
import javax.mail.PasswordAuthentication;   

import org.springframework.stereotype.Service;

 @Service 
public class EmailService {  
      
    private String servidorSMTP;  
    private String portaServidorSMTP;  
    private final String USUARIO = "fercampospinheiro@gmail.com";
    private final String  SENHA = "sueli2011";
    
    EmailService() {    
        servidorSMTP = "smtp.gmail.com";  
        portaServidorSMTP = "465";  
    }  

    EmailService(String servidorSMTP, String portaServidorSMTP) {  
        this.servidorSMTP = servidorSMTP;  
        this.portaServidorSMTP = portaServidorSMTP;  
    }  
      
    
    private Properties obtemConfiguracoesPadraoParaEnvioDeEmail(){
    	  Properties configuracoes = new Properties();  

		  configuracoes.put("mail.transport.protocol", "smtp"); 
		  configuracoes.put("mail.smtp.starttls.enable","true");   
		  configuracoes.put("mail.smtp.host", servidorSMTP);  
		  configuracoes.put("mail.smtp.auth", "true"); //ativa autenticacao  
		  configuracoes.put("mail.smtp.user", USUARIO);   
		  configuracoes.put("mail.debug", "true");  
		  configuracoes.put("mail.smtp.port", portaServidorSMTP);   
		  configuracoes.put("mail.smtp.socketFactory.port", portaServidorSMTP);   
		  configuracoes.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");  
		  configuracoes.put("mail.smtp.socketFactory.fallback", "false");  
	  	return configuracoes;
    }
    
    
    public void enviaEmail(String emailOrigem, String emailDestino, String assunto, String conteudoEmail) {  
          
    	Properties configuracoes = obtemConfiguracoesPadraoParaEnvioDeEmail();
        Autenticadora autentica = new Autenticadora (USUARIO,SENHA);  
      
        Session sessao = Session.getDefaultInstance(configuracoes, autentica);  
        sessao.setDebug(true);  
  
        MimeBodyPart bodyPart = new MimeBodyPart();
        try {
			bodyPart.setText("anexo");
		} catch (MessagingException e1) {
			e1.printStackTrace();
		}
        
        Message mensagem = new MimeMessage(sessao);  
  
        
        Multipart mp = new javax.mail.internet.MimeMultipart();
        DataSource source = new FileDataSource("../js.iml");
        
        try {
			bodyPart.setDataHandler(new DataHandler(source));
		} catch (MessagingException e1) {
			e1.printStackTrace();
		}
        
        try {
			bodyPart.setFileName("../js.iml");
		} catch (MessagingException e1) {
			e1.printStackTrace();
		}
        
        try {
			mp.addBodyPart(bodyPart);
		} catch (MessagingException e1) {
			e1.printStackTrace();
		}
        
        try {
			mensagem.setContent(mp);
		} catch (MessagingException e1) {
			e1.printStackTrace();
		}
        
        try {  
            mensagem.setRecipient(Message.RecipientType.TO, new InternetAddress(emailDestino));  
            mensagem.setFrom(new InternetAddress(emailOrigem)); 
            mensagem.setSubject(assunto);   
            mensagem.setContent(conteudoEmail,"text/plain");  
  
        } catch (Exception e) {  
            System.out.println("Erro ao preparar conteudo do e-mail!");  
            e.printStackTrace();  
        }  
           
        Transport tasnportadorEmail;  
        try {  
            tasnportadorEmail = sessao.getTransport("smtp");  
            tasnportadorEmail.connect(servidorSMTP, USUARIO, SENHA);  
            mensagem.saveChanges();
            tasnportadorEmail.sendMessage(mensagem, mensagem.getAllRecipients());  
            tasnportadorEmail.close();  
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