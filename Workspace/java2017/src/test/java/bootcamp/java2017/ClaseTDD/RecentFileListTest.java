package bootcamp.java2017.ClaseTDD;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bootcamp.java2017.ClaseTDD.RecentFileList.File;
import bootcamp.java2017.ClaseTDD.RecentFileList.RecentFileList;

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
	@Test
	public void test_WhenAFileIsOpenedIsAddedToTheRecentFileList(){
		File f1 = new File(rfList);
		f1.open();
		assert(rfList.getSize() == 1);
	}
	@Test
	public void test_IfAnOpenedFileAlreadyExistInTheRecentFileList_ItIsBumpedToTheTop_WithoutDuplicatingIt(){
		File f1 = new File(rfList);
		File f2 = new File(rfList);
		f1.open();
		f2.open();
		f1.open();
		assertEquals(f1, rfList.getFile(0));
		assert(rfList.getSize() == 2);
	}
	@Test
	public void test_IfTheListIsFull_At15_WhenYouOpenAFile_TheLastFileIsRemoved(){
		File f1 = new File(rfList);
		File f2 = new File(rfList);
		File f3 = new File(rfList);
		File f4 = new File(rfList);
		File f5 = new File(rfList);
		File f6 = new File(rfList);
		File f7 = new File(rfList);
		File f8 = new File(rfList);
		File f9 = new File(rfList);
		File f10 = new File(rfList);
		File f11 = new File(rfList);
		File f12 = new File(rfList);
		File f13 = new File(rfList);
		File f14 = new File(rfList);
		File f15 = new File(rfList);
		File f16 = new File(rfList);
		
		f1.open();
		f2.open();
		f3.open();
		f4.open();
		f5.open();
		f6.open();
		f7.open();
		f8.open();
		f9.open();
		f10.open();
		f11.open();
		f12.open();
		f13.open();
		f14.open();
		f15.open();
		
		f16.open(); //should remove f1 from the list
		
		assertEquals(rfList.getFile(0), f16); //the first is f16
		assertEquals(rfList.getFile(14), f2); //the second is f2
		assert(rfList.getSize() == 15); //the size is the maxSize
	}

}
