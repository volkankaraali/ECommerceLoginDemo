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
		User user3=new User(3,"test2","test2","test2@mail.com","123456");
		User user4=new User(4,"test3","test3","test3@mail.com","123456");

		UserManager userManager=new UserManager(new HibernateUserDao(),new EmailValidateManager());
		
		userManager.register(user1);
		System.out.println("\n*****Kayit Hata Mesaji******");
		userManager.register(user2);
		System.out.println("\n*****Kayit Mesaji******");
		userManager.register(user3);
		System.out.println("\n*****Kayit Mesaji******");
		userManager.register(user4);
		
		System.out.println("\n*****Kullanicilar******");
		for (var user : userManager.getAll()) {
			System.out.println(user.getName());
		}
		
		System.out.println("\n*****LoginEkrani******");
		userManager.login("","");
		userManager.login("test1@mail.com","123456");
		userManager.login("volkan@mail.com","123456");
		
		
		System.out.println("\n*****GoogleGiriþ******");
		RegisterService registerService=new GoogleRegisterAdapter();
		
		registerService.registerToSystem("google@test.com", "12344534");
		registerService.loginToSystem("dsada", "dsada");

		
	}

}
