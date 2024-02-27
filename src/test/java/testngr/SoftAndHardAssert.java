package testngr;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAndHardAssert {
	//@Test
	void hardAssertion() {
		//hard assertion
		System.out.println("passed");
		System.out.println("passed.............");
		System.out.println("passed.............");
		System.out.println("passed.............");
		Assert.assertTrue(false);
		System.out.println("welcome.............");
		
	}
	@Test
	void SoftAssertion() {
		//hard assertion
		System.out.println("passed");
		System.out.println("passed.............");
		System.out.println("passed.............");
		System.out.println("passed.............");
		SoftAssert sa=new SoftAssert();
		sa.assertTrue(false);
		System.out.println("welcome.............");
		sa.assertAll();
		
	}

}
