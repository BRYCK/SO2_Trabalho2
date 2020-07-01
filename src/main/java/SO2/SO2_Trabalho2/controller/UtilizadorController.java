package SO2.SO2_Trabalho2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import SO2.SO2_Trabalho2.repository.UtilizadorRepository;
import SO2.SO2_Trabalho2.exception.ResourceNotFoundException;
import SO2.SO2_Trabalho2.model.Loja;
import SO2.SO2_Trabalho2.model.Utilizador;

@Controller
@RequestMapping("/utilizador")
public class UtilizadorController {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UtilizadorRepository utilizadorRepository;

    @RequestMapping("/show")
    public String getAllUtilizadors(Model model1, Model model2) {
        model1.addAttribute("utilizadores", utilizadorRepository.findAll());
        model2.addAttribute("loja", new Loja());
        return "utilizadores2";
    }

    @RequestMapping("/add")
    public String createUtilizador(@ModelAttribute Utilizador utilizador) {
        utilizador.setPassword(passwordEncoder.encode(utilizador.getPassword()));
        utilizadorRepository.save(utilizador);
        return "redirect:/result";

    }

    @RequestMapping("/delete/{id}")
    public String deleteUtilizador(@PathVariable(value = "id") Long utilizadorId) throws ResourceNotFoundException {
        Utilizador utilizador = utilizadorRepository.findById(utilizadorId).orElseThrow(
                () -> new ResourceNotFoundException("utilizador not found for this id :: " + utilizadorId));

        utilizadorRepository.delete(utilizador);
        return "redirect:/result";
    }

    @GetMapping("/INIT")
    public void init() {
        Utilizador user1 = new Utilizador("Joao", passwordEncoder.encode("joao123"), "ADMIN");
        utilizadorRepository.save(user1);
        Utilizador user2 = new Utilizador("Diogo", passwordEncoder.encode("diogo69"), "ADMIN");
        utilizadorRepository.save(user2);
        Utilizador user3 = new Utilizador("Miguel", passwordEncoder.encode("leguim"), "USER");
        utilizadorRepository.save(user3);
        Utilizador user4 = new Utilizador("Vasco", passwordEncoder.encode("boloDaPadariaBrasileira"), "USER");
        utilizadorRepository.save(user4);

    }
}