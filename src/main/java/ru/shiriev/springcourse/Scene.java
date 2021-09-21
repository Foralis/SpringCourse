package ru.shiriev.springcourse;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    List<Shape> list = new ArrayList<>();
    public void draw(){
        for (Shape shape: list
             ) {
            shape.draw();
        }
    }
}
