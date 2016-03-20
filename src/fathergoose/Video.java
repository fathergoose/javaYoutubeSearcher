package fathergoose;

import java.net.MalformedURLException;
import java.net.URL;

public class Video {
	private String title;
	private URL url;
	public String getTitle() {
		return title;
	}
	public URL getUrl() {
		return url;
	}
	
	public Video(String t, String vidid) throws MalformedURLException {
		String ulink = "https://youtube.com/watch?v=" + vidid;
		url = new URL(ulink);
		title = t;
	}

}
