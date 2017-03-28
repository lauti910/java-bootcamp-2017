package bootcamp.java2017.ClaseTDD;


public class File{
	
	RecentFileList observer;
	public File(RecentFileList rfList) {
		this.observer = rfList;
	}
	public void open() {
		this.observer.update(this);
	}

}
