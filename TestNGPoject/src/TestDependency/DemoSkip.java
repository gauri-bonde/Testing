package TestDependency;

import org.testng.annotations.Test;

public class DemoSkip {
@Test(enabled = false)
public void m1()
{
	System.out.println("This is m1 Method");
}

@Test(enabled = false)
public void m2()
{
	System.out.println("This is m2 Method");
}
@Test
public void m3()
{
	System.out.println("This is m3 Method");
}
}
