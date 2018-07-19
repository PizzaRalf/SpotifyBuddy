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
	private LinkedList<Lyrics> availableLyrics;

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

	/**
	 * Stores an Object of type Lyrics in this dataset
	 * 
	 * @param data
	 *            Lyrics object
	 */
	public void addLyrics(Lyrics data) {
		this.availableLyrics.add(data);
	}

	/**
	 * Checks if there is any entry for lyrics in this Object
	 * 
	 * @return true if lyrics are available for this song
	 */
	public boolean hasLyrics() {
		if (!availableLyrics.isEmpty())
			return true;
		else
			return false;
	}
}
