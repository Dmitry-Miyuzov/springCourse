package ru.dima.beans.shape._base;

public abstract class Shape {
    protected Coords coords;
    protected String color;

    public Shape(Coords coords, String color) {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    protected void setX(Double x) {
        coords.setX(x);
    }

    protected void setY(Double y) {
        coords.setY(y);
    }

}
