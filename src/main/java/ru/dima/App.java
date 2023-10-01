package ru.dima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.dima.config.JavaConfig;
import ru.dima.dao.courseDao.CourseDao;
import ru.dima.dao.courseDao.entity.CourseEntity;

import java.io.Closeable;

public class App {
    public static void main(String[] args) {
        System.out.println(System.getenv("db.password"));
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);

        CourseDao courseDao = context.getBean(CourseDao.class);
        System.out.println("Получаем один");
        System.out.println(courseDao.findById(1));
        System.out.println("Закончили.");

        CourseEntity courseEntity = new CourseEntity()
                .setLength(131)
                .setDescription("моеописание")
                .setTitle("мойзаголовок");
        System.out.println("До инсерта");
        System.out.println(courseEntity);
        courseDao.insert(courseEntity);
        System.out.println("После инсерта");
        System.out.println(courseEntity);

        courseDao.delete(courseEntity.getId());


        ((AnnotationConfigApplicationContext) context).close();
    }
}
