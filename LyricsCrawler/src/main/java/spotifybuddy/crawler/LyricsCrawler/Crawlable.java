package spotifybuddy.crawler.LyricsCrawler;

import java.io.IOException;

/** Interface for a special crawl behavior for every website
 * 
 * @author Colin
 *
 */
public interface Crawlable {
	
	/** gets the URL of requested song lyrics
	 * 
	 * @param String title of requested song
	 * @param String artist of requested song
	 * @return String target URL
	 * @throws LoadHTMLException
	 */
	public String searchSong(String title, String artist) throws LoadHTMLException;
	
	/** extracts the lyrics located at the specified URL
	 * 
	 * @param String target URL
	 * @return String lyrics
	 * @throws LoadHTMLException
	 */
	public String extractLyrics(String url) throws LoadHTMLException;
	
	/** change the format of title or artist
	 * 
	 * @param String title/artist
	 * @return String formated title/artist
	 */
	public String format(String name);
}
