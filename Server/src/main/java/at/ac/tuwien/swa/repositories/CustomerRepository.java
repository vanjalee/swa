package at.ac.tuwien.swa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import at.ac.tuwien.swa.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
