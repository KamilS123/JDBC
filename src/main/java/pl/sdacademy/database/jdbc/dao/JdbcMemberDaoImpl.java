package pl.sdacademy.database.jdbc.dao;

import pl.sdacademy.database.dao.MemberDao;
import pl.sdacademy.database.entity.Member;
import pl.sdacademy.database.jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JdbcMemberDaoImpl implements MemberDao {

    private Connection connection = JdbcUtils.getInstance().getConnection();


    public void save(Member member) throws SQLException {
        PreparedStatement statement = connection
                .prepareStatement("insert into members (id, name, last_name, start_number, run_id) values (?, ?, ?, ?, ?)");


        statement.setLong(1, member.getId());
        statement.setString(2, member.getName());
        statement.setString(3, member.getLastName());

        statement.setInt(4, member.getStartNumber());
        statement.setLong(5, member.getRunId());

        statement.executeUpdate();
    }

    public Member findById(Long id) throws SQLException {
        return null;
    }

    public List<Member> findAll() throws SQLException {
        return null;
    }

    public void update(Member member) throws SQLException {

    }

    public void delete(Long id) throws SQLException {

    }

    public void deleteAll() throws SQLException {
        connection.createStatement().executeUpdate("delete from members");
    }
}
