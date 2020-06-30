package SO2.SO2_Trabalho2.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import SO2.SO2_Trabalho2.model.Utilizador;
import SO2.SO2_Trabalho2.repository.UtilizadorRepository;


//solução inspirada pelo Stack overflow para assegurar que cada utilizador só tem acesso ao seu path variable
@Component
public class Guard {
    @Autowired
    private UtilizadorRepository repo;

    public boolean checkUserId(Authentication authentication, String id) {
        String name = authentication.getName();
        System.out.println(name+" at "+id);
        Utilizador result = repo.findByUtilizador(name);
        return result != null && result.getUtilizador().equals(id);
    }
}