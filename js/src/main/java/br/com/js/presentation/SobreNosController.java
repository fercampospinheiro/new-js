package br.com.js.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sobreNos")
public class SobreNosController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String carregaTamplateSobreNos() {
		return "/sobrenos/sobre-nos";
		
	}
	

}
