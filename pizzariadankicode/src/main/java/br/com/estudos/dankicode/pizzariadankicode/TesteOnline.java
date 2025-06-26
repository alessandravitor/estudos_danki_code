package br.com.estudos.dankicode.pizzariadankicode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/teste")
public class TesteOnline {

    @GetMapping
    public String testeRetorno() {
        return "Aplicação online às "+ new Date();
    }
}
