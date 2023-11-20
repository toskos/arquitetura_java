package br.edu.infnet.appvenda.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.model.domain.Carro;

@Repository
public interface CarroRepository extends CrudRepository<Carro, Integer> {

	List<Carro> findAll(Sort sort);
	
	Carro findByCodigo(String codigo);
	
}
