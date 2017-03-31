package bootcamp.java2017.ClaseTDD.RecentFileList;

import java.util.ArrayList;
import java.util.List;

public class RecentList<T> {
	
	private List<T> recentFiles;
	private Integer maxSize;
	
	public RecentList(Integer maxSize){
		this.recentFiles = new ArrayList<T>();
		this.maxSize = maxSize;
	}
	
	public Integer getSize() {
		return this.recentFiles.size();
	}

	public void open(T type) {
		if(this.recentFiles.contains(type)){
			//if the file already exist, i remove it, so i can put it in the first position afterwards
			this.recentFiles.remove(type);
		}else{
			if(this.recentFiles.size() == this.getMaxSize()){
				//if the list is full, i remove the last element
				this.recentFiles.remove(this.getMaxSize() -1);
			}
		}
		this.recentFiles.add(0,type);
	}

	public Integer getMaxSize() {
		return this.maxSize;
	}

	public T getFile(Integer index) {
		//Precondition: index < maxSize
		return this.recentFiles.get(index);
	}

	public List<T> getList() {
		return this.recentFiles;
	}

}
