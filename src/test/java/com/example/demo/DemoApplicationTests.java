package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Animal;
import com.example.demo.model.Child;
import com.example.demo.model.Parent;
import com.example.demo.repo.IAnimalDAO;
import com.example.demo.repo.IChildDAO;
import com.example.demo.repo.IParentDAO;

import jakarta.transaction.Transactional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private IParentDAO parentDAO;

	@Autowired
	private IChildDAO childDAO;

	@Autowired
	private IAnimalDAO animalDAO;

	@Test
	@Transactional
	void contextLoads() {

		Child child = new Child();
		child.setName("C");
		child.setRecordId(1L);
		child = childDAO.save(child);

		Animal animal = new Animal();
		animal.setName("A");
		animal = animalDAO.save(animal);

		Parent parent = new Parent();
		parent.setName("P");
		parent.setChild(child);
		parent.setAnimal(animal);
		parent = parentDAO.save(parent);

		Parent parentSaved = parentDAO.findByCriteria(parent.getChild().getRecordId());
		assertNotNull(parentSaved);

	}

}
