package hust.soict.dsai.aims.cart;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	
	private ArrayList<Media> itemOrdered = new ArrayList<Media>();
	
	public void addMedia(Media addedMedia) {
		if (itemOrdered.contains(addedMedia)) {
			System.out.println("Media is already in the list");
			return;
		}
		itemOrdered.add(addedMedia);
		System.out.println("Added" + addedMedia.getTitle());
	}
	
	public void removeMedia(Media removedMedia) {
		if (itemOrdered.contains(removedMedia)) {
			itemOrdered.remove(removedMedia);
			System.out.println("Removed" + removedMedia.getTitle());
			return;
		}
		System.out.println("No media found");
	}
	
	public float totalCost() {
		float cost = 0;
		for (Media media : itemOrdered) {
			cost += media.getCost();
		}
		return cost;
	}
	
}
