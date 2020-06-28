package SO2.SO2_Trabalho2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import SO2.SO2_Trabalho2.repository.LojaRepository;

@Controller
@RequestMapping("/loja")
public class LojaController {

    @Autowired
    private LojaRepository lojaRepository;

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

    @RequestMapping("/create")
    public String createLoja(@ModelAttribute Loja loja) {
        lojaRepository.save(loja);
        return "redirect:/result";
    }

    @RequestMapping("/registos/{id}")
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

}