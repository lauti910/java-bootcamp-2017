package bootcamp.java2017.ClaseTDD.Blog;

import java.util.ArrayList;
import java.util.List;

import bootcamp.java2017.ClaseTDD.RecentFileList.RecentList;

public class Blog {

	private List<Entry> entrys;
	private RecentList<Entry> recentEntrys;
	
	public Blog(RecentList<Entry> recentList){
		this.entrys = new ArrayList<Entry>();
		this.recentEntrys = recentList;
	}
	public Integer amountOfEntrys() {
		return this.entrys.size();
	}

	public void addEntry(Entry entry) {
		this.entrys.add(entry);
		this.recentEntrys.add(entry);
	}
	public Entry getEntry(Integer i) {
		//Precondition: i < entrys.size
		return this.entrys.get(i);
	}
	public void removeEntry(Entry entry) {
		this.entrys.remove(entry);
		
	}
	public List<Entry> getRecentEntrys() {
		return this.recentEntrys.getList();
	}

}
