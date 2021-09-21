package ru.shiriev.springcourse;

public class Point extends Shape{

   Coordinate coordinate;

   public Point(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public void draw() {
        System.out.println(String.format(text, "точку", coordinate.getX(),
                coordinate.getY()));
    }
}
