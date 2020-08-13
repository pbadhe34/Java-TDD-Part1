 

package com.simple;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import ch.qos.logback.classic.Level;

public class Simple
{

	private static final Logger logger = LoggerFactory.getLogger(Simple.class);

 
     private boolean flag = true;


	public int square(int x)
	{
		if (logger.isDebugEnabled())
		{
			logger.debug("x: " + x);
		}

		int result = x * x;

		if (flag)
		{
                System.out.println("\n\nSimple class square falg");
			logger.debug("result: " + result);
		}

		return result;
	}

     public int update()
      {
         System.out.println("\n\nSimple class update "+logger.getClass().getName());  
         logger.debug("result:   update");
         return 100;

      }
	public int f(int x)
	{
		 
			logger.debug("x: " + x);
		

		if (x < 0)
		{
			if (logger.isDebugEnabled())
			{
				logger.debug("negative x");
			}

			return square(x);
		}
		else if ((x >= 0) && (x <= 5))
		{
			if (logger.isDebugEnabled())
			{
				logger.debug("0<=x<=5");
			}

			return x + 3;
		}
		else
		{
			return 2 * x;
		}
	}

	public int sum(Collection c)
	{
		int result = 0;

		for (Iterator i = c.iterator(); i.hasNext();)
		{
			int value = ((Number)i.next()).intValue();

			if (logger.isDebugEnabled())
			{
				logger.debug("value: " + value);
			}

			result += value;
		}

		 
			logger.debug("result: " + result);
	 

		return result;
	}
}