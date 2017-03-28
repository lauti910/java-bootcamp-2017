package bootcamp.java2017.ClaseTDD.RecentFileList;

import java.util.ArrayList;
import java.util.List;

import bootcamp.java2017.ClaseTDD.Blog.Entry;

public class RecentList<Element> {
	
	private List<Element> recentFiles;
	private Integer maxSize;
	
	public RecentList(Integer maxSize){
		this.recentFiles = new ArrayList<Element>();
		this.maxSize = maxSize;
	}
	
	public Integer getSize() {
		return this.recentFiles.size();
	}

	public void add(Element file) {
		if(this.recentFiles.contains(file)){
			//if the file already exist, i remove it, so i can put it in the first position afterwards
			this.recentFiles.remove(file);
		}else{
			if(this.recentFiles.size() == this.maxSize){
				//if the list is full, i remove the last element
				this.recentFiles.remove(14);
			}
		}
		this.recentFiles.add(0,file);
	}

	public Element getFile(Integer index) {
		//Precondition: index < maxSize
		return this.recentFiles.get(index);
	}

	public List<Element> getList() {
		return this.recentFiles;
	}

}
