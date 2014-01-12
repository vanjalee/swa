package at.ac.tuwien.swa.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

@Named
@Component
public class WSPeerService {
	@Inject
	PeerService peerService;
	// webservice connection for peer service

	// TODO by vanja
}
