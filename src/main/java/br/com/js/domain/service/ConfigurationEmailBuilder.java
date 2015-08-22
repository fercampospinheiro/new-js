
package br.com.js.domain.service;

/**
 *
 * @author fernando
 */
public class ConfigurationEmailBuilder {
    
    private ConfigurationEmail configurationEmail;

    public ConfigurationEmailBuilder() {
        this.configurationEmail = new ConfigurationEmail();
    }
    
    public ConfigurationEmailBuilder SMTP(String stmp){
        this.configurationEmail.put("mail.transport.protocol", "smtp");
        this.configurationEmail.put("mail.smtp.host",stmp);
        return this;
    }
    
    public ConfigurationEmailBuilder portSMTPserver(String port){
        this.configurationEmail.put("mail.smtp.socketFactory.port", port);
        return this;
    }
    
    
    public ConfigurationEmailBuilder TLS(boolean status){
        this.configurationEmail.put("mail.smtp.starttls.enable",status);
        return this;
    }
    
    public ConfigurationEmailBuilder Authentication(boolean status ){
       this.configurationEmail.put("mail.smtp.auth", status);
        return this;  
    }
    public ConfigurationEmailBuilder USER(String user){
        this.configurationEmail.put("mail.smtp.user", user);
        return this;
    }
    
    public ConfigurationEmailBuilder modeDebug(boolean status){
        this.configurationEmail.put("mail.debug", status);
        return this;
    }
    
    public ConfigurationEmailBuilder classSocket(String classSocket){
        this.configurationEmail.put("mail.smtp.socketFactory.class", classSocket);
        return this;
    }
    
    public ConfigurationEmailBuilder fallback(boolean status){
        this.configurationEmail.put("mail.smtp.socketFactory.fallback", status);
        return this;
    }
		  
    public ConfigurationEmailBuilder getConfigurationDefault(){
        this.SMTP("smtp.gmail.com")
                .portSMTPserver("465")
                .TLS(true)
                .Authentication(true)
                .classSocket("javax.net.ssl.SSLSocketFactory")
                .modeDebug(true)
                .fallback(false);
        return this;
    }  
    
    public ConfigurationEmail builder(){
        return this.configurationEmail;
    }
    
    
}
