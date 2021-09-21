package ru.shiriev.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DrawingBoard {

    Circle circle;
    Point point;

    @Autowired
    public DrawingBoard(Circle circle, Point point) {
        this.circle = circle;
        this.point = point;
    }
}
