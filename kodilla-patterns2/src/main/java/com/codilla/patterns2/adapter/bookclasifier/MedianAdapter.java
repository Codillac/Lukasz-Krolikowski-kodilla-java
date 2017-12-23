package com.codilla.patterns2.adapter.bookclasifier;

import com.codilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.codilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.codilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<Book> bookSet) {
        Map<BookSignature, com.codilla.patterns2.adapter.bookclasifier.libraryb.Book> bookMap = new HashMap<>();
        for (Book book : bookSet) {
            com.codilla.patterns2.adapter.bookclasifier.libraryb.Book bookB = new com.codilla.patterns2.adapter.bookclasifier.libraryb.Book(book.getAuthor(), book.getTitle(), book.getPublicationYear());

            bookMap.put(new BookSignature(book.getSignature()), bookB);
        }
        return medianPublicationYear(bookMap);
    }
}
