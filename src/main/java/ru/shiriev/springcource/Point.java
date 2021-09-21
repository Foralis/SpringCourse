package ru.shiriev.springcource;

public class Point extends Shape{
    private Coords coords;

    public Point(Coords coords) {
        this.coords = coords;
    }

    public Coords getCoords() {
        return coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }

    public void getCoordsX() {
        this.coords.getX();
    }

    public void setCoordsX(int x) {
        this.coords.setX(x);
    }

    public void getCoordsY() {
        this.coords.getY();
    }

    public void setCoordsY(int y) {
        this.coords.setX(y);
    }

    @Override
    public String draw() {
        return "Рисую точку. Цвет = " + getColor();
    }

}
