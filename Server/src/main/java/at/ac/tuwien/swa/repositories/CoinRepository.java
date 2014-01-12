package at.ac.tuwien.swa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import at.ac.tuwien.swa.entities.Coin;

public interface CoinRepository extends JpaRepository<Coin, Long> {

}
