package br.com.js.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NoticiasController {

    @RequestMapping(value = "noticias/{indiceNoticia}/{linkNoticia}", method = RequestMethod.GET)
    public String carregaTemplateNoticias(@PathVariable("indiceNoticia") int indiceNoticia , @PathVariable String linkNoticia ,Model model){
    	model.addAttribute("indiceNoticia",indiceNoticia);
    	return "noticias/noticias";
    }
    
}
