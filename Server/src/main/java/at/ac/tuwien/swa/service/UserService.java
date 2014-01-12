package at.ac.tuwien.swa.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import at.ac.tuwien.swa.entities.User;
import at.ac.tuwien.swa.repositories.UserRepository;

@Named
@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService extends AbstractCrudService<User, UserRepository> {

	@Inject
	UserRepository userRepository;

	// todo needed in the model document
	public User getUser(String username, String password) {
		if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
			return userRepository.findOneByUsernameAndPassword(username, password);
		}
		return null;
	}

	@Override
	public UserRepository getRepository() {
		return userRepository;
	}
}
