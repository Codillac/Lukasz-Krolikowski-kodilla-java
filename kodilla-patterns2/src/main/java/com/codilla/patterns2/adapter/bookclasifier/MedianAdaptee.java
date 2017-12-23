package com.codilla.patterns2.adapter.bookclasifier;

import com.codilla.patterns2.adapter.bookclasifier.libraryb.Book;
import com.codilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.codilla.patterns2.adapter.bookclasifier.libraryb.BookStatistics;
import com.codilla.patterns2.adapter.bookclasifier.libraryb.Statistics;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {
    @Autowired
    Statistics statistics;

    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        return statistics.averagePublicationYear(books);
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, Book> books) {
        return statistics.medianPublicationYear(books);
    }
}
