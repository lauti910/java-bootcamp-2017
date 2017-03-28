package bootcamp.java2017.ClaseTDD.RecentFileList;


public class File{
	
	RecentFileList observer;
	public File(RecentFileList rfList) {
		this.observer = rfList;
	}
	public void open() {
		//opens the file
		//notify the observers
		//TODO: refactor to the message notifyObservers()
		this.observer.update(this);
	}

}
