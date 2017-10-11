package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("The Great Library of Alexandria");
        IntStream.iterate(0, n -> n + 1)
                .limit(12)
                .forEach(n -> library.books.add(new Book("Title " + (n + 1), "Author " + (n + 1), LocalDate.of(1900 + n*10, 1 + n, 5 + n))));

        //When
        Set<Book> resultSetOfBooks = library.getBooks();

        //Then
        library.getBooks().stream().forEach(System.out::println);
        Assert.assertEquals(library.getBooks().size(), resultSetOfBooks.size());
    }
}
