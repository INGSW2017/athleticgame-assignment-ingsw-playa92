package it.unical.test;

import java.time.Instant;

import it.unical.asde.AthleticGame;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AthleticGameWinnersTest {

private static AthleticGame athleticGame;
	
	@BeforeClass
	public static void init(){
		athleticGame = new AthleticGame("Basket");
	}
	
	@After
	public void reset(){
		athleticGame.reset();
	}
	
	@Before
	public void start(){
		athleticGame.start();
	}
	
	@Test
	public void getTest1(){
		athleticGame.getWinner();
		athleticGame.addArrival("Davide", Instant.now().plusMillis(200));
		athleticGame.addArrival("Michele", Instant.now().plusMillis(300));

		Assert.assertEquals("Davide",athleticGame.getWinner());
	}
	

	@Test
	public void getTest2(){
		athleticGame.addArrival("Davide", Instant.now().plusMillis(500));
		athleticGame.addArrival("Giovanni", Instant.now().plusMillis(200));
		athleticGame.addArrival("Michele", Instant.now().plusMillis(300));
		Assert.assertEquals(500,athleticGame.getParecipiantTime("Davide"));
		Assert.assertEquals(200,athleticGame.getParecipiantTime("Giovanni"));
		Assert.assertEquals(200,athleticGame.getParecipiantTime("Michele"));
	}
}
