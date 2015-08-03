package br.com.js.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SobreNosController {
	
	@RequestMapping("/sobreNos")
	public String carregaTamplateSobreNos() {
		return "sobrenos/sobre-nos";
		
	}
	

}
