package br.edu.infnet.appvenda.service;

import br.edu.infnet.appvenda.model.domain.Vendedor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class VendedorService {

    private Map<String, Vendedor> mapaVendedor = new HashMap<String,Vendedor>();

    public void incluir(Vendedor vendedor){
        mapaVendedor.put(vendedor.getCpf(), vendedor);
    }

    public Collection<Vendedor> obterLista(){
        return mapaVendedor.values();
    }

}
