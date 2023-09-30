package ru.dima.beans.shape.utils;

import java.util.Random;

public enum Color {
    BLACK("Черный"),
    BLUE("Синий"),
    GRAY("Серый"),
    RED("Красный"),
    YELLOW("Желтый");

    private static final Random RANDOM = new Random();
    private final String color;


    Color(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }

    public static Color randomColor()  {
        Color[] colors = values();
        return colors[RANDOM.nextInt(colors.length)];
    }
}
