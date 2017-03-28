package bootcamp.java2017.ClaseTDD;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecentFileListTest {
	/*  
     * When the program is run for the first time, the list is empty.
     * When a file is opened, it is added to the recent file list.
     * If an opened file already exists in the recent file list, it is bumped to the top, not duplicated in the list.
     * If the recent file list gets full (typical number of items is 15), the oldest item is removed when a new item is added.
	 */
	private RecentFileList rfList;
	@Before
	public void setUp(){
		rfList = new RecentFileList();
	}
	
	@Test
	public void test_WhenTheListIsCreated_ItIsEmpty() {
		assert(rfList.getSize() == 0);
	}

}
