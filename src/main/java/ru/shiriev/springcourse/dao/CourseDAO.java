package ru.shiriev.springcourse.dao;

import java.util.List;

public interface CourseDAO {
    Course findById(int id);
    List<Course> findAll();

    //CRUD
//    List<Course> findByTitle(String title);
//    void insert(Course course);
//    void update(Course course);
//    void delete(int id);
}
