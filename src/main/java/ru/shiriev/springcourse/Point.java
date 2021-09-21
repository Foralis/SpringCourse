package ru.shiriev.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Point extends Shape{

   Coordinate coordinate;

   @Autowired
    public Point(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public void draw() {
        System.out.println(String.format(text, "точку", coordinate.getX(),
                coordinate.getY()));
    }
}
