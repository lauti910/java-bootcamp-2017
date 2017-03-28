package bootcamp.java2017.ClaseTDD;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bootcamp.java2017.ClaseTDD.Blog.Blog;
import bootcamp.java2017.ClaseTDD.Blog.Entry;

public class BlogTest {

	private Blog blog;
	
	@Before
	public void setUp(){
		this.blog = new Blog();
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

}
