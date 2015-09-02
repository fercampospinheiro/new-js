package br.com.js.domai.email;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author fernando
 */
public class Email {
    private String subject;
    private String content;
    private String destination;
    private String origin;
    private MultipartFile attachment;
    private String attachmentName;

    public String getAttachmentName() {
        return attachmentName;
    }   

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public MultipartFile getAttachment() {
        return attachment;
    }

    public void attachFile(MultipartFile file) {
        this.attachment = file;
    }
    
   
}
