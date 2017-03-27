package Clase1.Proxy;

import Clase1.Singleton.DBConnection;

public class ProxyDatabaseAccessor {
	private DBAccessor accessor;
	
	public void access(){
		if(this.accessor == null){
			this.accessor = new SlowDBAccessor();
		}
		this.accessor.access();
		
	}
}
