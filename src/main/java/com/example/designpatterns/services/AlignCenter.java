package com.example.designpatterns.services;

import com.example.designpatterns.models.Paragraph;

public class AlignCenter implements Strategy {
    @Override
    public void render(Paragraph paragraph, int width) {
        String text = paragraph.getText();
        System.out.println("Align Center:");

        while (text.length() > width) {
            int breakPoint = text.lastIndexOf(' ', width);
            if (breakPoint == -1) { // no spaces in the range, split at the width
                breakPoint = width;
            }
            System.out.println(padCenter(text.substring(0, breakPoint), width));
            text = text.substring(breakPoint).trim(); // move to the next part, trimming leading spaces
        }
        System.out.println(padCenter(text, width)); // print the remaining part
    }

    private String padCenter(String text, int width) {
        int textLength = text.length();
        if (textLength >= width) {
            return text; // If the text is equal to or longer than the width, return it as-is
        }

        int padding = (width - textLength) / 2; // calculate padding
        String paddedText = " ".repeat(padding) + text; // add left padding
        return paddedText; // no need to trim or modify further
    }
}
