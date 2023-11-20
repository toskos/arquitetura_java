package br.edu.infnet.apiVenda.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.apiVenda.model.domain.Informacao;
import br.edu.infnet.apiVenda.model.repository.InformacaoRepository;

@Service
public class InformacaoService {
    
	@Autowired
	private InformacaoRepository informacaoRepository;

	public List<Informacao> obterLista() {
		return (List<Informacao>) informacaoRepository.findAll();
	}

	public Informacao incluir(Informacao informacao) {
		return informacaoRepository.save(informacao);
	}
    
	public void excluir(int id) {
		informacaoRepository.deleteById(id);
	}
}
