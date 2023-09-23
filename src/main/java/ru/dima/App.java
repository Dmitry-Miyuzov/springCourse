package ru.dima;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.dima.bean.Cat;

public class App {

    public static void main(String[] args) {
        //1. Простое приложение с 1 бином.
        //2. Что будет выдавать если потребуем один и тот же бин?
        //3. В какой момент этот объект или эти объекты создаются?

        ApplicationContext contextJavaConfig = new AnnotationConfigApplicationContext("ru.dima");
        System.out.println("После создания контейнера.");


        Cat beanFirst = contextJavaConfig.getBean(Cat.class);
        Cat beanSecond = contextJavaConfig.getBean(Cat.class);

        System.out.println(beanFirst == beanSecond); //true Один и тот же объект в куче.
        /*
            2. По умолчанию если мы не указываем тип бина (компонента) - он синглтон.
            3. Бины с типом синглтон создаются после инициализации контейнера.
            Важно. Если мы создадим еще 1 контейнер - то объекты будут разные.
            Пример ниже.

            Важно.
            Бинам с типом синглтон мы можем поменять стратегию инициализации.
            Указав аннотацию Lazy (ленивый) - бин инициализируются только при первом его запросе, а не после иниц.
            контейнера.
         */

        ApplicationContext contextJavaConfigSecond = new AnnotationConfigApplicationContext("ru.dima");
        System.out.println("После создания второго контейнера.");

        Cat beanThird = contextJavaConfigSecond.getBean(Cat.class);

        System.out.println(beanFirst == beanThird); //false
    }
}
