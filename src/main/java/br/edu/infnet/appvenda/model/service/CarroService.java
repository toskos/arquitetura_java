package br.edu.infnet.appvenda.model.service;

import br.edu.infnet.appvenda.model.domain.Carro;
import br.edu.infnet.appvenda.model.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public void incluir(Carro carro){
        carroRepository.save(carro);
    }

    public Collection<Carro> obterLista(){
        return (Collection<Carro>) carroRepository.findAll();
    }

    public long obterQtde() {
        return carroRepository.count();
    }

    public void excluir(Integer id) {
        carroRepository.deleteById(id);
    }

}
