package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
    public void readFile() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();

        URI uri = classLoader.getSystemResource("file").toURI();
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath ,"names.txt");

        try (Stream<String> fileLines = Files.lines(path)) {
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Oh no! Something went wrong! Error: " + e);
        } finally {
            System.out.println("I'm gonna be here... always!");
        }
    }
}
