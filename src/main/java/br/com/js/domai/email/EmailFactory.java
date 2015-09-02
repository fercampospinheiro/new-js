/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.js.domai.email;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author fernando
 */
@Component
public class EmailFactory {
    
    public Email curriculumWorkWhitUs(String subject,MultipartFile attachment ){
        Email email = new  Email();
        email.setContent(getContentWorkWhitUs());
        email.setSubject(getSubject(subject));
        email.attachFile(attachment);
        email.setOrigin("fercampospinheiro@gmail.com");
        email.setDestination("fercampospinheiro@gmail.com");
        email.setAttachmentName(attachment.getOriginalFilename());
        
        return email;
    }

    private String getContentWorkWhitUs(){
        return "Você recebeu um novo currículo. Clique no anexo abaixo.";
    }
    private String getSubject(String subject){
        return "currículo do(a) "+ subject;
    }
    
}
