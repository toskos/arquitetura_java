package br.edu.infnet.apiVenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apiVenda.model.domain.Informacao;
import br.edu.infnet.apiVenda.model.service.InformacaoService;

@RestController
@RequestMapping("/api/vendas/informacao")
public class InformacaoController {
    	
	@Autowired
	private InformacaoService informacaoService;

	@GetMapping(value = "/lista")
	public List<Informacao> obterLista(){
		return informacaoService.obterLista();
	}
	
	@PostMapping(value = "/incluir")
	public Informacao incluir(@RequestBody Informacao informacao) {
		return informacaoService.incluir(informacao);
	}
	
	@PostMapping(value = "/excluir")
	public void excluir(@RequestBody int id) {
		informacaoService.excluir(id);
	}
}
