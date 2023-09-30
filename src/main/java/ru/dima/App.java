package ru.dima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dima.beans.Scene;
import ru.dima.beans.shape.config.SceneConfig;

public class App {

    public static void main(String[] args) {
        ApplicationContext contextXmlConfig = new AnnotationConfigApplicationContext(SceneConfig.class);
        System.out.println("Создали контекст и так как ленивая инициализация - только после этого будет создан бин сцены.");
        Scene sceneRandom = contextXmlConfig.getBean("scene", Scene.class);
        sceneRandom.draw();
    }


}
