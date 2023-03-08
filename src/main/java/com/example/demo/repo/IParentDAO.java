package com.example.demo.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Parent;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface IParentDAO extends CrudRepository<Parent, Long> {

	@Query(nativeQuery = true, countQuery = "select 1", value = "select ji.* from parents ji inner join animals ju on ju.id = ji.animal_fk where ju.id is not null and ji.child_fk = :childID limit 1")
	Parent findByCriteria(@Param("childID") Long childID);

}
