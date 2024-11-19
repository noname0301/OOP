
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
			return;
		}
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] == null) {
				itemsOrdered[i] = disc;
				qtyOrdered++;
				break;
			}
		}
		System.out.println("The disc \"" + disc.getTitle() + "\" has been added");
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
			if (itemsOrdered[i] != null && itemsOrdered[i].getTitle() == disc.getTitle()) {
				itemsOrdered[i] = null;
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
}
