package ru.dima.dao.courseDao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Getter
@Setter
public class CourseEntity implements Serializable {
    private int id;
    private String title;
    private int length;
    private String description;

    @Override
    public String toString() {
        return String.format("%-3d %-50s %-4d",
                getId(), getTitle(), getLength());
    }
}
