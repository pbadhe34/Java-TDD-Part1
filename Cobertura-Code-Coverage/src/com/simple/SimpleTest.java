 

package com.simple;

import junit.framework.TestCase;

import java.util.Collection;
import java.util.LinkedList;

public class SimpleTest extends TestCase
{

	final Simple simple = new Simple();

	public SimpleTest(String nm)
	{
		super(nm);
	}

	public void testSquare()
	{
		assertEquals(1, simple.square(1));
		assertEquals(1, simple.square(-1));
	}

     public void UpdateTest()
	{
		assertEquals(10, simple.update());
		 
	}


	public void testF()
	{
		assertEquals(1, simple.f(-1));
		assertEquals(12, simple.f(6));
	}

    public void testUpdate()
	{
		//assertEquals(100, simple.update());
		 
	}


	public void testSum()
	{
		Collection c = new LinkedList();
		c.add(new Integer(3));
		c.add(new Integer(5));
		c.add(new Integer(8));
		assertEquals(16, simple.sum(c));
	}
}