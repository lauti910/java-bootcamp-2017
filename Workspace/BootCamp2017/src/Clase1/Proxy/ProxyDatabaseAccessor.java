package Clase1.Proxy;


public class ProxyDatabaseAccessor {
	private DBAccessor accessor;
	
	public void access(){
		if(this.accessor == null){
			this.accessor = new SlowDBAccessor();
		}
		this.accessor.access();
		
	}
}
