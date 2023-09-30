package ru.dima.beans;

import ru.dima.beans.shape._base.Shape;

import java.util.List;

public class Scene {
    private static Scene scene;

    private final List<Shape> objects;

    private Scene(List<Shape> objects) {
        System.out.println("Создан бин сцены");
        this.objects = objects;
    }

    public static Scene getInstance(List<Shape> objects) {
        if (scene != null) {
            return scene;
        } else {
            synchronized (Scene.class) {
                scene = new Scene(objects);
                return scene;
            }
        }
    }

    public void draw() {
        for (Shape shape: objects) {
            shape.draw();
        }
    }
}
