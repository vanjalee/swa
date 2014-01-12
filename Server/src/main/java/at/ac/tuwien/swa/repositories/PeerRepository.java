package at.ac.tuwien.swa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import at.ac.tuwien.swa.entities.Peer;

public interface PeerRepository extends JpaRepository<Peer, Long> {

}
