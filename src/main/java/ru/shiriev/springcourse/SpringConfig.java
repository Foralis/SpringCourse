package ru.shiriev.springcourse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {

    @Bean
    @Scope("prototype")
    public Circle circle(){
        Coordinate coordinate = coordinate();
        coordinate.setX(5);
        coordinate.setY(5);
        return new Circle(coordinate);
    }

    @Bean
    @Scope("prototype")
    public Point point(){
        Coordinate coordinate = coordinate();
        coordinate.setX(7);
        coordinate.setY(7);
        return new Point(coordinate);
    }

    @Bean
    public DrawingBoard drawingBoard(){
        return new DrawingBoard(circle(), point());
    }

    @Bean
    @Scope("prototype")
    public Coordinate coordinate() { return new Coordinate(0,0);}

    @Bean
    public Scene scene() {
        Scene scene = new Scene();
        Circle circle ;
        Point point;

        circle = circle();
        circle.center.setX(1);
        circle.center.setY(1);
        scene.list.add(circle);

        circle = circle();
        circle.center.setX(2);
        circle.center.setY(2);
        scene.list.add(circle);

        point = point();
        point.coordinate.setX(3);
        point.coordinate.setY(3);
        scene.list.add(point);

        point = point();
        point.coordinate.setX(4);
        point.coordinate.setY(4);
        scene.list.add(point);

        return scene;
    }
}
