package SO2.SO2_Trabalho2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SO2.SO2_Trabalho2.repository.UtilizadorRepository;
import SO2.SO2_Trabalho2.exception.ResourceNotFoundException;
import SO2.SO2_Trabalho2.model.Utilizador;

@Controller
@RequestMapping("/utilizador")
public class UtilizadorController {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UtilizadorRepository utilizadorRepository;

    @GetMapping("/show")
    public List<Utilizador> getAllUtilizadors() {
        return utilizadorRepository.findAll();
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Utilizador> getUtilizadorById(@PathVariable(value = "id") Long utilizadorId)
            throws ResourceNotFoundException {
        Utilizador utilizador = utilizadorRepository.findById(utilizadorId).orElseThrow(
                () -> new ResourceNotFoundException("utilizador not found for this id :: " + utilizadorId));
        return ResponseEntity.ok().body(utilizador);
    }

    @PostMapping("/add")
    public String createUtilizador(@ModelAttribute Utilizador utilizador) {
        utilizador.setPassword(passwordEncoder.encode(utilizador.getPassword()));
        utilizadorRepository.save(utilizador);
        return "redirect:/result";

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Utilizador> updateUtilizador(@PathVariable(value = "id") Long utilizadorId,
            @RequestBody Utilizador utilizadorDetails) throws ResourceNotFoundException {
        Utilizador utilizador = utilizadorRepository.findById(utilizadorId).orElseThrow(
                () -> new ResourceNotFoundException("utilizador not found for this id :: " + utilizadorId));

        utilizador.setUtilizador(utilizadorDetails.getUtilizador());
        final Utilizador updatedutilizador = utilizadorRepository.save(utilizador);
        return ResponseEntity.ok(updatedutilizador);
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteUtilizador(@PathVariable(value = "id") Long utilizadorId)
            throws ResourceNotFoundException {
        Utilizador utilizador = utilizadorRepository.findById(utilizadorId).orElseThrow(
                () -> new ResourceNotFoundException("utilizador not found for this id :: " + utilizadorId));

        utilizadorRepository.delete(utilizador);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
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