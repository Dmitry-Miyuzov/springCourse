package ru.dima.beans.shape.concrete;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.dima.beans.shape._base.Coords;
import ru.dima.beans.shape._base.Shape;
import ru.dima.enums.Color;

@Component
@Scope("prototype")
public class Point extends Shape {

    public Point(@Value("#{coords}")Coords coords,
                 @Value("#{T(ru.dima.enums.Color).randomColor()}") Color color) {
        super(coords, color);
    }

    @Override
    public void draw() {
        System.out.printf("Поставить точку в координате x = %f, y = %f. Цвет = %s.%n",
                coords.getX(), coords.getY(), color);
    }
}

