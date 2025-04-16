package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {

    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Ala ma kota", poem -> poem.toUpperCase());
        poemBeautifier.beautify("Ala ma kota", poem -> "ABC " + poem + " ABC");
        poemBeautifier.beautify("Ala ma kota", poem -> poem.replace('l', 'd'));
        poemBeautifier.beautify("Ala ma kota", poem -> poem.replaceAll("Ala ma kota", "Kazik ma psa"));

    }
}