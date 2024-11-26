package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media addedMedia) {
		if (itemsInStore.contains(addedMedia)) {
			System.out.println("Media is already in the list");
			return;
		}
		itemsInStore.add(addedMedia);
		System.out.println("Added" + addedMedia.getTitle());
	}
	
	public void removeMedia(Media removedMedia) {
		if (itemsInStore.contains(removedMedia)) {
			itemsInStore.remove(removedMedia);
			System.out.println("Removed" + removedMedia.getTitle());
			return;
		}
		System.out.println("No media found");
	}
	
	public void showStore() {
		System.out.println("Store items");
		for (Media media : itemsInStore) {
			System.out.println("+ " + media.getTitle());
		}
	}
	
	public Media findMedia(String title) {
		for (Media media : itemsInStore) {
			if (media.getTitle() == title) {
				return media;
			}
		}
		return null;
	}
}
