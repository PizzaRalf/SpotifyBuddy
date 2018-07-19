package spotifybuddy.crawler.LyricsCrawler;

/** Interface for a special crawl behavior for every website
 * 
 * @author Colin
 *
 */
public interface CrawlBehavior {
	
	/** applies the function to the website
	 * 
	 * @return lyrics
	 */
	public String apply();
}
