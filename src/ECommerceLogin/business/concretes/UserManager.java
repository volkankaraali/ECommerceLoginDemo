package ECommerceLogin.business.concretes;

import java.util.List;

import ECommerceLogin.business.abstracts.UserService;
import ECommerceLogin.business.abstracts.UserValidateService;
import ECommerceLogin.business.constant.Messages;
import ECommerceLogin.dataAccess.abstracts.UserDao;
import ECommerceLogin.entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private UserValidateService userValidateService;
	public UserManager(UserDao userDao,UserValidateService userValidateService) {
		super();
		this.userDao = userDao;
		this.userValidateService=userValidateService;
	}

	@Override
	public void register(User user) {
		if (isInfoNull(user)) {
			if (user.getPassword().length()>=6 && emailCheck(user)==true && checkNameAndLastname(user)==true) {
				System.out.println(user.getName()+",kayit olusturma isteðiniz basarili.");
				
				userDao.register(user);
				userValidateService.validate(user);
			}else {
				System.out.println(Messages.wrongRegisterMessage);
			}
		}else {
			System.out.println(Messages.emptyRegisterMessage);
		}
		
	}

	@Override
	public void login(User user) {
		if (user.getEmail()!=null && user.getPassword()!=null) {
			System.out.println("giriþ basarili: "+user.getName());
		}else {
			System.out.println("email yada sifre eksik.");
		}
		
	}
	
	public List<User> getAll() {
		return userDao.getAll();
	}
	
	private boolean checkNameAndLastname(User user) {
		if (user.getName().length()>2 && user.getLastname().length()>2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean isInfoNull(User user) {
		if (user.getName()!="" && user.getLastname()!="" && user.getEmail()!="" && user.getPassword()!="" ) {
			 return true;
		}else {
			return false;
		}
	}
	
	private boolean emailCheck(User user) {
		//user.getEmail().matches(".*@.*"); //email içerisinde @ kontrol eder.
		
		if (user.getEmail().matches(".*@.*")==true) {
			return isThereMail(user);
		}else {
			return false;
		}
	}

	private boolean isThereMail(User user) {
		for (var onDataUser: userDao.getAll()) {
			if (onDataUser.getEmail()==user.getEmail()) {
				return false;
			}
		}
		return true;
	}

}
