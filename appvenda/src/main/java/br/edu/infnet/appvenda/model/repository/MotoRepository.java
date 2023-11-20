package br.edu.infnet.appvenda.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appvenda.model.domain.Moto;

@Repository
public interface MotoRepository extends CrudRepository<Moto, Integer> {

	List<Moto> findAll(Sort sort);

	Moto findByCodigo(String codigo);
	
}
