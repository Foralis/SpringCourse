package ru.shiriev.springcource;

public class Circle extends Shape{
    private Coords center;
    private int radius;

    public Coords getCenter() {
        return center;
    }

    public void setCenter(Coords center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void getCoordsX() {
        this.center.getX();
    }

    public void setCoordsX(int x) {
        this.center.setX(x);
    }

    public void getCoordsY() {
        this.center.getY();
    }

    public void setCoordsY(int y) {
        this.center.setX(y);
    }

    @Override
    public String draw() {
        return "Рисую круг. Цвет = " + getColor();
    }

}
