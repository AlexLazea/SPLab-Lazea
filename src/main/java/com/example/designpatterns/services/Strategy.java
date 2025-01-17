package com.example.designpatterns.services;

import com.example.designpatterns.models.Paragraph;

public interface Strategy {
    public default void render(Paragraph paragraph, int width){}
}
