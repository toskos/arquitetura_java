package br.edu.infnet.appvenda.model.service;

import br.edu.infnet.appvenda.model.domain.Vendedor;
import br.edu.infnet.appvenda.model.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public void incluir(Vendedor vendedor){
        vendedorRepository.save(vendedor);
    }

    public Collection<Vendedor> obterLista(){
        return (Collection<Vendedor>) vendedorRepository.findAll();
    }

}
