package ru.shiriev.springcource;

public abstract class Shape {
    private String color;
    public abstract String draw();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
