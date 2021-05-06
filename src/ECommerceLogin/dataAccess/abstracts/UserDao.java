package ECommerceLogin.dataAccess.abstracts;

import java.util.List;

import ECommerceLogin.entities.concretes.User;

public interface UserDao {

	void register(User user);
	void login(User user);
	List<User> getAll();
}
