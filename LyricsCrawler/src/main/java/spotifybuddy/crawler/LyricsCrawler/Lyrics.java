package spotifybuddy.crawler.LyricsCrawler;


/** Stores the lyrics and the web source it was scraped from
 * 
 * @author Colin
 *
 */
public class Lyrics {

	private String content;
	private int sourceID;

	/** Constructor
	 * 
	 * @param content
	 * @param webSourceID
	 */
	Lyrics(String content, int webSourceID) {
		this.content = content;
		this.sourceID = webSourceID;
	}
}