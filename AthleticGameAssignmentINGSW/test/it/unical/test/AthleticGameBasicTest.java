package it.unical.test;

import java.time.Instant;

import it.unical.asde.AthleticGame;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AthleticGameBasicTest {

	private static AthleticGame athleticGame;
	
	@BeforeClass
	public static void init(){
		athleticGame = new AthleticGame("Basket");
	}
	
	@Test
	public void arrivalTest(){
		athleticGame.addArrival("Davide", Instant.now());
		Assert.assertEquals(1, athleticGame.getArrivals().size());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void parecipiantTimeTest(){
		athleticGame.getParecipiantTime("Davide");
	}
}
