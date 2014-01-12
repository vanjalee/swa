package at.ac.tuwien.swa.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import at.ac.tuwien.swa.entities.Peer;
import at.ac.tuwien.swa.entities.User;

@Named
@Component
public class MusicSearchService {
	@Inject
	PeerService peerService;

	@Inject
	UserService userService;

	public Peer randomPeer(User loggedInUser) {
		Assert.notNull(loggedInUser);
		List<Peer> peers = peerService.findAll();
		if (!peers.isEmpty()) {
			return peers.get(random(0, peers.size()));
		}
		return null;
	}

	public User accessUser(String username, String password) {
		return userService.getUser(username, password);
	}

	private static int random(int low, int high) {
		return (int) (Math.random() * (high - low) + low);
	}

}
