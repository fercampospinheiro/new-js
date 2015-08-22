
package br.com.js.presentation;

import br.com.js.domain.service.EmailService;
import br.com.js.domai.email.Email;
import br.com.js.domai.email.EmailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author fernando
 */

@Controller
@RequestMapping("/trabalheConosco")
public class TrabalheConoscoController {
    
    @Autowired private EmailService service;
    @Autowired private EmailFactory factory;
    
    @RequestMapping(method = RequestMethod.GET)
    public String carregaTemplateTrabalheConosco(){
        return "trabalheConosco/trabalhe-conosco";
    }
    @RequestMapping(value="/enviaCurriculo",method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("nameCollaborator") String nameCollaborator,Model model){
        
        Email email = factory.curriculumWorkWhitUs(nameCollaborator, file);
        service.sendMail(email);
        model.addAttribute("ok", "email enviado com sucesso");
        
        return "/trabalheConosco/trabalhe-conosco";
    }
    
}
