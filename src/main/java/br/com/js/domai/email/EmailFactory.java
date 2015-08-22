/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.js.domai.email;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author fernando
 */
@Component
public class EmailFactory {
    
    public Email curriculumWorkWhitUs(String Subject,MultipartFile attachment ){
        Email email = new  Email();
        email.setContent(getContentWorkWhitUs());
        email.setSubject(Subject);
        
        try {
            File file = multipartToFile(attachment);
            email.attachFile(file);
        } catch (IllegalStateException ex) {
            Logger.getLogger(EmailFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EmailFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        email.setOrigin("fercampospinheiro@gmail.com");
        email.setDestination("fercampospinheiro@gmail.com");
      
        return email;
    
    }

    private String getContentWorkWhitUs(){
        return "você recebeu um novo currículo";
    }

     private File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
        File convFile = new File( multipart.getOriginalFilename());
        multipart.transferTo(convFile);
        return convFile;
    }
}
