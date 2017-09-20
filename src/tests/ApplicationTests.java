package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import application.App;

public class ApplicationTests {

	App app = new App();
	
	Map<String, String> data = new HashMap<String, String>();
	
    
	private ArrayList<String> lisOfFriends = initNameList();

	@Test
	public void upperBeginningChecksFirstCharacter() {
		assertTrue(app.hasUpperBeg("Mati"));
		assertFalse(app.hasUpperBeg("mati"));
	}
	
	@Test
	public void wordInList() {
		assertTrue(app.isWordInList("Raivo", lisOfFriends));
	}

	@Test
	public void wordIsNotInList() {
		assertFalse(app.isWordInList("Hendrik", lisOfFriends));
	}

	private ArrayList<String> initNameList() {
		return new ArrayList<String>(Arrays.asList("Mario", "Ülari", "Raivo"));
	}
	
}
