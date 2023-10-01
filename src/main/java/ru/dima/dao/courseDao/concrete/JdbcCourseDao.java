package ru.dima.dao.courseDao.concrete;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.dima.dao.courseDao.CourseDao;
import ru.dima.dao.courseDao.entity.CourseEntity;

import java.sql.Types;
import java.util.List;

@RequiredArgsConstructor
public class JdbcCourseDao implements CourseDao {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<CourseEntity> rowMapper = (resultSet, rowNum) -> new CourseEntity()
            .setId(resultSet.getInt("id"))
            .setTitle(resultSet.getString("title"))
            .setLength(resultSet.getInt("length"))
            .setDescription(resultSet.getString("description"));

    private static final String SQL_SELECT_COURSE = """
            SELECT id, title, length, description
            FROM web.courses
            """;

    private static final String SQL_SELECT_COURSE_BY_ID = """
                    %s
                    WHERE id = ?
                    """.formatted(SQL_SELECT_COURSE);

    private static final String SQL_SELECT_COURSE_BY_TITLE = """
            %s
            WHERE title like ?
            """.formatted(SQL_SELECT_COURSE);

    private static final String SQL_DELETE_COURSE_BY_ID = """
            DELETE FROM web.courses
            WHERE id = ?
            """;

    private static final String SQL_INSERT_COURSE = """
            INSERT INTO web.courses (title, length, description)
            VALUES (?, ?, ?)
            """;

    private static final String SQL_UPDATE_COURSE = """
            UPDATE web.courses
            SET title = ?, length = ?, description = ?
            WHERE id = ?
            """;

    @Override
    public CourseEntity findById(int id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_COURSE_BY_ID, rowMapper, id);
    }

    @Override
    public List<CourseEntity> findAll() {
        return jdbcTemplate.query(SQL_SELECT_COURSE, rowMapper);
    }

    @Override
    public List<CourseEntity> findByTitle(String title) {
        return jdbcTemplate.query(SQL_SELECT_COURSE_BY_TITLE, rowMapper, "%%%s%%".formatted(title));
    }

    @Override
    public void insert(CourseEntity course) {
        PreparedStatementCreatorFactory f =
                new PreparedStatementCreatorFactory(SQL_INSERT_COURSE,
                        Types.NVARCHAR, Types.INTEGER, Types.NVARCHAR);

        f.setGeneratedKeysColumnNames("id");
        KeyHolder kh = new GeneratedKeyHolder();

        jdbcTemplate.update(
                f.newPreparedStatementCreator(new Object[] {
                        course.getTitle(), course.getLength(), course.getDescription()}),
                kh);

        course.setId(kh.getKey().intValue());

    }
    @Override
    public void update(CourseEntity course) {
        jdbcTemplate.update(SQL_UPDATE_COURSE,
                course.getTitle(), course.getLength(),
                course.getDescription(), course.getId());

    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(SQL_DELETE_COURSE_BY_ID, id);
    }
}
