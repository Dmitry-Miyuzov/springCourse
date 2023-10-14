package ru.dima.dao.courseDao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.dima.dao.courseDao.entity.CourseEntity;

import java.util.List;

@Repository
public interface CourseDao extends CrudRepository<CourseEntity, Integer>, CourseDaoCustom<CourseEntity> {
        List<CourseEntity> findByTitle(String title); //кастомные
        List<CourseEntity> findByLength(Integer length); //кастомные
}
