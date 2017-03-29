package bootcamp.java2017.ClaseTDD.RecentFileList;

import java.util.ArrayList;
import java.util.List;

import bootcamp.java2017.ClaseTDD.Blog.Entry;

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

	public void add(T type) {
		if(this.recentFiles.contains(type)){
			//if the file already exist, i remove it, so i can put it in the first position afterwards
			this.recentFiles.remove(type);
		}else{
			if(this.recentFiles.size() == this.maxSize){
				//if the list is full, i remove the last element
				this.recentFiles.remove(14);
			}
		}
		this.recentFiles.add(0,type);
	}

	public T getFile(Integer index) {
		//Precondition: index < maxSize
		return this.recentFiles.get(index);
	}

	public List<T> getList() {
		return this.recentFiles;
	}

}
