package ru.shiriev.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.shiriev.springcourse.dao.Course;
import ru.shiriev.springcourse.dao.CourseDAO;

public class Application {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseDAO courseDAO = context.getBean(CourseDAO.class);
        for(Course c: courseDAO.findAll())
            System.out.println(c);

        System.out.println(courseDAO.findById(4));
        context.close();
    }

}
