package SO2.SO2_Trabalho2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SO2.SO2_Trabalho2.model.Login;
import SO2.SO2_Trabalho2.repository.LoginRepository;

@RestController
public class WebController {
    @Autowired
    LoginRepository repository;

    @RequestMapping("/save")
    public String process() {
        // save a single Customer
        repository.save(new Login("Jack", "Smith"));

        repository.save(new Login("João", "pass1"));

        repository.save(new Login("Diogo", "pass2"));

        return "Done";
    }

    @RequestMapping("/findall")
    public String findAll() {
        String result = "";

        for (Login cust : repository.findAll()) {
            result += cust.toString() + "<br>";
        }

        return result;
    }

    @RequestMapping("/findu")
    public String findu(@RequestParam("utilizador") String utilizador, @RequestParam("password") String password) {
        String result = "";

        result = repository.findByUtilizadorAndPassword(utilizador, password).toString();

        return result;
    }

    /*
     * @RequestMapping("/findbyid") public String findById(@RequestParam("id") int
     * id) { String result = ""; result = repository.findOne(id).toString(); return
     * result; }
     * 
     * @RequestMapping("/findbyname") public String
     * fetchDataByLastName(@RequestParam("lastname") String name) { String result =
     * "";
     * 
     * result = repository.findOneName(name).toString(); return result; }
     */
}