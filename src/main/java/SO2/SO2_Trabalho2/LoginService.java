package SO2.SO2_Trabalho2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginService {

    @Autowired
    public LoginRepository logRepo;

    public ArrayList<Login> loginService;

    public ArrayList<Login> getAllLogins() {
        //return this.loginService;
        ArrayList<Login> logins= new ArrayList<>();
        logRepo.findAll().forEach(logins :: add);
        return logins;
    }

    public void addLogin(Login login){
        logRepo.save(login);
    }

    public Login getLogin(String user){
        return logRepo.findById(user).orElse(null);
    }

    public void updateLogin(String user, Login login){
        logRepo.save(login);
    }

    public void deleteLogin(String user){
        logRepo.deleteById(user);
    }

}