package ru.shiriev.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DrawingBoard drawingBoard = context.getBean(DrawingBoard.class);
        drawingBoard.circle.draw();
        drawingBoard.point.draw();
        drawingBoard.circle.center.setX(10);
        drawingBoard.circle.center.setY(7);
        drawingBoard.circle.draw();
        drawingBoard.point.draw();

        Scene scene = context.getBean(Scene.class);
        scene.draw();
    }

}
