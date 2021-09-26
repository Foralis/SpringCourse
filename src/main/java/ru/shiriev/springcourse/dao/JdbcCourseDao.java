package ru.shiriev.springcourse.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JdbcCourseDao implements CourseDAO{
    public static final String SQL_SELECT_COURSE = "select id, title, length, description from courses";
    public static final String SQL_SELECT_COURSE_BY_ID = SQL_SELECT_COURSE + " WHERE id = ?";
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(SQL_SELECT_COURSE);
        List<Course> courses = new ArrayList<>();
        for(Map<String, Object> row : rows) {
            Course c = new Course();
            c.setId((int)row.get("id"));
            c.setTitle((String)row.get("title"));
            c.setLength((int)row.get("length"));
            c.setDescription((String)row.get("description"));
            courses.add(c);
        }
        return courses;
    }
}
