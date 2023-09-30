package ru.dima.beans.shape.concrete;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.dima.beans.shape._base.Coords;
import ru.dima.beans.shape._base.Shape;
import ru.dima.enums.Color;

@Component
@Scope("prototype")
public class Circle extends Shape {
    private final int radius;

    public Circle(@Value("#{coords}")Coords coords,
                  @Value("#{T(ru.dima.enums.Color).randomColor()}") Color color,
                  @Value("#{new java.util.Random().nextInt(0, 10)}") int radius) {
        super(coords, color);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.printf("Нарисовать круг c координатами x = %f, y = %f. Цвет = %s. Радиус = %d.%n",
                coords.getX(), coords.getY(), color, radius);
    }
}
