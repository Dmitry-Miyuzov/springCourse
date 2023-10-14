package ru.dima.dao.courseDao;

import org.springframework.transaction.annotation.Transactional;
import ru.dima.dao.courseDao.entity.CourseEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
public class CourseDaoImpl implements CourseDaoCustom<CourseEntity> {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void deleteAllByTitle(String title) {
        entityManager.createQuery("delete from CourseEntity c where c.title = :title")
                .setParameter("title", title)
                .executeUpdate();

        System.out.println("Allure Step");
    }
}
