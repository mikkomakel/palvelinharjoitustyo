package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class KayttajaController {

    @Autowired
    private KayttajaRepository kayttajaRepository;

    @GetMapping("/")
    @ResponseBody
    private String hello(){
        kayttajaRepository.save(new Kayttaja("Keijo Käyttäjä", "suola"));
        List<Kayttaja> users = this.kayttajaRepository.findAll();

        StringBuilder response = new StringBuilder("<html>");
        for (Kayttaja user : users){
            response.append(user.toString());
            response.append("<br>");
        }
        response.append("</html>");

        return response.toString();
    }
}
