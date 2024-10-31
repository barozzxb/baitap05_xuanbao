package vn.springpj.services.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vn.springpj.entities.Category;
import vn.springpj.repository.CategoryRepository;
import vn.springpj.services.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	CategoryRepository cateRepo;

	public CategoryServiceImpl(CategoryRepository cateRepo) {
		this.cateRepo = cateRepo;
	}

	@Override
	public List<Category> findByNameContaining(String name) {
		return cateRepo.findByNameContaining(name);
	}

	@Override
	public Page<Category> findByNameContaining(String name, Pageable pageable) {
		return cateRepo.findByNameContaining(name, pageable);
	}

	@Override
	public <S extends Category> S save(S entity) {
		if (entity.getCategoryId() == null) {
			return cateRepo.save(entity);
		}
		else {
			Optional<Category> opt = findById(entity.getCategoryId());
			if (opt.isPresent()) {
				if (StringUtils.isEmpty(entity.getName())) {
					entity.setName(opt.get().getName());
				}else {
					entity.setName(entity.getName());
				}
			}
			return cateRepo.save(entity);
		}
	}

	@Override
	public <S extends Category> Optional<S> findOne(Example<S> example) {
		return cateRepo.findOne(example);
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		return cateRepo.findAll(pageable);
	}

	@Override
	public List<Category> findAll() {
		return cateRepo.findAll();
	}

	@Override
	public Optional<Category> findById(Long id) {
		return cateRepo.findById(id);
	}

	@Override
	public long count() {
		return cateRepo.count();
	}

	@Override
	public void deleteById(Long id) {
		cateRepo.deleteById(id);
	}

	@Override
	public void delete(Category entity) {
		cateRepo.delete(entity);
	}

	@Override
	public void deleteAll() {
		cateRepo.deleteAll();
	}
	
	
}
