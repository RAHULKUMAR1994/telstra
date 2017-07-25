import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class NioJavaTest
{
	@Test
	public void test1() throws IOException {
		
		
		NioJava hw = new NioJava();
		
		System.out.println(hw.getMessage());
		
		assertEquals("hi", hw.getMessage());
		
	
	}
}
