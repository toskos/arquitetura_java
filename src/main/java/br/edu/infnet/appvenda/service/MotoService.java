package br.edu.infnet.appvenda.service;

import br.edu.infnet.appvenda.model.domain.Moto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class MotoService {

    private Map<Integer, Moto> mapaMoto = new HashMap<Integer,Moto>();

    public void incluir(Moto moto){
        mapaMoto.put(moto.getCodigo(), moto);
    }

    public Collection<Moto> obterLista(){
        return mapaMoto.values();
    }
}
