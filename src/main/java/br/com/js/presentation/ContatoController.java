package br.com.js.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.js.domain.contato.Contato;

@Controller
@RequestMapping("/contato")
public class ContatoController {

	@RequestMapping(method = RequestMethod.GET)
	public String carregaTemplateContato(Model model) {
		Contato contato = new  Contato();
		model.addAttribute("contato", contato);
		return "contato/contato";
	}
	
	@RequestMapping(value="/salvar",method=RequestMethod.POST)
	private String salvar(Contato contato){
		EmailService emailService = new EmailService();
		emailService.enviaEmail("fercampospinheiro@gmail.com", "fercampospinheiro@gmail.com", "Teste da js", contato.getMensagem());
		
		return "contato/contato";
	}
}
