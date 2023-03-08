package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Child;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface IChildDAO extends CrudRepository<Child, Long> {

}
