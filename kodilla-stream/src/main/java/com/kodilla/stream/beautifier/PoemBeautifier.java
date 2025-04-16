package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public String beautify(String poem, PoemDecorator poemDecorator) {
        String beautified = poemDecorator.decorate(poem);
        System.out.println(beautified);
        return beautified;
    }

}
