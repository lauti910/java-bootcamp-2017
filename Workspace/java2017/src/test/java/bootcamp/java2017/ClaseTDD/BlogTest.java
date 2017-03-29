package bootcamp.java2017.ClaseTDD;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import bootcamp.java2017.ClaseTDD.Blog.Blog;
import bootcamp.java2017.ClaseTDD.Blog.Entry;
import bootcamp.java2017.ClaseTDD.RecentFileList.RecentList;

public class BlogTest {

	private Blog blog;
	private RecentList<Entry> mockRecentList;
	
	@Before
	public void setUp(){
		this.mockRecentList = Mockito.mock(RecentList.class);
		this.blog = new Blog(mockRecentList);
		
	}
	
	@Test
	public void test_ANewBlogHasNoEntrys() {
		assert(this.blog.amountOfEntrys() == 0);
	}
	@Test
	public void test_YouCanAddEntrys(){
		Entry e1 = new Entry("My first entry :D");
		this.blog.addEntry(e1);
		
		assert(this.blog.amountOfEntrys() == 1);
		assertEquals(e1, this.blog.getEntry(0));
	}
	@Test
	public void test_YouCanDeleteEntrys(){
		Entry e1 = new Entry("Hi");
		Entry e2 = new Entry("Hello");
		this.blog.addEntry(e1);
		this.blog.addEntry(e2);
		
		assert(this.blog.amountOfEntrys() == 2);
		
		this.blog.removeEntry(e1);
		
		assert(this.blog.amountOfEntrys() == 1);
		assertEquals(e2, this.blog.getEntry(0));
		
	}
	@Test
	public void test_ShowTheMostRecentEntrys(){
		Entry e1 = new Entry("");
		Entry e2 = new Entry("");
		Entry e3 = new Entry("this one should remove e1 from the recent list");

		this.blog.addEntry(e1);
		this.blog.addEntry(e2);
		this.blog.addEntry(e3);
		
		List<Entry> expected = new ArrayList<Entry>();
		expected.add(e2);
		expected.add(e3);
		
		Mockito.when(this.mockRecentList.getList()).thenReturn(expected);
		assertEquals(expected, this.blog.getRecentEntrys());
		
	}

}
