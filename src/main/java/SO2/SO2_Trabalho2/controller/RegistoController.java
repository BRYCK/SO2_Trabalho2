package SO2.SO2_Trabalho2.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import SO2.SO2_Trabalho2.repository.LojaRepository;
import SO2.SO2_Trabalho2.repository.RegistoRepository;
import SO2.SO2_Trabalho2.repository.UtilizadorRepository;
import SO2.SO2_Trabalho2.exception.ResourceNotFoundException;
import SO2.SO2_Trabalho2.model.Loja;
import SO2.SO2_Trabalho2.model.Registo;

@Controller
@RequestMapping("/registo")
public class RegistoController {

    private Date data = new Date();

    @Autowired
    private RegistoRepository registoRepository;

    @Autowired
    private LojaRepository lojaRepository;

    @Autowired
    private UtilizadorRepository utilizadorRepository;


    @RequestMapping("/add/{utilizador}")
    public String createRegisto(@ModelAttribute Registo registo, @PathVariable(value = "utilizador") String username) {
        Loja loja = lojaRepository.findByUtilizador(utilizadorRepository.findByUtilizador(username));
        loja.setOcupacao(registo.getOcupacao());
        registo.setLoja(loja);

        registo.setData(data.getTime());
        registoRepository.save(registo);
        return "redirect:/mystore";
    }

    @RequestMapping("/delete/{id}")
    public String deleteRegisto(@PathVariable(value = "id") Long registoId) throws ResourceNotFoundException {
        registoRepository.deleteById(registoId);
        return "redirect:/";
    }

}