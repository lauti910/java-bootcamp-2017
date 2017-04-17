package bootcamp.java2017.FinalProyect.Service;

import bootcamp.java2017.FinalProyect.Service.UserService.UserService;
import bootcamp.java2017.FinalProyect.ServiceImpl.UserService.UserServiceImpl;
import bootcamp.java2017.FinalProyect.ServiceImpl.UserService.UserServiceProxy;
import bootcamp.java2017.FinalProyect.ServiceImpl.UserService.UserServiceWebImpl;

public class UserServiceFactory {

	public UserService getLocalService(){
		return new UserServiceImpl();
	}
	
	public UserService getRemoteWebService(){
		return new UserServiceProxy(new UserServiceWebImpl());
	}

}
