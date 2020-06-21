package SO2.SO2_Trabalho2.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import SO2.SO2_Trabalho2.model.Utilizador;
import SO2.SO2_Trabalho2.repository.UtilizadorRepository;

@Service
public class UserPrincipalDetailService implements UserDetailsService {

    private UtilizadorRepository utilizadorRepository;

    public UserPrincipalDetailService(UtilizadorRepository utilizadorRepository) {
        this.utilizadorRepository = utilizadorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilizador utilizador = this.utilizadorRepository.findByUtilizador(username);
        UserPrincipal userPrincipal = new UserPrincipal(utilizador);
        return userPrincipal;
    }
}