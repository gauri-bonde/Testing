package TestDependency;

import org.testng.annotations.Test;

public class Demo {

	@Test(dependsOnMethods = "m2")
	public void m1()
	{
		System.out.println("This is m1 Method");
	}
	
	@Test
	public void m2()
	{
		System.out.println("This is m2 Method");
	}
}
