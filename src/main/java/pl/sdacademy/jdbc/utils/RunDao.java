package pl.sdacademy.jdbc.utils;

import java.sql.SQLException;
import java.util.List;

public interface RunDao {
    void save(Run run) throws SQLException;
    Run findById(Long id) throws SQLException;
    List<Run>findAll() throws SQLException;
    void update(Run run) throws SQLException;
    void delete(Long id) throws SQLException;
}
