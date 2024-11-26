package hust.soict.dsai.aims.media;


public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;

	public DigitalVideoDisc(String title) {
		super(nbDigitalVideoDiscs++, title, null, 0, 0, null);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(nbDigitalVideoDiscs++, title, category, cost, 0, null);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(nbDigitalVideoDiscs++, title, category, cost, 0, director);
	}
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(nbDigitalVideoDiscs++, title, category, cost, length, director);
	}
	
	public boolean isMatch(String title) {
		return title == getTitle();
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
