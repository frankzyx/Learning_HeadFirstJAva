
// need to implement Comparable for sort() to work on ArrayList<Song>
public class Song implements Comparable<Song> {
	
	String title;
	String artist;
	String rating;
	String bpm;
	
	Song(String t, String a, String r, String b) {
		title = t;
		artist = a;
		rating = r;
		bpm = b;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getRating() {
		return rating;
	}
	
	public String getBpm() {
		return bpm;
	}
	
	// override
	public String toString() {
		// return title + ": " + artist;
		return title;
	}
	
	// override the interface method
	public int compareTo(Song s) {
		return title.compareTo(s.getTitle());
	}
	
	// override hashCode and equals
	public boolean equals(Object aSong) {
		Song s = (Song) aSong;
		return title.equals(s.getTitle());
	}
	
	public int hashCode() {
		return title.hashCode();
	}
}