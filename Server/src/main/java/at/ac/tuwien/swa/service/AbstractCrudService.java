package at.ac.tuwien.swa.service;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCrudService<T> {
	public void save(T item) {
	}

	public void delete(T item) {

	}

	public List<T> findAll() {
		return new ArrayList<>();
	}
}
