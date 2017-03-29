package bootcamp.java2017.ClaseTDD.RecentFileList;


public class File{
	
	RecentList<File> observer;
	public File(RecentList<File> rfList) {
		this.observer = rfList;
	}
	public void open() {
		//opens the file
		//notify the observers
		//TODO: refactor to the message notifyObservers()
		this.observer.add(this);
	}

}
