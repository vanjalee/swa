package at.ac.tuwien.swa.service;

import java.util.List;

import javax.inject.Named;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import at.ac.tuwien.swa.entities.Coin;
import at.ac.tuwien.swa.entities.User;

@Named
@Component
public class CostService {
	@Transactional
	public void transferSearchCost(User user) {
		user.getCoins().add(new Coin(Coin.VALUE_SEARCH));
	}

	@Transactional
	public void transferFoundCost(User peerUser) {
		peerUser.getCoins().add(new Coin(Coin.VALUE_FOUND));
	}

	public List<Coin> allCoins(User user) {
		return user.getCoins();
	}

	@Transactional
	public long sumeCoinsAsValue(User user) {
		long sum = 0;

		for (Coin coin : user.getCoins()) {
			sum += coin.getValue();
		}
		return sum;
	}
}
