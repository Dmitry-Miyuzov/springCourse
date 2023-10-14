package ru.dima.dao.courseDao;

public interface CourseDaoCustom<T> {
    void deleteAllByTitle(String title);
}
