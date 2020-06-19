package SO2.SO2_Trabalho2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import SO2.SO2_Trabalho2.repository.LojasRepository;
import java.util.ArrayList;
import SO2.SO2_Trabalho2.model.Lojas;

//@RestController
public class LojasService {

    @Autowired
    LojasRepository lojaRepo;

    // @GetMapping("/lojas")
    public ArrayList<Lojas> getAllLojas() {
        ArrayList<Lojas> lojas = new ArrayList<>();
        lojaRepo.findAll().forEach(lojas::add);
        return lojas;
    }

    // @GetMapping("/lojas/{id}")
    public Lojas getLojas(long id) {
        return lojaRepo.findById(id).orElse(null);
    }

    public void addLojas(Lojas loja) {
        lojaRepo.save(loja);
    }

    public void deleteLojas(long id) {
        lojaRepo.deleteById(id);
    }

}