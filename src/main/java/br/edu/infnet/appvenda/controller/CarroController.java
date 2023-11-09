package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appvenda.model.service.CarroService;

@Controller
public class CarroController {
    @Autowired
    private AppController appController;

    @Autowired
    private CarroService carroService;

    @GetMapping(value = "/carro/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        carroService.excluir(id);

        return "redirect:/carro/lista";
    }

    @GetMapping(value = "/carro/lista")
    public String obterLista(Model model) {

        model.addAttribute("rota", "carro");
        model.addAttribute("titulo", "Carros:");
        model.addAttribute("listagem", carroService.obterLista());

        return appController.showIndex(model);
    }
}
