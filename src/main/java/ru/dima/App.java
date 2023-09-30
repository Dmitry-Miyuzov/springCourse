package ru.dima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.dima.beans.shape.concrete.Circle;
import ru.dima.beans.shape.concrete.Point;
import ru.dima.config.SpringConfig;

public class App {

    public static void main(String[] args) {
        ApplicationContext contextJavaConfig = new AnnotationConfigApplicationContext(SpringConfig.class);
        contextJavaConfig.getBean(Circle.class).draw();
        contextJavaConfig.getBean(Circle.class).draw();
        contextJavaConfig.getBean(Point.class).draw();
        contextJavaConfig.getBean(Point.class).draw();

    }


}
