package ru.dima.beans.shape.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import ru.dima.beans.Scene;
import ru.dima.beans.shape._base.Coords;
import ru.dima.beans.shape._base.Shape;
import ru.dima.beans.shape.concrete.Circle;
import ru.dima.beans.shape.concrete.Point;
import ru.dima.beans.shape.utils.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
@PropertySource({"classpath:countShapes.properties"})
public class SceneConfig {
    @Autowired
    private Environment env;

    @Bean("randomCoordinate")
    @Scope("prototype")
    public Coords randomCoordinate() {
        Coords coords = new Coords();
        Random random = new Random();
        coords.setX(random.nextDouble());
        coords.setY(random.nextDouble());
        return coords;
    }


    @Bean("randomCircle")
    @Scope("prototype")
    public Shape randomCircle(
            @Value("#{randomCoordinate}") Coords coords) {
        int radius = new Random().nextInt(10);
        return new Circle(coords, Color.randomColor(), radius);
    }

    @Bean("randomPoint")
    @Scope("prototype")
    public Shape randomPoint(
            @Value("#{randomCoordinate}") Coords coords) {
        String color = env.getProperty("color.green");
        return new Point(coords, Color.randomColor());
    }

    @Bean("scene")
    @Scope("singleton")
    @Lazy
    public Scene sceneRandom(
            @Value("${circle.count}") int countCircle,
            @Value("${point.count}") int countPoint) {
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < countCircle; i++) {
            shapes.add(randomCircle(randomCoordinate()));
        }
        for (int i = 0; i < countPoint; i++) {
            shapes.add(randomPoint(randomCoordinate()));
        }
        return Scene.getInstance(shapes);
    }
}
