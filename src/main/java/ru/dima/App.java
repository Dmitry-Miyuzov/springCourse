package ru.dima;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.dima.config.JavaConfig;
import ru.dima.dao.courseDao.CourseDao;
import ru.dima.dao.courseDao.entity.CourseEntity;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        CourseDao dao = context.getBean(CourseDao.class);

        CourseEntity entity = dao.save(new CourseEntity().setTitle("title").setDescription("description"));

        dao.findByTitle("title")
                .forEach(System.out::println);
        dao.findCustomByIdForExampleNative(entity.getId());
        dao.findCustomByIdForExampleJPQL(entity.getId());

        dao.deleteAllByTitle("title");
    }
}
