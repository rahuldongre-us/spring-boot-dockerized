package com.saic.demo.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.saic.demo.model.Documentz;

public interface DocumentRepository extends CrudRepository<Documentz, Integer>{
	List<Documentz> findByApplicationzId(Integer applicationzId, Sort sort); 
	
	List<Documentz> findByApplicationzIdOrderByIdDesc(Integer applicationzId);
}
