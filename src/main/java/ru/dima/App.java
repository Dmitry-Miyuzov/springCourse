package ru.dima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dima.beans.Scene;

public class App {

    public static void main(String[] args) {
    ApplicationContext contextXmlConfig = new ClassPathXmlApplicationContext("applicationContext.xml");
        Scene scene = contextXmlConfig.getBean("scene", Scene.class);
        scene.draw();
    }


}
