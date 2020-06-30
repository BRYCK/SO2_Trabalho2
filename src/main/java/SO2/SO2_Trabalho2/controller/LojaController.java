package SO2.SO2_Trabalho2.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SO2.SO2_Trabalho2.exception.ResourceNotFoundException;
import SO2.SO2_Trabalho2.model.Loja;
import SO2.SO2_Trabalho2.model.Registo;
import SO2.SO2_Trabalho2.repository.LojaRepository;
import SO2.SO2_Trabalho2.repository.RegistoRepository;
import SO2.SO2_Trabalho2.repository.UtilizadorRepository;

@Controller
@RequestMapping("/loja")
public class LojaController {

    @Autowired
    private LojaRepository lojaRepository;

    @Autowired
    private UtilizadorRepository utilizadorRepository;

    @Autowired
    private RegistoRepository registoRepository;

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

    @RequestMapping("/registos/delete/{id}")
    public String deleteRegisto(@PathVariable(value = "id") Long registoId) throws ResourceNotFoundException {
        Registo registo = registoRepository.findById(registoId)
                .orElseThrow(() -> new ResourceNotFoundException("Registo not found for this id :: " + registoId));

        Loja loja = lojaRepository.findById(registo.getLoja().getId()).get();

        loja.getRegistos().remove(registo);

        lojaRepository.save(loja);
        return "redirect:/";
    }

    @RequestMapping("/registos/inf/{id}")
    public String displayLojaInfo(@PathVariable(value="id") Long lojaId, Model modelLoja, Model modelRegistos, Model modelStr) throws ResourceNotFoundException{
        Loja loja = lojaRepository.findById(lojaId).orElseThrow(() -> new ResourceNotFoundException("Loja not found for this id :: " + lojaId));
        modelLoja.addAttribute("loja", loja);

        Timestamp sysdate= new Timestamp(java.lang.System.currentTimeMillis()-3600000);

        List<Registo> registosUltimahora= lojaRepository.findRegLastHour(sysdate,lojaId);
        modelRegistos.addAttribute("registosUltimaHora", registosUltimahora);

        String dono=loja.getUtilizador().getUtilizador();
        modelStr.addAttribute("dono", dono);

        return "lojaInfo";
        
    }

}
