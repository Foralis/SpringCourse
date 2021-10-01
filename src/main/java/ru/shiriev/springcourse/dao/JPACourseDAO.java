package ru.shiriev.springcourse.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

//@Service("jpaCourseService") // помечаем те бины, которые содержат бизнес логику на уровне служб
@Repository("courseDal") // помечаем те бины, которые используется на уровне доступа к данным Не используется @component
// так как нужна работа с иключениями бд Spring
@Transactional(isolation = Isolation.READ_COMMITTED, timeout = 20, propagation = Propagation.REQUIRED)
public class JPACourseDAO implements CourseDAO{
    private static final Log LOG = LogFactory.getLog(JPACourseDAO.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    @Cacheable("courses")
    public Course findById(int id) {
        return em.find(Course.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return em.createQuery("select c from Course c", // JPQL
                Course.class).getResultList();
    }

    @Override
    public void insert(Course course) {
        em.persist(course);
        LOG.info("Course saved with id: " + course.getId());
    }

    @Override
    @CachePut(value = "courses", key = "#course.id")
    public void update(Course course) {
        if(course.getId() != 0) {
            Course updateCourse = em.merge(course);
        }
        LOG.info("Course updated with id: " + course.getId());
    }

    @Override
    @CacheEvict("corses")
    public void delete(int id) {
        em.remove(findById(id));
        LOG.info("Course deleted with id: " + id);
    }
}
