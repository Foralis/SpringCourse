package ru.shiriev.springcourse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import ru.shiriev.springcourse.dao.Course;
import ru.shiriev.springcourse.dao.CourseDAO;

public class Application {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        CourseDAO courseDAO = context.getBean(CourseDAO.class);
//        for(Course c: courseDAO.findAll())
//            System.out.println(c);

        //System.out.println(courseDAO.findById(4));
//
        for(Course c: courseDAO.findByTitle("web"))
            System.out.println(c);
//
//        Course nc = new Course();
//        nc.setTitle("Spring");
//        nc.setLength(40);
//        nc.setDescription("Spring framework");
//        System.out.println(nc);
//        courseDAO.insert(nc);
//        System.out.println(nc);

//        Course s = courseDAO.findById(8);
//        s.setLength(42);
//        courseDAO.update(s);

        //courseDAO.delete(8);


        context.close();
    }

}
