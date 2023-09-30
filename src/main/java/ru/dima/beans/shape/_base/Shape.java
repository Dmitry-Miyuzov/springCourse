package ru.dima.beans.shape._base;

import ru.dima.beans.shape.utils.Color;

public abstract class Shape {
    protected Coords coords;
    protected Color color;

    public Shape(Coords coords, Color color) {
        this.coords = coords;
        this.color = color;
    }

    public abstract void draw();

    public Coords getCoords() {
        return coords;
    }

    public void setCoords(Coords coords) {
        this.coords = coords;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    protected void setX(Double x) {
        coords.setX(x);
    }

    protected void setY(Double y) {
        coords.setY(y);
    }

}
