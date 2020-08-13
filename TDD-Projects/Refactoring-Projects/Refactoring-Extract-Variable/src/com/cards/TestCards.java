package com.cards;
 

	import static org.junit.Assert.*;

import org.junit.Test;	 
	 
	 
	public class TestCards
	{
	  @Test
	  public void testDealingWithCards ()
	  {

 //refactor to create local variable   to save calling getPlayers no of times
//refactor to rename the player variable	 

	    Deck deck = new Deck();
	    User.deal(deck.getDeck(), deck.getPlayers());

//Refactor The for block to extract method to make it reusable	
	 
//Refactor to chnage the method signature to make it adptable

	 
	    for (int i=0; i<deck.getPlayers().size(); i++)
	    {	      
	 
	      System.out.println(deck.getPlayers().get(i).toString());
	     
	      for (Object itemData : deck.getPlayers().toArray())
	      {
	        System.out.println(itemData);
	      }
	      System.out.println();
	    }
	    assertEquals(((Deck) deck.getDeck()).getPlayers().size(), 2);
	  }
	}
