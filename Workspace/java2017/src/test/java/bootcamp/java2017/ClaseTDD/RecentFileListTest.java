package bootcamp.java2017.ClaseTDD;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bootcamp.java2017.ClaseTDD.RecentFileList.File;
import bootcamp.java2017.ClaseTDD.RecentFileList.RecentList;

public class RecentFileListTest {
	/*  
     * When the program is run for the first time, the list is empty.
     * When a file is opened, it is added to the recent file list.
     * If an opened file already exists in the recent file list, it is bumped to the top, not duplicated in the list.
     * If the recent file list gets full (typical number of items is 15), the oldest item is removed when a new item is added.
	 */
	private RecentList<File> rList;
	@Before
	public void setUp(){
		rList = new RecentList<File>(15);
	}
	
	@Test
	public void test_WhenTheListIsCreated_ItIsEmpty() {
		assert(rList.getSize() == 0);
	}
	@Test
	public void test_WhenAFileIsOpenedIsAddedToTheRecentFileList(){
		File f1 = new File();
		this.rList.open(f1);
		assert(rList.getSize() == 1);
	}
	@Test
	public void test_IfAnOpenedFileAlreadyExistInTheRecentFileList_ItIsBumpedToTheTop_WithoutDuplicatingIt(){
		File f1 = new File();
		File f2 = new File();
		this.rList.open(f1);
		this.rList.open(f2);
		this.rList.open(f1);
		
		assertEquals(f1, rList.getFile(0));
		assert(rList.getSize() == 2);
	}
	@Test
	public void test_IfTheListIsFull_WhenYouOpenAFile_TheLastFileIsRemoved(){
		File f1 = new File();
		File f2 = new File();
		File f3 = new File();
		
		RecentList<File> spyList = Mockito.spy(this.rList);
		Mockito.doReturn(2).when(spyList).getMaxSize();
		
		spyList.open(f1);
		spyList.open(f2);
		spyList.open(f3); //should remove f1 from the list
		
		assertEquals(spyList.getFile(0), f3); //the first is f3
		assertEquals(spyList.getFile(1), f2); //the last is f2
		assertEquals(spyList.getSize(), spyList.getMaxSize()); //the size is the maxSize, which is 2
	}

}
