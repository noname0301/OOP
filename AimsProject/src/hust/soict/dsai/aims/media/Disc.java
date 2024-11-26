package hust.soict.dsai.aims.media;

public class Disc extends Media {
	private int length;
	private String director;
	
	public Disc() {
		// TODO Auto-generated constructor stub
	}
	public Disc(int id, String title, String category, float cost, int length, String director) {	
		super(id, title, category, cost);
		this.director = director;
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}
	
}
