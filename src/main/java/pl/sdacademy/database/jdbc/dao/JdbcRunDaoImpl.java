package pl.sdacademy.jdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcRunDaoImpl implements RunDao {
    public void save(Run run) throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("Insert into runs(id,name,place,start_date,start_time,members_limit)values(?,?,?,?,?,?)");

        statement.setInt(1, (int) run.getId());
        statement.setString(2, run.getName());
        statement.setString(3, run.getPlace());


        java.util.Date now = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(now.getTime());

        statement.setDate(4, sqlDate);
        statement.setDate(5, sqlDate);
        statement.setInt(6, run.getMemberLimit());
        statement.executeUpdate();

    }

    public Run findById(Long id) throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT name from runs WHERE id = ?");
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()==true) {
            Run run = new Run();
            run.setId(resultSet.getLong("ID"));
            run.setName(resultSet.getString("name"));
            run.setPlace(resultSet.getString("place"));
            run.setMemberLimit(resultSet.getInt("members_limit"));
            run.setStartDate(resultSet.getDate("start_date"));
            run.setStartTime(resultSet.getDate("start_time"));
            return run;
        }
    return null;
    }

    public List<Run> findAll() throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * from runs");
        List<Run>result = new ArrayList<Run>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()==true) {
            Run run = new Run();
            run.setId(resultSet.getLong("ID"));
            run.setName(resultSet.getString("name"));
            run.setPlace(resultSet.getString("place"));
            run.setMemberLimit(resultSet.getInt("members_limit"));
            run.setStartDate(resultSet.getDate("start_date"));
            run.setStartTime(resultSet.getDate("start_time"));
            result.add(run);
        }
        return result;    }

    public void update(Run run) throws SQLException {

    }

    public void delete(Long id) throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("delete from runs where id= ? ");
        statement.setLong(1, id);
        statement.executeUpdate();
    }
}
