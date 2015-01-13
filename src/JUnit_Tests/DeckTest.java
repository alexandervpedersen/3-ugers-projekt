package JUnit_Tests;

import static org.junit.Assert.*;
import boundary.GUIcontroller;
import fields.GameBoard;
import game.DiceBox;
import deck.Deck;
import game.Player;

import org.junit.Test;

import control.DeckController;
import control.FieldController;
import control.HouseController;

public class DeckTest {

	@Test
	public void testKort1() {
	//Preconditions
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] players = new Player[3];
		Deck deck = new Deck(players, board);
		GUIcontroller GUIC = new GUIcontroller();
		FieldController FC = new FieldController(GUIC, board, box, players);
		DeckController DC = new DeckController(deck, GUIC, players, board, FC);
		
		players[0] = new Player("Spiller1");
		players[1] = new Player("Spiller2");
		players[2] = new Player("Spiller3");
		players[0].setPosition(0);
	//Test
		//Move to "Groenningen"
		DC.drawCard(players, 0);

	//Postconditions
		//Tjek om spilleren er p� feltet
		assertEquals(24,players[0].getPosition());
		
	}
	
	@Test
	public void testKort2() {
		//Preconditions
			DiceBox box = new DiceBox();
			GameBoard board = new GameBoard(box);
			Player[] players = new Player[3];
			Deck deck = new Deck(players, board);
			GUIcontroller GUIC = new GUIcontroller();
			FieldController FC = new FieldController(GUIC, board, box, players);
			DeckController DC = new DeckController(deck, GUIC, players, board, FC);
			
			players[0] = new Player("Spiller1");
			players[1] = new Player("Spiller2");
			players[2] = new Player("Spiller3");
			players[0].setPosition(7);
		//Test
			//Draws second card, move to nearest shipping company.
			deck.pickCard(players[0], 1);
			
		//Postconditions
			//Tjek om spilleren er p� feltet
			assertEquals(15,players[0].getPosition());
		}
	
	@Test
	public void testKort3(){
	//Preconditions
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] players = new Player[3];
		Deck deck = new Deck(players, board);
		
		players[0] = new Player("Spiller1");
		players[1] = new Player("Spiller2");
		players[2] = new Player("Spiller3");
		
		
		//We land on chance card at field 8.
		players[0].setPosition(7);
		
		
		
	//Test
		//Draws third card, move to start.
		deck.pickCard(players[0], 2);
		


	//Postconditions
		//Check if the given field.
		assertEquals(0,players[0].getPosition());
	}

	@Test
	public void testKort4(){
	//Preconditions
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] players = new Player[3];
		Deck deck = new Deck(players, board);
		
		players[0] = new Player("Spiller1");
		players[1] = new Player("Spiller2");
		players[2] = new Player("Spiller3");
		
		
		//We land on chance card at field 8.
		players[0].setPosition(7);
		
		
		
	//Test
		//Move 3 positions back.
		deck.pickCard(players[0], 3);
		


	//Postconditions
		//Check if the player is on the given field.
		assertEquals(4,players[0].getPosition());
	}

	@Test
	public void testKort5(){
	//Preconditions
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] players = new Player[3];
		Deck deck = new Deck(players, board);
		
		players[0] = new Player("Spiller1");
		players[1] = new Player("Spiller2");
		players[2] = new Player("Spiller3");
		
		
		//We land on chance card at field 18.
		players[0].setPosition(17);
		
		
		
	//Test
		//Move to Frederiksberg Alle
		deck.pickCard(players[0], 4);
		


	//Postconditions
		//Check if the player is on the given field.
		assertEquals(11,players[0].getPosition());
		//Check if player received money when crossing start.
		assertEquals(34000,players[0].account.getScore());
	}

	@Test
	public void testKort6(){
	//Preconditions
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] players = new Player[3];
		Deck deck = new Deck(players, board);
		
		players[0] = new Player("Spiller1");
		players[1] = new Player("Spiller2");
		players[2] = new Player("Spiller3");
		
		
		//We land on chance card at field 18.
		players[0].setPosition(36);
		
		
		
	//Test
		//Use mols linien, if you cross start receive 4000.
		deck.pickCard(players[0], 5);
		


	//Postconditions
		//Check if the player is on the given field.
		assertEquals(15,players[0].getPosition());
		//Check if player received money when crossing start.
		assertEquals(34000,players[0].account.getScore());
	}

	@Test
	public void testKort8(){
	//Preconditions
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] players = new Player[3];
		Deck deck = new Deck(players, board);
		
		players[0] = new Player("Spiller1");
		players[1] = new Player("Spiller2");
		players[2] = new Player("Spiller3");
		
		
		//We land on chance card at field 36.
		players[0].setPosition(36);
		
		
		
	//Test
		//Use mols linien, if you cross start receive 4000.
		deck.pickCard(players[0], 7);
		


	//Postconditions
		//Check if the player is set to a jailed status.
		assertEquals(true,players[0].isJailed());
		//Check if the player is on the jail field.
		assertEquals(10,players[0].getPosition());		
		
	}
	
	@Test
	public void testKort10(){
	//Preconditions
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] players = new Player[3];
		Deck deck = new Deck(players, board);
		
		players[0] = new Player("Spiller1");
		players[1] = new Player("Spiller2");
		players[2] = new Player("Spiller3");
		
		
		//We land on chance card at field 7.
		players[0].setPosition(7);
		
		
		
	//Test
		//Repair on car, 3000 bill.
		deck.pickCard(players[0],9);
		


	//Postconditions
		//Check if the player lost 3000.
		assertEquals(27000,players[0].account.getScore());
		
	}
	
	@Test
	public void testKort11(){
	//Preconditions
		DiceBox box = new DiceBox();
		GameBoard board = new GameBoard(box);
		Player[] players = new Player[3];
		Deck deck = new Deck(players, board);
		GUIcontroller GUIC = new GUIcontroller();
		HouseController HC = new HouseController(GUIC, board, players);
		
		players[0] = new Player("Spiller1");
		players[1] = new Player("Spiller2");
		players[2] = new Player("Spiller3");
		
		players[0].setPosition(11);
		board.getField(players[0].getPosition()).landOnField(players[0]);
		players[0].setPosition(13);
		board.getField(players[0].getPosition()).landOnField(players[0]);
		players[0].setPosition(14);
		board.getField(players[0].getPosition()).landOnField(players[0]);
		HC.checkOwnedFields(players[0]);
		HC.Housing(players[0], 0);
		
		
		//We land on chance card at field 7.
		players[0].setPosition(7);
		
		
		
	//Test
		//Repair on car, 3000 bill.
		deck.pickCard(players[0],9);
		


	//Postconditions
		//Check if the player lost 3000.
		assertEquals(27000,players[0].account.getScore());
		
	}

}
