package com.kodilla.testing;

import java.util.Scanner;

public class VowelFinder {
    public static void main(String[] args) {
        findVowel("wYpisz każdĄ samOgłoskę");
    }

    public static String findVowel(String text) {
        StringBuilder vowels = new StringBuilder();
        String vowelChecker = "AaEeIiOoUuYyĄąĘą";
        for (int i = 0; i < text.length(); i++) {
            if (vowelChecker.indexOf(text.charAt(i)) != -1) {
                vowels.append(text.charAt(i));
            }
        }
        return vowels.toString();
    }
}
