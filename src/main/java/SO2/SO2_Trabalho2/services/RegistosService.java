package SO2.SO2_Trabalho2.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import SO2.SO2_Trabalho2.repository.RegistosRepository;
import SO2.SO2_Trabalho2.model.Registos;

public class RegistosService {
    
    @Autowired
    RegistosRepository regRepo;

    public ArrayList<Registos> getAllRegistos(){
        ArrayList<Registos> reg=new ArrayList<>();
        regRepo.findAll().forEach(reg :: add);
        return reg;
    }

    public Registos getLojas(long id){
        return regRepo.findById(id).orElse(null);
    }

    public void addLojas(Registos reg){
        regRepo.save(reg);
    }

    public void deleteLojas(long id){
        regRepo.deleteById(id);
    }

    //Fazer metodo para pesquisar registos por hora e por utilizador

}