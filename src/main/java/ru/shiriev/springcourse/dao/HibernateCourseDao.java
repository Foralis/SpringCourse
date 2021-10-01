//package ru.shiriev.springcourse.dao;
//
//import org.hibernate.SessionFactory;
//import org.springframework.stereotype.Repository;
//
//
//import javax.annotation.Resource;
//import javax.transaction.Transactional;
//import java.util.List;
//
//
//import org.apache.commons.logging.LogFactory;
//import org.apache.commons.logging.Log;
//
//@Transactional
//@Repository("courseDao")
//public class HibernateCourseDao implements CourseDAO{
//    private static final Log LOG = LogFactory.getLog(HibernateCourseDao.class);
//
//    private SessionFactory sessionFactory;
//
//    public  SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    @Resource(name="sessionFactory")
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Override
//    public Course findById(int id) {
//        return getSessionFactory().getCurrentSession().byId(Course.class).load(id);
//    }
//
//    @Override
//    public List<Course> findAll() {
//        // HQL
//        return getSessionFactory().getCurrentSession().createQuery("from Course c").list();
//    }
//
////    @Override
////    public List<Course> findByTitle(String title) {
////        return getSessionFactory().getCurrentSession().createQuery("from Course x where x.title LIKE :search").
////                setParameter("search","%" + title.trim() + "%").list();
////    }
//
//    @Override
//    public void insert(Course course) {
//        getSessionFactory().getCurrentSession().save(course);
//        LOG.info("Course saved with id: " + course.getId());
//    }
//
//    @Override
//    public void update(Course course) {
//        getSessionFactory().getCurrentSession().update(course);
//        LOG.info("Course updated with id: " + course.getId());
//    }
//
//    @Override
//    public void delete(int id) {
//        Course c = new Course();
//        c.setId(id);
//        getSessionFactory().getCurrentSession().delete(c);
//        LOG.info("Course deleted with id: " + c.getId());
//    }
//}
