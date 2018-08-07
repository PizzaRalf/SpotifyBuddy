package spotifybuddy.crawler.LyricsCrawler;

/**
 * Represents a trusted lyrics Website to crawl from.
 *
 */
public class Website{

	public final String URL;
	public Crawlable behavior;
	private final int ID;

	/** Constructor
	 * 
	 * @param url website-url
	 * @param behavior how the data should be scraped from the website
	 */
	Website(int id, String url, Crawlable behavior) {
		this.ID = id;
		this.URL = url;
		this.behavior = behavior;
	}

	/** gets the lyrics from the website implementing special behavior
	 * 
	 * @param song object
	 * @return lyrics object
	 * @throws LoadHTMLException 
	 */
	public Lyrics crawl(Song song) throws LoadHTMLException {
		String title = behavior.format(song.getTitle());
		String artist = behavior.format(song.getArtist());
		String targetURL = behavior.searchSong(title, artist);
		String extractedLyrics = behavior.extractLyrics(targetURL);
		
		return new Lyrics(extractedLyrics, this.ID);
	}
	
	public String getURL() {
		return this.URL;
	}


}
