package com.priority;

import org.testng.annotations.Test;

public class DefaultPriority {
	
@Test
public void add()
{
	System.out.println("This is Add method");
}
	@Test
	public void sub()
	{
		System.out.println("This is Sub Method");
	}
	@Test
	public void mult()
	{
		System.out.println("This is Mult Method");
	}
	@Test 
	public void div() {
		System.out.println("This is Div Method");
	}
}
