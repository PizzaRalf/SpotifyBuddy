package spotifybuddy.crawler.LyricsCrawler;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Initiator {
	
	Initiator(){}
	
	public List<Website> initAllWebsites(){
		return null;
	}
	
	public Website initSongtexteCom() {
		return new Website(1, "https://songtexte.com/", new Crawlable() {
			
			public String searchSong(String title, String artist) throws LoadHTMLException {
				String searchQuery = "http://www.songtexte.com/search?q="+title+"+"+artist+"&c=all";
				Document searchResult;
				
				try {
					searchResult = Jsoup.connect(searchQuery)
										.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:61.0) Gecko/20100101 Firefox/61.0")
										.ignoreContentType(true)
										.maxBodySize(0)
									    .timeout(600000)
									    .get();
					
					//System.out.println(searchResult.toString()); //DEBUG

										
				} catch (IOException e1) {
					throw new LoadHTMLException("Error loading the HTML for the search result");
				}
				
				String result = "https://songtexte.com/";
				Element topHit = searchResult.getElementsByClass("topHitLink").first();
											
				result += topHit.attr("href");
				
				return result;
			}
			
			public String extractLyrics(String url) throws LoadHTMLException{

				Document doc;
				try {
					doc = Jsoup.connect(url).get();
				} catch (IOException e) {
					throw new LoadHTMLException("Error loading HTML lyrics");
				}
				
				Element divLyrics = doc.getElementById("lyrics");
				return divLyrics.text();
			}
			
			public String format(String name) {
				String[] resArray = name.split(" ");
				String res = "";
				for (int i = 0; i < resArray.length; i++) {
					if (i==0) res += resArray[i];
					else res += "+"+resArray[i];
				}
				return res;
			}
		});
	}
	
	
}
