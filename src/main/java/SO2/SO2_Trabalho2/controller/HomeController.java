package SO2.SO2_Trabalho2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import SO2.SO2_Trabalho2.model.Loja;
import SO2.SO2_Trabalho2.model.Registo;
import SO2.SO2_Trabalho2.model.Utilizador;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String red() {
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin")
    public String user(Model model) {
        model.addAttribute("utilizador", new Utilizador());
        return "admin";
    }

    @GetMapping("/lojas")
    public String lojas(Model model1, Model model2) {
        model1.addAttribute("loja", new Loja());
        return "lojas";
    }

    @GetMapping("/result")
    public String result() {
        return "result";
    }

    @GetMapping("/utilizadores2")
    public String utilizadores2(Model model) {
        model.addAttribute("loja", new Loja());
        return "utilizadores2";
    }

    @RequestMapping("/mapa")
    public String mapa() {
        return "mapa";
    }

    @GetMapping("/mystore")
    public String mystore(Model model) {
        model.addAttribute("registo", new Registo());
        return "mystore";
    }

    @GetMapping("/lojaInfo")
    public String lojaInfo(Model model1){
        model1.addAttribute("loja", new Loja());
        return "lojaInfo";
    }

}