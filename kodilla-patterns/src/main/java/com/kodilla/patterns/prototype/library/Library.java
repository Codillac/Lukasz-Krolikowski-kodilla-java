package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Library extends Prototype {
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void addBookToLibrary(Book book) {
        books.add(book);
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library)super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = (Library)super.clone();
        clonedLibrary.books = new HashSet<>();
        for (Book book : books) {
            clonedLibrary.getBooks().add(book);
        }
        return clonedLibrary;
    }

    public Book searchBook(String title, String author, LocalDate publicationDate) {

        Book resultBook = null;
        Iterator<Book> listOfBooksIterator = books.iterator();
        boolean ifHasBeenFound = false;
        while (listOfBooksIterator.hasNext() && !ifHasBeenFound) {
            Book currentBook = listOfBooksIterator.next();
            if (currentBook.getTitle().equals(title) && currentBook.getAuthor().equals(author) && currentBook.getPublicationDate().equals(publicationDate)) {
                resultBook = currentBook;
            }
        }
        if (resultBook == null) {
            throw new NullPointerException("Book not found!");
        }
        return resultBook;
    }
}
