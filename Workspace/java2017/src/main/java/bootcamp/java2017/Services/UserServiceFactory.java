package bootcamp.java2017.Services;

import bootcamp.java2017.Services.UserService.UserService;
import bootcamp.java2017.Services.UserService.UserServiceImpl;
import bootcamp.java2017.Services.UserService.UserServiceProxy;
import bootcamp.java2017.Services.UserService.UserServiceWebImpl;

public class UserServiceFactory {

	public UserService getLocalService(){
		return new UserServiceImpl();
	}
	
	public UserService getRemoteWebService(){
		return new UserServiceProxy(new UserServiceWebImpl());
	}

}
