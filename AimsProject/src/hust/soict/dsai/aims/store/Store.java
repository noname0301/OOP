package hust.soict.dsai.aims.store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media addedMedia) {
		if (itemsInStore.contains(addedMedia)) {
			System.out.println("Media is already in store");
			return;
		}
		itemsInStore.add(addedMedia);
		System.out.println("\"" + addedMedia.getTitle() + "\" has been added to store");
	}
	
	public void removeMedia(Media removedMedia) {
		if (itemsInStore.contains(removedMedia)) {
			itemsInStore.remove(removedMedia);
			System.out.println("\"" + removedMedia.getTitle() + "\" has been removed from store");
			return;
		}
		System.out.println("No media found");
	}
	
	public boolean showStore() {
		if (itemsInStore.isEmpty()) {
			System.out.println("No item in store");
			return false;
		}
		System.out.println("Store items:");
		System.out.println("--------------------------------");
		for (Media media : itemsInStore) {
			System.out.println("- " + media.getTitle());
		}
		System.out.println("--------------------------------");
		return true;
	}
	
	public Media findMedia(String title) {
		for (Media media : itemsInStore) {
			if (media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}
	
	public ArrayList<Media> getItemsInStore() {
		for (int i = 0; i < 9; i++) itemsInStore.add(new Media(0, "Tarzan", "Cartoon", 19f));
		System.out.println(itemsInStore.size());
		return itemsInStore;
	}
}
