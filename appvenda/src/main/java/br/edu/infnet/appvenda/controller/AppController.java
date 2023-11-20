package br.edu.infnet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import br.edu.infnet.appvenda.model.service.ProdutoService;
import br.edu.infnet.appvenda.model.service.CarroService;
import br.edu.infnet.appvenda.model.service.MotoService;
import br.edu.infnet.appvenda.model.service.VendedorService;
import br.edu.infnet.appvenda.model.service.InformacaoService;

@Controller
public class AppController {

    @Autowired
    private CarroService carroService;
    @Autowired
    private MotoService motoService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private VendedorService vendedorService;
	@Autowired
	private InformacaoService informacaoService;

    @GetMapping(value = "/")
    public String showIndex(Model model) {

        model.addAttribute("informacoes", informacaoService.obterLista());

        model.addAttribute("qtdeCarro", carroService.obterQtde());
        model.addAttribute("qtdeMoto", motoService.obterQtde());
        model.addAttribute("qtdeProduto", produtoService.obterQtde());
        model.addAttribute("qtdeVendedor", vendedorService.obterQtde());

        return "index";
    }

}
