package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;

public class StreamMain {

    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Ala ma kota", poem -> poem.toUpperCase());
        poemBeautifier.beautify("Ala ma kota", poem -> "ABC " + poem + " ABC");
        poemBeautifier.beautify("Ala ma kota", poem -> poem.replace('l', 'd'));
        poemBeautifier.beautify("Ala ma kota", poem -> poem.replaceAll("Ala ma kota", "Kazik ma psa"));


        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

    }


}