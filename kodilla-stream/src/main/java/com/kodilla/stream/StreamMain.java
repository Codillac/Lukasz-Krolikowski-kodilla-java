package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {
    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("So this is how liberty dies. With the thunderous applause.", text -> text.toUpperCase());
        poemBeautifier.beautify("So this is how liberty dies. With the thunderous applause.", text -> {
            String resultText = "";
            for(int i = 0; i < text.length(); i++){
                String currentSign = "";
                currentSign += text.charAt(i);
                if(i % 2 == 0){
                    currentSign = currentSign.toUpperCase();
                }
                resultText += currentSign;
            }
            return resultText;
        });
        poemBeautifier.beautify("Beam me up, Scotty", text -> text.replace(' ', '~'));
        poemBeautifier.beautify("Beam me up, Scotty", text -> {
            String resultText = "";
            for(int i = 0; i < text.length(); i++){

                if(text.charAt(i) == ' ') {
                    resultText += " *** ";
                } else {
                    resultText += text.charAt(i);
                }
            }
            return resultText;
        });
    }
}
