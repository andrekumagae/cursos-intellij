package br.com.xavecoding.regescweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
/*Anotação para o controller funcionar na classe*/
@Controller
public class HelloController {
    /*GetMapping serve como um atalho pra esse método*/
    @GetMapping("/hello-servlet")
    /*Forma mais antiga de fazer por servlet
    * Este método recebe uma requisição do arquivo Html*/
    public String hello(HttpServletRequest request) {
        /*Modificamos o nome que está no arquivo html*/
        request.setAttribute( "nome", "Samuka");
        return "hello";
    }

    @GetMapping("/hello-model")
    public String hello(Model model) {
        model.addAttribute("nome", "Zézinho");
        return "hello";
    }


    @GetMapping("/hello")
    /*Temos como utilizar o retorno por objetos pela classe ModelAndView*/
    public ModelAndView ModelAndView() {
        /*Instanciamos um objeto desta classe com o mesmo nome da página*/
        ModelAndView mv = new ModelAndView("hello");
        /*Chamamos os métodos para dar o novo nome*/
        mv.addObject("nome", "Maria");
        /*Retornamos o objeto*/
        return mv;
    }
}
