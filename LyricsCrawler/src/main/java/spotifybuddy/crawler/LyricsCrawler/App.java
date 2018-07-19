package spotifybuddy.crawler.LyricsCrawler;

import java.io.ObjectInputStream.GetField;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * Main class
 *
 */
public class App {
	
	private static App main = new App();
	private static Scanner input = new Scanner(System.in);
	
	private LinkedList<Song> songs;
	private LinkedList<WebsiteCrawl> websites;
	
    public static void main( String[] args )
    {
        System.out.println("---- LyricsCrawl Test Interface ----");
        String title = getInput(" Please enter the title of your song:");
        String artist = getInput(" Please enter the name of the artist:");
        main.addSong(new Song(title, artist));
        
    }
    
    private void initWebsites() {
    	
    }
    
    private WebsiteCrawl init_genius_com() {
    	return null;
    }
    
    /** adds a song to inventory
     * 
     * @param s
     */
    private void addSong(Song s) {
    	this.songs.add(s);
    }
    
    private static String getInput(String message) {
    	System.out.println("\n" + message);
    	System.out.print("\nlti>>> ");
    	return input.next();
    }
    
    
}