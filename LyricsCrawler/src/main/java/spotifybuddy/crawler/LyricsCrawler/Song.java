package spotifybuddy.crawler.LyricsCrawler;

import java.util.LinkedList;

/**
 * Dataset for a single song. contains metadata of the song a collection of
 * lyrics
 * 
 * @author Colin
 *
 */
public class Song {

	private String title, artist;
	// private LinkedList<Lyrics> availableLyrics;

	/**
	 * Constructor
	 * 
	 * @param title
	 * @param artist
	 */
	Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}
}
