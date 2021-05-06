package ECommerceLogin;

import java.util.List;

import ECommerceLogin.business.concretes.EmailValidateManager;
import ECommerceLogin.business.concretes.UserManager;
import ECommerceLogin.core.GoogleRegisterAdapter;
import ECommerceLogin.core.RegisterService;
import ECommerceLogin.dataAccess.concretes.HibernateUserDao;
import ECommerceLogin.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		User user1=new User(1,"volkan","karaali","volkan@mail.com","123456");
		User user2=new User(2,"test","test","volkan@mail.com","123456");

		UserManager userManager=new UserManager(new HibernateUserDao(),new EmailValidateManager());
		
		userManager.register(user1);
		System.out.println("\n*****Kayit Hata Mesaji******");
		userManager.register(user2);
		
		
		
		System.out.println("\n*****Login******");
		userManager.login(user1);
		
		
		System.out.println("\n*****GoogleGiriþ******");
		RegisterService registerService=new GoogleRegisterAdapter();
		
		registerService.registerToSystem("google@test.com", "12344534");
		registerService.loginToSystem("dsada", "dsada");

		
	}

}
