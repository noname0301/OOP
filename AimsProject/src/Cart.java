
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("Exceed cart's capacity");
			return;
		}
		itemsOrdered[qtyOrdered++] = disc;
		System.out.println("The disc \"" + disc.getTitle() + "\" has been added");
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		if (qtyOrdered + dvdList.length > MAX_NUMBERS_ORDERED) {
			System.out.println("Exceed cart's capacity");
			return;
		}
		for (int i = 0; i < dvdList.length; i++) {
			addDigitalVideoDisc(dvdList[i]);
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered + 2 > MAX_NUMBERS_ORDERED) {
			System.out.println("Exceed cart's capacity");
			return;
		}
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].getTitle() == disc.getTitle()) {
				System.arraycopy(itemsOrdered, i+1, itemsOrdered, i, itemsOrdered.length-1-i);
				qtyOrdered--;
				System.out.println("The disc \"" + disc.getTitle() + "\" has been removed");
				return;
			}
		}
		System.out.println("No disc \"" + disc.getTitle() + "\" in cart");
	}
	public float totalCost() {
		float cost = 0;
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] != null) {
				cost += itemsOrdered[i].getCost();
			}
		}
		return cost;
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.printf("%d. DVD - %s - %s - %s - %d: %f$\n", i+1,
					itemsOrdered[i].getTitle(), itemsOrdered[i].getCategory(), itemsOrdered[i].getDirector(), itemsOrdered[i].getLength(), itemsOrdered[i].getCost());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}
}
