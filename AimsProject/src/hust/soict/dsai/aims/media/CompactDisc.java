package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	public String getArtist() {
		return artist;
	}
	public void addTrack(Track addedTrack) {
		for (Track track : tracks) {
			if (track.getTitle() == addedTrack.getTitle()) {
				System.out.println("Track is already in the list");
				return;
			}
		}
		tracks.add(addedTrack);
		System.out.println("Track " + addedTrack.getTitle() + " has been added");
	}
	
	public void removeTrack(Track removedTrack) {
		for (Track track : tracks) {
			if (track.getTitle() == removedTrack.getTitle()) {
				tracks.remove(removedTrack);
				System.out.println("Track " + removedTrack.getTitle() + " has been removed");
				return;
			}
		}
		System.out.println("Track is not in the list");
	}
	
	public int getLength() {
		int length = 0;
		for (Track track : tracks) {
			length += track.getLength();
		}
		return length;
	}
	
	public void play() {
		for (Track track : tracks) {
			track.play();
		}
	}
}
