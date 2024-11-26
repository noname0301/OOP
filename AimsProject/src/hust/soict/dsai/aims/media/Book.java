package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	
	public void addAuthor(String authorName) {
		for (String author : authors) {
			if (author == authorName) {
				System.out.println("Author is already in the list");
				return;
			}
		}
		authors.add(authorName);
		System.out.println("Author " + authorName + " has been added");
	}
	
	public void removeAuthor(String authorName) {
		for (String author : authors) {
			if (author == authorName) {
				authors.remove(author);
				System.out.println("Author " + authorName + " has been removed");
				return;
			}
		}
		System.out.println("Author is not in the list");
	}
}
