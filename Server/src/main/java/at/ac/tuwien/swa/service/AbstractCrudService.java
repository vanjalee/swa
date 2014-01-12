package at.ac.tuwien.swa.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import at.ac.tuwien.swa.entities.AbstractEntity;

public abstract class AbstractCrudService<T extends AbstractEntity, U> {
	JpaRepository<T, Serializable> repository;

	@SuppressWarnings("unchecked")
	public JpaRepository<T, Serializable> getCrudRepository() {
		return (JpaRepository<T, Serializable>) getRepository();
	}

	public abstract U getRepository();

	public void save(T item) {
		getCrudRepository().save(item);
	}

	public void delete(T item) {
		getCrudRepository().delete(item);

	}

	public List<T> findAll() {
		return getCrudRepository().findAll();
	}

}
