package bootcamp.java2017.ClaseTDD;

import java.util.ArrayList;
import java.util.List;

public class RecentFileList {
	
	private List<File> recentFiles;
	
	public RecentFileList(){
		this.recentFiles = new ArrayList<File>();
	}
	
	public Integer getSize() {
		return this.recentFiles.size();
	}

	public void update(File file) {
		if(this.recentFiles.contains(file)){
			//if the file already exist, i remove it, so i can put it in the first position afterwards
			this.recentFiles.remove(file);
		}else{
			if(this.recentFiles.size() == 15){
				//if the list is full, i remove the last element
				this.recentFiles.remove(14);
			}
		}
		this.recentFiles.add(0,file);
	}

	public File getFile(Integer index) {
		//Precondition: index < list.size
		return this.recentFiles.get(index);
	}

}
