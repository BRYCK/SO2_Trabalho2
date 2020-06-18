package SO2.SO2_Trabalho2.services;

import org.springframework.beans.factory.annotation.Autowired;

import SO2.SO2_Trabalho2.repository.LojasRepository;
import java.util.ArrayList;
import SO2.SO2_Trabalho2.model.Lojas;

public class LojasService {
    
    @Autowired
    LojasRepository lojaRepo;

    public ArrayList<Lojas> getAllLojas(){
        ArrayList<Lojas> lojas=new ArrayList<>();
        lojaRepo.findAll().forEach(lojas :: add);
        return lojas;
    }

    public Lojas getLojas(long id){
        return lojaRepo.findById(id).orElse(null);
    }

    public void addLojas(Lojas loja){
        lojaRepo.save(loja);
    }

    public void deleteLojas(long id){
        lojaRepo.deleteById(id);
    }
    
}