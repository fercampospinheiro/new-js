package br.com.js.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping("/")
    public String carregaTemplateIndex() {
        return "home/index";
    }
}
