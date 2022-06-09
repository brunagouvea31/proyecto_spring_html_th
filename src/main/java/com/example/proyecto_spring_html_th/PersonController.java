package com.example.proyecto_spring_html_th;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Controller
public class PersonController {
    @GetMapping("/Person")
    String getPerson(Model model) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Person miPerson = new Person("Melody", "Garcia Gouvea",
                "https://i.ytimg.com/vi/8lc-Yq-EZJQ/maxresdefault.jpg", "Calle Marina, 22", formato.parse("01/05/2021"));
        model.addAttribute("persona", miPerson);
        String imagen = "https://i.ytimg.com/vi/8lc-Yq-EZJQ/maxresdefault.jpg";
        model.addAttribute("imagenh2", imagen);
        String imagen2 = "https://i.ytimg.com/vi/xHIn4NMOTdE/hqdefault.jpg";
        model.addAttribute("imagenh3", imagen2);
        String imagen3 = "https://www.chiquipedia.com/imagenes/la-sirenita.jpg";
        model.addAttribute("imagenh4", imagen3);

        //Generamos un array (lista con thymeleaf)
        model.addAttribute("personas", Arrays.asList(
                new Person("Melody", "Marina",
                        "https://i.ytimg.com/vi/8lc-Yq-EZJQ/maxresdefault.jpg", "Calle Marina, 22", formato.parse("01/05/2021")),
                new Person("Sebastian", "Cangrejo",
                        "https://i.ytimg.com/vi/xHIn4NMOTdE/hqdefault.jpg", "Calle Marina, 22", formato.parse("05/10/1980")),
                new Person("Ariel", "Marina",
                        "https://www.chiquipedia.com/imagenes/la-sirenita.jpg", "Calle Marina, 22", formato.parse("25/12/1994"))
        ));
        return "Person";
    }

    @GetMapping("/")
    String getHome(Model model) throws ParseException {
        Home miHome = new Home("Bienvenido a la página de EOI");
        // Ahora preparo el envío de datos
        model.addAttribute("datoshome", miHome);
        return "index";
    }
}