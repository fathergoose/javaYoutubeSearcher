package fathergoose;

public class YoutubeSearch {
	
	static final String apiKey = System.getenv("YOUTUBE_API_KEY");

	public static void main(String[] args) {
		String query = args[0];
		System.out.println(query);
		System.out.println(apiKey);

	}

}
