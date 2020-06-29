package SO2.SO2_Trabalho2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SO2.SO2_Trabalho2.exception.ResourceNotFoundException;
import SO2.SO2_Trabalho2.model.Loja;
import SO2.SO2_Trabalho2.model.Registo;
import SO2.SO2_Trabalho2.model.Utilizador;
import SO2.SO2_Trabalho2.repository.LojaRepository;
import SO2.SO2_Trabalho2.repository.UtilizadorRepository;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/loja")
public class LojaController {

    @Autowired
    private LojaRepository lojaRepository;

    @Autowired
    private UtilizadorRepository utilizadorRepository;

    @RequestMapping("/getAll")
    public List<Loja> getAllLojas() {
        return lojaRepository.findAll();
    }

    @RequestMapping("/get/{id}")
    public ResponseEntity<Loja> getLojaById(@PathVariable(value = "id") Long lojaId) throws ResourceNotFoundException {
        Loja loja = lojaRepository.findById(lojaId)
                .orElseThrow(() -> new ResourceNotFoundException("Loja not found for this id :: " + lojaId));
        return ResponseEntity.ok().body(loja);
    }

    @RequestMapping("/add/{id}")
    public String createLoja(@ModelAttribute Loja loja, @PathVariable(value = "id") Long usersId) {
        loja.setUtilizador(utilizadorRepository.findById(usersId).get());
        lojaRepository.save(loja);
        return "redirect:/result";
    }

    @RequestMapping("/registossssss/{id}")
    public List<Registo> getLojaRegistos(@PathVariable(value = "id") Long lojaId) throws ResourceNotFoundException {
        Loja loja = lojaRepository.findById(lojaId)
                .orElseThrow(() -> new ResourceNotFoundException("Loja not found for this id :: " + lojaId));
        return loja.getRegistos();
    }

    @RequestMapping("/registosHora")
    public List<Registo> getLojaRegistosHora(@RequestParam(value = "hora") Long hora,
            @RequestParam(value = "lojaId") Long lojaId) {
        return lojaRepository.findRegistoLastHour(hora, lojaId);
    }

    @RequestMapping("/registosAll")
    public String getLojasUtilizadores(Model model) {
        model.addAttribute("lojas", lojaRepository.findAll());
        return "lojas";
    }

    @RequestMapping("/registos/{utilizador}")
    public String requestMethodName(@PathVariable(value = "utilizador") String utilizadorNome, Model model) {
        Loja loja = lojaRepository.findByUtilizador(utilizadorRepository.findByUtilizador(utilizadorNome));
        model.addAttribute("registos", loja.getRegistos());

        return "registos";
    }

}
