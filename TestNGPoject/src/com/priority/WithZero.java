package com.priority;

import org.testng.annotations.Test;

public class WithZero {
	@Test(priority = 0)
	public void add()
	{
		System.out.println("This is Add method");
	}
		@Test(priority = 0)
		public void sub()
		{
			System.out.println("This is Sub Method");
		}
		@Test(priority = 0)
		public void mult()
		{
			System.out.println("This is Mult Method");
		}
		@Test(priority = 0)
		public void div() {
			System.out.println("This is Div Method");
		}
}
