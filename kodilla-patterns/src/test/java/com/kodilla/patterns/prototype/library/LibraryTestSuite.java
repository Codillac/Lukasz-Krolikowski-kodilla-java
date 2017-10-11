package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("The Great Library of Alexandria");
        IntStream.iterate(0, n -> n + 1)
                .limit(12)
                .forEach(n -> library.addBookToLibrary(new Book("Title " + (n + 1), "Author " + (n + 1), LocalDate.of(1900 + n*10, 1 + n, 5 + n))));

        Library shallowlyClonedLibrary = null;
        try {
            shallowlyClonedLibrary = library.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        shallowlyClonedLibrary.setName("Library of Congress");

        Library deeplyClonedLibrary = null;
        try {
            deeplyClonedLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        deeplyClonedLibrary.setName("Library Of MIT");

        //When
        try {
            library.getBooks().remove(library.searchBook("Title 1", "Author 1", LocalDate.of(1900, 1, 5)));
        } catch (Exception e) {
            System.out.println(e);
        }


        //Then;
        Assert.assertEquals(11, library.getBooks().size());
        Assert.assertEquals(11, shallowlyClonedLibrary.getBooks().size());
        Assert.assertEquals(12, deeplyClonedLibrary.getBooks().size());
    }
}
