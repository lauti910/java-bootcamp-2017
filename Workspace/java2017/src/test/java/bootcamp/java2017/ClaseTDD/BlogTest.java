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
	private RecentList<Entry> rl;
	
	@Before
	public void setUp(){
		this.rl = Mockito.mock(RecentList.class);
		this.blog = new Blog(rl);
		
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
	public void test_ShowThe10MostRecentEntrys(){
		Entry e1 = new Entry("");
		Entry e2 = new Entry("");
		Entry e3 = new Entry("");
		Entry e4 = new Entry("");
		Entry e5 = new Entry("");
		Entry e6 = new Entry("");
		Entry e7 = new Entry("");
		Entry e8 = new Entry("");
		Entry e9 = new Entry("");
		Entry e10 = new Entry("");
		Entry e11 = new Entry("this one should remove the e1 from the recent list");

		this.blog.addEntry(e1);
		this.blog.addEntry(e2);
		this.blog.addEntry(e3);
		this.blog.addEntry(e4);
		this.blog.addEntry(e5);
		this.blog.addEntry(e6);
		this.blog.addEntry(e7);
		this.blog.addEntry(e8);
		this.blog.addEntry(e9);
		this.blog.addEntry(e10);
		this.blog.addEntry(e11);
		
		List<Entry> expected = new ArrayList<Entry>();
		expected.add(e2);
		expected.add(e3);
		expected.add(e4);
		expected.add(e5);
		expected.add(e6);
		expected.add(e7);
		expected.add(e8);
		expected.add(e9);
		expected.add(e10);
		expected.add(e11);
		
		Mockito.when(this.rl.getList()).thenReturn(expected);
		assertEquals(expected, this.blog.getRecentEntrys());
		
	}

}
