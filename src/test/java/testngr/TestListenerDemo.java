package testngr;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestListenerDemo {
	@Test(priority = 1)
	void tes1() {
		Assert.assertEquals(1, 1);

	}
	@Test(priority = 2)
	void tes2() {
		Assert.assertEquals("A", "B");
	}
	@Test(priority = 3,dependsOnMethods = {"tes2"})
	void tes3() {
		Assert.assertEquals(1, 1);
	}

}
