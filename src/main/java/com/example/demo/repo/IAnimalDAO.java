package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Animal;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface IAnimalDAO extends CrudRepository<Animal, Long> {

}
