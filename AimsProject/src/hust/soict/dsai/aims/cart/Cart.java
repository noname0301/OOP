package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	
	private ArrayList<Media> itemOrdered = new ArrayList<Media>();
	
	public void addMedia(Media addedMedia) {
		if (itemOrdered.contains(addedMedia)) {
			System.out.println("Media is already in cart");
			return;
		}
		itemOrdered.add(addedMedia);
		System.out.println("\"" + addedMedia.getTitle() + "\" has been added to cart");
	}
	
	public void removeMedia(Media removedMedia) {
		if (itemOrdered.contains(removedMedia)) {
			itemOrdered.remove(removedMedia);
			System.out.println("\"" + removedMedia.getTitle() + "\" has been removed from cart");
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
	
	public boolean showCart() {
		if (itemOrdered.isEmpty()) {
			System.out.println("Cart empty");
			return false;
		}
		System.out.println("Items ordered:");
		System.out.println("--------------------------------");
		for (Media media : itemOrdered) {
			System.out.println("- " + media.getTitle());
		}
		System.out.println("--------------------------------");
		return true;
	}
	
	public Media findMedia(String title) {
		for (Media media : itemOrdered) {
			if (media.getTitle() == title) {
				return media;
			}
		}
		return null;
	}
	
	public void sortTitle() {
		Collections.sort(itemOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	
	public void sortCost() {
		Collections.sort(itemOrdered, Media.COMPARE_BY_COST_TITLE);
	}
}
