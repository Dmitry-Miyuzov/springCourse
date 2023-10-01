package ru.dima.dao.courseDao;

import ru.dima.dao.courseDao.entity.CourseEntity;

import java.util.List;

public interface CourseDao {
    CourseEntity findById(int id);
    List<CourseEntity> findAll();
    List<CourseEntity> findByTitle(String title);

    // CRUD
    void insert(CourseEntity course);
    void update(CourseEntity course);
    void delete(int id);
}
