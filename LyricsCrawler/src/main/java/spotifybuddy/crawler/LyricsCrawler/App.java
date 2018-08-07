package spotifybuddy.crawler.LyricsCrawler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Stream;
import java.io.IOException;


import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * Main class
 *
 */
public class App {

	private static App main = new App();
	private static Initiator init = new Initiator();
	private static Scanner input = new Scanner(System.in);

	private LinkedList<Song> songs = new LinkedList<>();
	private HashMap<Integer, Website> websites;

	public static void main(String[] args) {
		//main.initWebsites();
		
		System.out.println("---- LyricsCrawl Test Interface ----");
		String title = getInput(" Please enter the title of your song:");
		String artist = getInput(" Please enter the name of the artist:");
		main.addSong(new Song(title, artist));
		
		//Song s = new Song("Beyond Redemption", "Heaven Shall Burn");
		Website songtexte_com = init.initSongtexteCom();
		Lyrics lyrics = null;
		try {
			lyrics = songtexte_com.crawl(main.songs.get(0));
		} catch (LoadHTMLException e) {
			e.printStackTrace();
		}
		String content = lyrics.toString();
		
		System.out.println("\nLyrics found: \n----------------------\n"+content);

	}

	

	/**
	 * adds a song to inventory
	 * 
	 * @param s
	 */
	private void addSong(Song s) {
		this.songs.add(s);
	}

	private static String getInput(String message) {
		System.out.println("\n" + message);
		System.out.print("\nlti>>> ");
		return input.nextLine();
	}

}