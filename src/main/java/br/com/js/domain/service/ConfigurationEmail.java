/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.js.domain.service;

import java.util.Properties;

/**
 *
 * @author fernando
 */
public class ConfigurationEmail extends Properties{
    
    public ConfigurationEmail() {
        super();
    } 
    
    public String getServerSMTP(){
        return (String)this.get("mail.smtp.host");
    }
    
}
