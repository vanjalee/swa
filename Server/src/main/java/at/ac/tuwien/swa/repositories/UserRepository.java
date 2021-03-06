package at.ac.tuwien.swa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import at.ac.tuwien.swa.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findOneByUsernameAndPassword(String username, String password);

	public List<User> findAllByUsername(String username);
}
