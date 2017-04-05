package bootcamp.java2017.ClaseServices.Service;

import bootcamp.java2017.ClaseServices.Service.UserService.UserService;
import bootcamp.java2017.ClaseServices.ServiceImpl.UserService.UserServiceImpl;
import bootcamp.java2017.ClaseServices.ServiceImpl.UserService.UserServiceProxy;
import bootcamp.java2017.ClaseServices.ServiceImpl.UserService.UserServiceWebImpl;

public class UserServiceFactory {

	public UserService getLocalService(){
		return new UserServiceImpl();
	}
	
	public UserService getRemoteWebService(){
		return new UserServiceProxy(new UserServiceWebImpl());
	}

}
