package fathergoose;

public class YoutubeSearch {
	
	static final String apiKey = System.getenv("YOUTUBE_API_KEY");

	public static void main(String[] args) {
		System.out.println(apiKey);

	}

}
