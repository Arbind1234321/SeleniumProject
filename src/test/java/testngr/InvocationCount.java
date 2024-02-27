package testngr;

import org.testng.annotations.Test;

public class InvocationCount {

	@Test(invocationCount = 10)
	void testDemo()
	{
		System.out.println("hello");
	}
}
