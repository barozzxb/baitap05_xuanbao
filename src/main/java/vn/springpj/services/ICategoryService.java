package vn.springpj.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import vn.springpj.entities.Category;

public interface ICategoryService {

	void deleteAll();

	void delete(Category entity);

	void deleteById(Long id);

	long count();

	Optional<Category> findById(Long id);

	List<Category> findAll();

	Page<Category> findAll(Pageable pageable);

	<S extends Category> Optional<S> findOne(Example<S> example);

	<S extends Category> S save(S entity);

	Page<Category> findByNameContaining(String name, Pageable pageable);

	List<Category> findByNameContaining(String name);

}
