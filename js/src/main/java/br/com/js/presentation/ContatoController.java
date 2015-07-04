package br.com.js.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/contato")
public class ContatoController {

	@RequestMapping(method = RequestMethod.GET)
	public String carregaTemplateContato() {
		return "contato/contato";
	}
}
