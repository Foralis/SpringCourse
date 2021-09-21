package ru.shiriev.springcource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        Circle circle = context.getBean(Circle.class);
        Point point = context.getBean(Point.class);
        circle.setCoordsX(5);
        circle.setCoordsY(5);
        System.out.println(circle.draw());
        System.out.println(point.draw());
    }
}
