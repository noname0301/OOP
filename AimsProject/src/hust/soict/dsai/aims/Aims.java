package hust.soict.dsai.aims;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		}
	
	public static void filterMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter by ID");
		System.out.println("2. Filter by title");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void sortMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by title");
		System.out.println("2. Sort by cost");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static void updateStoreMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media");
		System.out.println("2. Remove a media");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	public static String getMediaTitleFromInput() {
		System.out.println("Title of the media:");
		String title = scanner.nextLine();
		return title;
	}
	
	public static int optionChoice() {
		int option = scanner.nextInt();
		scanner.nextLine();
		return option;
	}
	
	static Scanner scanner;
	static Store store;
	static Cart cart;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scanner = new Scanner(System.in);
		store = new Store();
		cart = new Cart();
		boolean running = true;
		
		while (running) {
			System.out.println("_____________________________________");
			showMenu();
			int option = optionChoice();
			switch (option) {
			case 1:
				viewStore();
				break;
			case 2:
				updateStore();
				break;
			case 3:
				seeCurrentCart();
				break;
			case 0:
				running = false;
				break;
			default:
				break;
			}
		}
		scanner.close();
		System.exit(0);
	}

	
	public static void viewStore() {
		while (true) {
			System.out.println("_____________________________________");
			if (!store.showStore()) {
				return;
			}
			storeMenu();
			int option = optionChoice();
			switch (option) {
			case 1:
				seeMediaDetail();
				break;
			case 2:
				addMediaToCart();
				break;
			case 3:
				playMedia();
				break;
			case 4:
				seeCurrentCart();
				break;
			case 0:
				return;
			default:
				break;
			}
		}
	}
	
	public static void seeMediaDetail() {
		String title = getMediaTitleFromInput();
		Media media = store.findMedia(title);
		
		while (true) {
			System.out.println("_____________________________________");
			if (media == null) {
				System.out.println("No media found");
				return;
			}
			
			media.showDetails();
			mediaDetailsMenu();
			int option = optionChoice();
			switch (option) {
			case 1:
				cart.addMedia(media);
				break;
			case 2:
				if (media instanceof DigitalVideoDisc) {
					((DigitalVideoDisc) media).play();
				}
				else if (media instanceof CompactDisc) {
					((CompactDisc) media).play();
				}
				else {
					System.out.println("Cannot play this type of media");
				}
				break;
			case 0:
				return;
			default:
				break;
			}
		}
	}
	
	public static void addMediaToCart() {
		String title = getMediaTitleFromInput();
		Media media = store.findMedia(title);
		if (media == null) {
			System.out.println("No media found");
			return;
		}
		cart.addMedia(media);
	}
	
	public static void playMedia() {
		String title = getMediaTitleFromInput();
		Media media = store.findMedia(title);
		if (media == null) {
			System.out.println("No media found");
			return;
		}
		
		if (media instanceof DigitalVideoDisc) {
			((DigitalVideoDisc) media).play();
		} else if (media instanceof CompactDisc) {
			((CompactDisc) media).play();
		} else {
			System.out.println("Cannot play this type of media");
		}
	}
	
	public static void updateStore() {
		while(true) {
			System.out.println("_____________________________________");
			updateStoreMenu();
			int option = optionChoice();
			String title;
			switch (option) {
			case 1:
				title = getMediaTitleFromInput();
				store.addMedia(new Media(title));
				break;
			case 2:
				title = getMediaTitleFromInput();
				store.removeMedia(store.findMedia(title));
				break;
			case 0:
				return;
			default:
				break;
			}
		}
	}
	
	public static void seeCurrentCart() {
		while (true) {
			System.out.println("_____________________________________");
			if (!cart.showCart()) {
				return;
			}
			cartMenu();
			int option = optionChoice();
			switch (option) {
			case 1:
				filterMedia();
				break;
			case 2:
				sortMedia();
				break;
			case 3:
				removeMedia();
				break;
			case 4:
				playMediaCart();
				break;
			case 5:
				placeOrder();
				break;
			case 0:
				return;
			default:
				break;
			}
		}
	}
	
	public static void filterMedia() {
		System.out.println("_____________________________________");
		System.out.println("Feature is being implemented");
//		filterMenu();
//		int option = optionChoice();
//		switch (option) {
//		case 1:
//			System.out.println("Type in the ID: ");
//			int id = scanner.nextInt();
//			scanner.nextLine();
//			
//			break;
//		case 2:
//			System.out.println("Type in the title: ");
//			String title = scanner.nextLine();
//			
//			break;
//		case 0:
//			break;
//		}
	}
	
	public static void sortMedia() {
		System.out.println("_____________________________________");
		sortMenu();
		int option = optionChoice();
		switch (option) {
		case 1:
			cart.sortTitle();
			break;
		case 2:
			cart.sortCost();
			break;
		case 0:
			break;
		}
	}
	
	public static void removeMedia() {
		
	}
	
	public static void playMediaCart() {
		
	}
	
	public static void placeOrder() {
		System.out.println("Order done!");
		cart = new Cart();
	}
}
