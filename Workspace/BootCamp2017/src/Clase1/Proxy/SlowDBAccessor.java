package Clase1.Proxy;

public class SlowDBAccessor implements DBAccessor{

	@Override
	public void access() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
