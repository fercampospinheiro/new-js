package br.com.js.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("servicos")
@Controller
public class ServicosController {

	@RequestMapping(value="/portaria", method= RequestMethod.GET)
	public String carregaTemplatePortaria() {
		return "servicos/portaria";
	}
	
	@RequestMapping(value="/zeladoria",method=RequestMethod.GET)
	public String carregaTemplateZeladoria() {
		return "servicos/zeladoria";
	}
	
	@RequestMapping(value= "/limpeza", method=RequestMethod.GET)
	public String carregaTemplateLimpeza() {
		return "servicos/limpeza";
	}
	
	@RequestMapping(value="/recepcao", method= RequestMethod.GET)
	public String carregaTemplateRecepcao() {
		return "servicos/recepcao";
	}
	
	@RequestMapping(value="/jardinagem",method=RequestMethod.GET)
	public String carregaTemplateJardinagem() {
		return "servicos/jardinagem";
	}
	
	@RequestMapping(value="/piscinas",method= RequestMethod.GET)
	public String carregaTemplateMatunencaoPiscinas() {
		return "servicos/piscinas";
	}
	
	@RequestMapping(value="/seguranca",method=RequestMethod.GET)
	public String carregaTemplateSeguranca() {
		return "servicos/seguranca";
	}
	
	
}
