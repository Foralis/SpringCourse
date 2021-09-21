package ru.shiriev.springcourse;

import org.springframework.stereotype.Component;

@Component
public abstract class Shape {
    private String color;
    public abstract void draw();
    String text = "Рисую %s с координатами %d, %d";

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
