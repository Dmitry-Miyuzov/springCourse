package ru.dima.dao.courseDao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.dima.dao.courseDao.entity.CourseEntity;

import java.util.List;

@Repository
public interface CourseDao extends CrudRepository<CourseEntity, Integer>, CourseDaoCustom<CourseEntity> {
        List<CourseEntity> findByTitle(String title); //кастомные
        List<CourseEntity> findByLength(Integer length); //кастомные
        @Query(value = "select * from courses where id = :id", nativeQuery = true)
        CourseEntity findCustomByIdForExampleNative(@Param("id") Integer id); // кастомный с аннотацией нативный
        @Query(value = "select c from CourseEntity  c where c.id = :id")
        CourseEntity findCustomByIdForExampleJPQL(@Param("id") Integer id); // кастомный с аннотацией не нативный

}
