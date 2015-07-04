package br.com.js.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/duvidas")	
public class DuvidasController {

	@RequestMapping(method = RequestMethod.GET)
	public String carregaTemplateDuvidas() {
		return "duvidas/duvidas";
	}
	
	
}
