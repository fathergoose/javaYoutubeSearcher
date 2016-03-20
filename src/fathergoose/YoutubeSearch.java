package fathergoose;

import java.net.URL;

public class YoutubeSearch {
	
	private static final String apiKey = System.getenv("YOUTUBE_API_KEY");
	private String query;
	
	YoutubeSearch(String q) {
		query = q;
		URL url = new URL("https://www.googleapis.com/youtube/v3/search?q=" + query + "&key=" + apiKey );
		
	}

	public static void main(String[] args) {
		YoutubeSearch search = new YoutubeSearch(args[0]);
		System.out.println(search.query);
		System.out.println(apiKey);

	}

}
