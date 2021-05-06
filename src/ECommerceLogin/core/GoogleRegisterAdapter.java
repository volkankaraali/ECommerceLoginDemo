package ECommerceLogin.core;

import ECommerceLogin.googleRegister.GoogleRegisterManager;

public class GoogleRegisterAdapter implements RegisterService{

	GoogleRegisterManager google=new GoogleRegisterManager();
	
	@Override
	public void registerToSystem(String email, String password) {
		google.register(email, password);
		
	}

	@Override
	public void loginToSystem(String email, String password) {
		google.login(email, password);
		
	}

}
