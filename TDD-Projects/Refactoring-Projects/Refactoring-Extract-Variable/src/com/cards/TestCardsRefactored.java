package com.cards;
 

	import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;	 
	 
	 
	public class TestCardsRefactored
	{
	  @Test
	  public void testDealingWithCards ()
	  {
	    Deck deck = new Deck();
	    //local variable created to save calling getPlayers no of times
	    List players = deck.getPlayers();
		User.deal(deck.getDeck(), players);
		
		//The for block refactored to extract method to make it reusable
		
		/*for (int i=0; i<players.size(); i++)
	    {	      
	 
	      System.out.println(players.get(i).toString());
	     
	      for (Object itemData : players.toArray())
	      {
	        System.out.println(itemData);
	      }
	      System.out.println();
	    }*/
	 
	    outPrintData(players, 0);
	    assertEquals(((Deck) deck.getDeck()).getPlayers().size(), 2);
	  }

	  //refactor to rename the player variable
	  //Refactor to chnage the method signature
	protected void outPrintData(List data, int param) {
		for (int i=0; i<data.size(); i++)
	    {	      
	 
	      System.out.println(data.get(i).toString());
	     
	      for (Object itemData : data.toArray())
	      {
	        System.out.println(itemData);
	      }
	      System.out.println();
	    }
	}
	}
