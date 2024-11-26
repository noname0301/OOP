package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	public MediaComparatorByCostTitle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
		String title1 = o1.getTitle(), title2 = o2.getTitle();
		float cost1 = o1.getCost(), cost2 = o2.getCost();
		return Float.compare(cost1, cost2) != 0 ? Float.compare(cost1, cost2) : title1.compareTo(title2);
	}

}
