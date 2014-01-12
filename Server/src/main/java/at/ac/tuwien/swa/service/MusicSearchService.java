package at.ac.tuwien.swa.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

import at.ac.tuwien.swa.entities.Peer;
import at.ac.tuwien.swa.entities.User;

@Named
@Component
public class MusicSearchService {
	@Inject
	PeerService peerService;

	@Inject
	UserService userService;

	public String searchMusic(String username, String password, String fingerprint) {
		User loggedInUser = accessUser(username, password);
		if (loggedInUser != null) {
			Peer peer = peerService.randomPeer(loggedInUser, fingerprint);
			if (peer != null) {
				peerService.connectPeer(peer, fingerprint);
			}
		}
		return null; // no peers available
	}

	public User accessUser(String username, String password) {
		return userService.getUser(username, password);
	}

}
