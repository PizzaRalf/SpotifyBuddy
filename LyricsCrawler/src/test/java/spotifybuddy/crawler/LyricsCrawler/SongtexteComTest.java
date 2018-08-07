package spotifybuddy.crawler.LyricsCrawler;

import static org.junit.Assert.*;import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class SongtexteComTest {

	Initiator init = new Initiator();
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void givenOneWordFormatShouldReturnCorrectFormatedString() {
		Website songtexte = init.initSongtexteCom();
		String title = songtexte.behavior.format("Godiva");
		assertTrue(title.equals("Godiva"));
	}
	
	@Test
	public void givenMoreWordFormatShouldReturnCorrectFormatedString() {
		Website songtexte = init.initSongtexteCom();
		String title = songtexte.behavior.format("Beyond Redemption");
		assertTrue(title.equals("Beyond+Redemption"));
		
		title = songtexte.behavior.format("Beyond Redemption Oderso");
		assertTrue(title.equals("Beyond+Redemption+Oderso"));
	}
	
	// TODO test false cases
	
	@Test
	public void searchSongShouldReturnCorrectURL() {
		Website songtexte = init.initSongtexteCom();
		String title = "Godiva";
		String artist = "heaven+shall+burn";
		String url = null;
		
		try {
			url = songtexte.behavior.searchSong(title, artist);
		} catch (LoadHTMLException e) {
			fail("LoadHTMLException was thrown");
		}
		
	    assertTrue(url.equals("https://songtexte.com/songtext/heaven-shall-burn/godiva-4bab6376.html"));
	}
}
