package at.ac.tuwien.swa.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import at.ac.tuwien.swa.entities.Peer;
import at.ac.tuwien.swa.entities.User;
import at.ac.tuwien.swa.repositories.PeerRepository;

@Named
@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PeerService extends AbstractCrudService<Peer, PeerRepository> {

	@Inject
	PeerRepository peerRepository;

	@Transactional
	public User getUser(Peer peer) {
		return peer.getUser();
	}

	// @Async should be async
	public String connectPeer(Peer peer, String fingerprint) {
		Assert.notNull(peer);
		Assert.notNull(fingerprint);

		// call webservice
		return null;
	}

	public Peer randomPeer(User loggedInUser, String fingerprint) {
		Assert.notNull(loggedInUser);
		List<Peer> peers = findAll();
		if (!peers.isEmpty()) {
			return peers.get(random(0, peers.size()));
		}
		return null;
	}

	// todo needed in the model document
	public void registerPeer(User user, String uuid, String ipAddress) {
		Assert.notNull(user);
		Assert.notNull(uuid);
		Assert.notNull(ipAddress);
		Peer peer = new Peer();
		peer.setUser(user);
		peer.setUuid(uuid);
		peer.setIpAddress(ipAddress);
		save(peer);
	}

	// todo needed in the model document
	public void onlinePeer(Peer peer) {
		Assert.notNull(peer);
		peer.setOnline(true);
		save(peer);
	}

	// todo needed in the model document
	public void offlinePeer(Peer peer) {
		Assert.notNull(peer);
		peer.setOnline(false);
		save(peer);
	}

	private static int random(int low, int high) {
		return (int) (Math.random() * (high - low) + low);
	}

	@Override
	public PeerRepository getRepository() {
		return peerRepository;
	}
}
