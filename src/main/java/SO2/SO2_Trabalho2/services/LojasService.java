package SO2.SO2_Trabalho2.services;

import org.springframework.beans.factory.annotation.Autowired;

import SO2.SO2_Trabalho2.repository.LojasRepository;
import java.util.List;

public class LojasService {
    
    @Autowired
    LojasRepository lojaRepo;

    public List<Lojas> getAllLojas(){
        List<Lojas> lojas=new List<>();
        lojaRepo.findAll().forEach(lojas :: add);
        return lojas;
    }
    
}