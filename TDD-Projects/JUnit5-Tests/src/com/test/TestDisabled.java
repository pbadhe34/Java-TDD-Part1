package com.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Disabled until bug #123 has been fixed")
public class TestDisabled {
	
	@Test
	void verifyUpdate()
	{
		System.out.println("This is test for update");
	}

}
