package bootcamp.java2017.ClaseTDD.Blog;

import java.util.ArrayList;
import java.util.List;

public class Blog {

	private List<Entry> entrys;
	
	public Blog(){
		this.entrys = new ArrayList<Entry>();
	}
	public Integer amountOfEntrys() {
		return this.entrys.size();
	}

	public void addEntry(Entry entry) {
		this.entrys.add(entry);
	}
	public Entry getEntry(Integer i) {
		//Precondition: i < entrys.size
		return this.entrys.get(i);
	}
	public void removeEntry(Entry entry) {
		this.entrys.remove(entry);
		
	}

}
