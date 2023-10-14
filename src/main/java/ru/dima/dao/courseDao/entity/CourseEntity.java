package ru.dima.dao.courseDao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Accessors(chain = true)
@Getter
@Setter

@Entity
@Table(name = "courses")
public class CourseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "length")
    private int length;
    @Column(name = "description")
    private String description;

    @Override
    public String toString() {
        return String.format("Id - %s, title - %s, length - %s",
                getId(), getTitle(), getLength());
    }
}
