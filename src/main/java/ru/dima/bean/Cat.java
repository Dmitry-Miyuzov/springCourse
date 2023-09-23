package ru.dima.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString

@Component
@PropertySource("classpath:beanProperties/cat.properties")
public class Cat {
    @Value("${cat.name}")
    private String name;
    @Value("${cat.color}")
    private String color;
    @Value("${cat.age}")
    private Integer age;

    public Cat() {
        System.out.println("Создалась кошка.");
    }


}
