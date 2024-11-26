package hust.soict.dsai.aims;

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
			showMenu();
			int option = scanner.nextInt();
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
			store.showStore();
			storeMenu();
			int option = scanner.nextInt();
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
		System.out.println("Title of the media:");
		String title = scanner.nextLine();
		Media media = store.findMedia(title);
		if (media == null) {
			System.out.println("No media found");
			return;
		}
		
		while (true) {
			mediaDetailsMenu();
			int option = scanner.nextInt();
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
		System.out.println("Title of the media:");
		String title = scanner.nextLine();
		Media media = store.findMedia(title);
		if (media == null) {
			System.out.println("No media found");
			return;
		}
		cart.addMedia(media);
	}
	
	public static void playMedia() {
		System.out.println("Title of the media:");
		String title = scanner.nextLine();
		Media media = store.findMedia(title);
		if (media == null) {
			System.out.println("No media found");
			return;
		}
		
		if (media instanceof DigitalVideoDisc) {
			((DigitalVideoDisc) media).play();
		}
		else if (media instanceof CompactDisc) {
			((CompactDisc) media).play();
		}
		else {
			System.out.println("Cannot play this type of media");
		}
	}
	
	public static void updateStore() {
		
	}
	
	public static void seeCurrentCart() {
		while (true) {
			cartMenu();
			int option = scanner.nextInt();
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
		
	}
	
	public static void sortMedia() {
		
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
