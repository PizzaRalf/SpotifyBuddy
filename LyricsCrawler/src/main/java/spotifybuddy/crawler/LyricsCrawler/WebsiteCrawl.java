package spotifybuddy.crawler.LyricsCrawler;

/**
 * Represents a trusted lyrics Website to crawl from.
 *
 */
public class WebsiteCrawl {

	private final String URL;
	private CrawlBehavior behavior;
	private final int ID;

	/** Constructor
	 * 
	 * @param url website-url
	 * @param behavior how the data should be scraped from the website
	 */
	WebsiteCrawl(int id, String url, CrawlBehavior behavior) {
		this.ID = id;
		this.URL = url;
		this.behavior = behavior;
	}

	/** gets the lyrics from the website implementing special behavior
	 * 
	 * @return lyrics object
	 */
	public Lyrics crawl() {
		return new Lyrics(behavior.apply(), ID);

	}
}
