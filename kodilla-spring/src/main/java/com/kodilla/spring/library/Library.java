package com.kodilla.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class Library {
    private final List<String> books = new ArrayList<>();

    public Library(LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    public Library() {
    }

    private LibraryDbController libraryDbController;

    public boolean saveToDb() {
        libraryDbController.saveData();
        return true;
    }

    public boolean loadFromDb() {
        libraryDbController.loadData();
        return true;
    }
}
