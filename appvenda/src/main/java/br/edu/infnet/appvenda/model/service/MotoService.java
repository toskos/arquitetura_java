package br.edu.infnet.appvenda.model.service;

import br.edu.infnet.appvenda.model.domain.Moto;
import br.edu.infnet.appvenda.model.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    public void incluir(Moto moto){
        motoRepository.save(moto);
    }

    public Collection<Moto> obterLista(){
        return (Collection<Moto>) motoRepository.findAll(Sort.by(Sort.Direction.ASC, "codigo"));
    }

    public long obterQtde() {
        return motoRepository.count();
    }

    public void excluir(Integer id) {
        motoRepository.deleteById(id);
    }

	public Moto pesquisar(String codigo) {
		return motoRepository.findByCodigo(codigo);
	}

}
