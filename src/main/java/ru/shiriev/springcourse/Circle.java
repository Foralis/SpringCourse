package ru.shiriev.springcourse;


public class Circle extends Shape{
    Coordinate center;

    public Circle(Coordinate center) {
        this.center = center;
    }

    @Override
    public void draw() {
        System.out.println(String.format(text, "круг", center.getX(),
                center.getY()));
    }
}
