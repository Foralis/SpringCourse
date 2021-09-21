package ru.shiriev.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Circle extends Shape{


    Coordinate center;

    @Autowired
    public Circle(Coordinate center) {
        this.center = center;
    }

    @Override
    public void draw() {
        System.out.println(String.format(text, "круг", center.getX(),
                center.getY()));
    }
}
