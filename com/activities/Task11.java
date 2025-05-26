package activities;

import java.util.List;

/**
 * Book 1:
 * Title: "Java Programming"
 * Author: "John Smith"
 * Year Published: 2021
 * Price: $39.99
 * *
 * Book 2:
 * Title: "Python Basics"
 * Author: "Jane Doe"
 * Year Published: 2020
 * Price: $29.99
 * *
 * Book 3:
 * Title: "C++ Essentials"
 * Author: "Michael Johnson"
 * Year Published: 2019
 * Price: $49.99
 */
public class Task11 {
	public static void main(String[] args) {
		List<Book> books = List.of(
			new Book( "Java Programming", "John Smith",2021, 39.99F),
			new Book( "Python Basics", "Jane Doe",2020, 29.99F),
			new Book( "C++ Essentials", "Michael Johnson",2019, 49.99F)
		);
		
		// books.forEach(book -> System.out.println("Book :" + "\nTitle: \"" + book.getTitle() + "\"\nAuthor: \"" + book.getAuthor() + "\"\nYear Published: " + book.getYearPublished() + "\nPrice: $" + book.getPrice() + "\n"));
		int count = 0;
		for(Book book: books)
			System.out.println("Book " + ++count + ": \n" + book.toString() + "\n");
	}
}

class Book {
	private final String title;
	private final String author;
	private final int yearPublished;
	private final float price;
	
	public Book(String title, String author, int yearPublished, float price) {
		this.title = title;
		this.author = author;
		this.yearPublished = yearPublished;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Title: \"" + title + "\"\n" + "Author: \"" + author + "\"\n" + "Year Published: " + yearPublished + "\n" + "Price: $" + price;
	}
}