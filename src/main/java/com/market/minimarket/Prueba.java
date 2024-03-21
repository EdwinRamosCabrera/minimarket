package com.market.minimarket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/market")
public class Prueba {
    @GetMapping("/hola")
    public String saludar(){
        return "Bienvenidos a minimarket Joel 🕋🏡🏣";
    }
}
