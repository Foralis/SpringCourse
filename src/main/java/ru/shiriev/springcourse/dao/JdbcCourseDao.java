package ru.shiriev.springcourse.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class CourseRowMapper implements RowMapper<Course> {
    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
        Course c = new Course();
        c.setId((int)rs.getInt("id"));
        c.setTitle((String)rs.getString("title"));
        c.setLength((int)rs.getInt("length"));
        c.setDescription((String)rs.getString("description"));
        return c;
    }
}

public class JdbcCourseDao implements CourseDAO{
    public static final String SQL_SELECT_COURSE = "select id, title, length, description from courses";
    public static final String SQL_SELECT_COURSE_BY_ID = SQL_SELECT_COURSE + " WHERE id = ?";
    public static final String SQL_SELECT_COURSE_BY_TITLE = SQL_SELECT_COURSE + " WHERE title like ?";
    public static final String SQL_DELETE_COURSE_BY_ID = "DELETE FROM courses WHERE id = ?";
    public static final String SQL_INSERT_COURSE = "INSERT INTO courses (title,length,description) VALUES (?,?,?)";
    public static final String SQL_UPDATE_COURSE = "UPDATE courses SET title = ?, length = ?, description = ? " +
            "WHERE id = ?";
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Course findById(int id) {
        Course course =
                getJdbcTemplate().queryForObject(SQL_SELECT_COURSE_BY_ID, new Object[]{id}, new CourseRowMapper());
        return course;
    }

    @Override
    public List<Course> findAll() {
        // manual map rows to Object
//        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(SQL_SELECT_COURSE);
//        List<Course> courses = new ArrayList<>();
//        for(Map<String, Object> row : rows) {
//            Course c = new Course();
//            c.setId((int)row.get("id"));
//            c.setTitle((String)row.get("title"));
//            c.setLength((int)row.get("length"));
//            c.setDescription((String)row.get("description"));
//            courses.add(c);
//        }

        return getJdbcTemplate().query(SQL_SELECT_COURSE, new BeanPropertyRowMapper(Course.class));
    }

//    @Override
//    public List<Course> findByTitle(String title) {
//        return getJdbcTemplate().query(SQL_SELECT_COURSE_BY_TITLE, new Object[]{"%"+title+"%"},
//                new BeanPropertyRowMapper(Course.class));
//    }

    @Override
    public void insert(Course course) {
        PreparedStatementCreatorFactory f = new PreparedStatementCreatorFactory(SQL_INSERT_COURSE, Types.NVARCHAR,
                Types.INTEGER, Types.NVARCHAR);
        f.setGeneratedKeysColumnNames("id");
        KeyHolder kh = new GeneratedKeyHolder();
        getJdbcTemplate().update(f.newPreparedStatementCreator(new Object[]{course.getTitle(), course.getLength(),
                course.getDescription()}), kh);
        course.setId(kh.getKey().intValue());
    }

    @Override
    public void update(Course course) {
        getJdbcTemplate().update(SQL_UPDATE_COURSE, course.getTitle(), course.getLength(), course.getId(), course.getId());
    }

    @Override
    public void delete(int id) {
        getJdbcTemplate().update(SQL_DELETE_COURSE_BY_ID, id);
    }

    @Override
    public List<Course> findByTitle(String title) {
        return null;
    }
}
