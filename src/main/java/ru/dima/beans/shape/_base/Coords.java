package ru.dima.beans.shape._base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Coords {
    private Double x;
    private Double y;

    public Double getX() {
        return x;
    }

    @Value("#{new java.util.Random().nextDouble() * 10}")
    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    @Value("#{new java.util.Random().nextDouble() * 10}")
    public void setY(Double y) {
        this.y = y;
    }
}
