package bootcamp.java2017.ClaseTDD;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bootcamp.java2017.ClaseTDD.Blog.Blog;

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

}
