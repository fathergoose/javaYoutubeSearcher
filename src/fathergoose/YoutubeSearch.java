package fathergoose;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class YoutubeSearch {
	
//	private static final String apiKey = System.getenv("YOUTUBE_API_KEY");
	private static final String apiKey = "<HIDDEN>";
	private String query;
	private ArrayList<Video> videos = new ArrayList<Video>();
	
	YoutubeSearch(String q) throws IOException {
		String query = q;
		URL url = new URL("https://www.googleapis.com/youtube/v3/search?part=snippet&q=" + query + "&key=" + apiKey );
		try (InputStream instr = url.openStream();
			JsonReader rdr = Json.createReader(instr)) {
		    	JsonObject obj = rdr.readObject();
		    	JsonArray results = obj.getJsonArray("items");
		    	for (JsonObject result : results.getValuesAs(JsonObject.class)) {
				// Loop through the response and do stuff with it
		    		String resultId = result.getJsonObject("id").getString("videoId");
		    		String resultTitle = result.getJsonObject("snippet").getString("title");
		    		Video vid = new Video(resultTitle, resultId);
		    		videos.add(vid);
		    		
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		YoutubeSearch search = new YoutubeSearch("hotdogs");
		for (Video vid : search.videos) {
			System.out.println(vid.getUrl());
		}
		System.out.println(search.query);
		System.out.println(apiKey);

	}

}
