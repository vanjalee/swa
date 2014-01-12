package at.ac.tuwien.swa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import at.ac.tuwien.swa.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
