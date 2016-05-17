// ch16
// Eliminating duplicates
import java.util.*;
import java.io.*;

public class Jukebox6 {
	
	ArrayList<Song> songList = new ArrayList<Song>();
	
	public static void main(String[] args) {
		new Jukebox6().go();
	}
	
	
	public void go() {
		getSong();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
		
		// eliminate duplicates
		HashSet<Song> songSet = new HashSet<Song>();
		songSet.addAll(songList);
		System.out.println(songSet);
		
		
		// remove duplicates AND stay sorted
		TreeSet<Song> treeSet = new TreeSet<Song>();
		treeSet.addAll(songList);
		System.out.println(treeSet);
	}
	
	void getSong() {
		try {
			File file = new File("SongListMore.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				addSong(line);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	void addSong(String lineToParse) {
		String[] tokens = lineToParse.split("/");
		Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
		songList.add(nextSong);
	}
	
}