package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[0];
	public void addDVD(DigitalVideoDisc dvd) {
		itemsInStore = java.util.Arrays.copyOf(itemsInStore, itemsInStore.length + 1);
		itemsInStore[itemsInStore.length - 1] = dvd;
		System.out.println("The disc \"" + dvd.getTitle() + "\" has been added");
	}
	public void removeDVD(DigitalVideoDisc dvd) {
		for (int i = 0; i < itemsInStore.length; i++) {
			if (itemsInStore[i].getTitle() == dvd.getTitle()) {
				System.arraycopy(itemsInStore, i+1, itemsInStore, i, itemsInStore.length-1-i);
				itemsInStore = java.util.Arrays.copyOf(itemsInStore, itemsInStore.length - 1);
				System.out.println("The disc \"" + dvd.getTitle() + "\" has been removed");
				return;
			}
		}
		System.out.println("No disc \"" + dvd.getTitle() + "\" in cart");
	}
}
