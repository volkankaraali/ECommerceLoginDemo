package ECommerceLogin.business.concretes;

import ECommerceLogin.business.abstracts.UserValidateService;
import ECommerceLogin.entities.concretes.User;

public class EmailValidateManager implements UserValidateService{

	@Override
	public void validate(User user) {
		System.out.println(user.getEmail()+" adresinize do�rulama maili g�nderildi.");
		System.out.println("kaydiniz basarili sekilde olusturuldu.");
	}

}
