package ECommerceLogin.business.concretes;

import ECommerceLogin.business.abstracts.UserValidateService;
import ECommerceLogin.entities.concretes.User;

public class EmailValidateManager implements UserValidateService{

	@Override
	public void validate(User user) {
		System.out.println(user.getEmail()+" adresinize doğrulama maili gönderildi.");
		System.out.println("kaydiniz basarili sekilde olusturuldu.");
	}

}
