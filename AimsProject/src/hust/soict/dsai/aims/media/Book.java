package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();




	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
		// TODO Auto-generated constructor stub
	}



	public Book(int id, String title, String category, float cost, List<String> authors) {
		super(id, title, category, cost);
		this.authors = authors;
	}
    
    

	public List<String> getAuthors() {
		return authors;
	}



	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}



	public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author " + authorName + " added.");
        } else {
            System.out.println("Author " + authorName + " already exists.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author " + authorName + " removed.");
        } else {
            System.out.println("Author " + authorName + " does not exist.");
        }
    }


    public void print() {
    	System.out.print(this.getId() + " Book: " + this.getTitle() + " " + this.getCategory() + " ");
    	for (String author : authors) {
    		System.out.println(author + " ");
    	}
    	System.out.println(this.getCost() + "$");
    }
}
