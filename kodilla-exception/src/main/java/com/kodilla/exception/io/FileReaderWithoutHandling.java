package com.kodilla.exception.io;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReaderWithoutHandling {
    public void readFile() throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();

        URI uri = classLoader.getSystemResource("file").toURI();
        String mainPath = Paths.get(uri).toString();
        Path path = Paths.get(mainPath ,"names.txt");

        Stream<String> fileLines = Files.lines(path);
        fileLines.forEach(System.out::println);
    }
}
