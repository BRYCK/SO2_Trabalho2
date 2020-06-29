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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import SO2.SO2_Trabalho2.repository.RegistoRepository;
import SO2.SO2_Trabalho2.exception.ResourceNotFoundException;
import SO2.SO2_Trabalho2.model.Registo;

@Controller
@RequestMapping("/registo")
public class RegistoController {

    @Autowired
    private RegistoRepository registoRepository;

    @RequestMapping("/getAll")
    public List<Registo> getAllRegistos() {
        return registoRepository.findAll();
    }

    @RequestMapping("/get/{id}")
    public ResponseEntity<Registo> getRegistoById(@PathVariable(value = "id") Long registoId)
            throws ResourceNotFoundException {
        Registo registo = registoRepository.findById(registoId)
                .orElseThrow(() -> new ResourceNotFoundException("Registo not found for this id :: " + registoId));
        return ResponseEntity.ok().body(registo);
    }

    @RequestMapping("/create/{utilizador}")
    public String createRegisto(@ModelAttribute Registo registo, @PathVariable(value="utilizador") String username) {
        registoRepository.save(registo);
        return "redirect:/mystore";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUtilizador(@PathVariable(value = "id") Long registoId) {
        Registo registo = registoRepository.findById(registoId).get();

        registoRepository.delete(registo);
        return "redirect:/";
    }

}