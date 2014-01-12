package at.ac.tuwien.swa.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractCrudService<T> {

	@Inject
	JpaRepository<T, Long> crudRepository;

	public void save(T item) {
		crudRepository.save(item);
	}

	public void delete(T item) {
		crudRepository.delete(item);

	}

	public List<T> findAll() {
		return crudRepository.findAll();
	}

}
