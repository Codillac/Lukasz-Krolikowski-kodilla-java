package com.codilla.patterns2.adapter.bookclassifier;

import com.codilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.codilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedianAdapterTestSuite {
    @Autowired
    MedianAdapter medianAdapter;

    @Test
    public void publicationYearMedianTest() {
        //Given
        Set<Book> booksFromLibraryA = new HashSet<>();
        booksFromLibraryA.add(new Book("Neal Stephenson", "Peanatema", 2008, "ISBN-02333319823795"));
        booksFromLibraryA.add(new Book("Klaus Schwab", "The fourth industrial revolution", 2016, "ISBN-5873984843332"));
        booksFromLibraryA.add(new Book("Ash Maurya", "Running Lean", 2013, "ISBN-9788324657261"));
        booksFromLibraryA.add(new Book("Frank Herbert", "Dune", 1965, "ISBN-4538757833847"));
        booksFromLibraryA.add(new Book("Charles Duhigg", "Smarter Faster Better", 2015, "ISBN-0832749823238"));

        //When
        int result = medianAdapter.publicationYearMedian(booksFromLibraryA);
        System.out.println("The median year is: " + result);

        //Then
        Assert.assertEquals(2013, result);
    }
}