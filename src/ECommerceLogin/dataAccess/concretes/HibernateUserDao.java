package ECommerceLogin.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ECommerceLogin.dataAccess.abstracts.UserDao;
import ECommerceLogin.entities.concretes.User;

public class HibernateUserDao implements UserDao{

	List<User> users= new ArrayList<User>();
	
	@Override
	public void register(User user) {
		users.add(user);
	}

	@Override
	public void login(User user) {
		System.out.println("giris basarili: "+user.getName());
		
	}
	
	@Override
	public List<User> getAll() {
		return users;
	}

}
