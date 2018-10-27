package pl.sdacademy.jdbc.utils;

import java.sql.*;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws SQLException {
/*        insertRun(1,"abc","abc",new java.util.Date(), new java.util.Date(), 10);
        insertRun(2,"ghi","ghi",new java.util.Date(), new java.util.Date(), 20);
        insertRun(6,"def","def",new java.util.Date(), new java.util.Date(), 30);
        insertRun(4,"jkl","jkl",new java.util.Date(), new java.util.Date(), 40);*/

        RunDao runDao = DaoProvider.getInstance().getRunDao();
        Member memberDao = DaoProvider.getInstance().getMemberDao();

        for(int i = 1; i<10; i++) {
            Run run = new Run();
            run.setId((long)i);
            run.setName(UUID.randomUUID().toString());
            runDao.save(run);

            for(int j = 1; j<10; j++) {
                Member member = new Member();
                member.setName(UUID.randomUUID().toString());
                member.setLastName(UUID.randomUUID().toString());
                member.setStartNumber((int)(Math.random()*100));
                member.setId(run.getId());
            }
        }
    }

    private static void insertRun(Integer id, String name, String place, java.util.Date startDate, java.util.Date start_time, Integer limit) throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("Insert into runs(id,name,place,start_date,start_time,members_limit)values(?,?,?,?,?,?)");

        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setString(3, place);
        java.util.Date now = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(now.getTime());
        statement.setDate(4, sqlDate);
        statement.setDate(5, sqlDate);
        statement.setInt(6, limit);
        statement.execute();
    }

    private static void deleteRun(Long toDelete) throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("delete from runs where id= ? ");
        statement.setLong(1, toDelete);
        statement.executeUpdate();
    }

    private static void getElement(Integer id) throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT name from runs WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String string = resultSet.getString("name");
            System.out.println(string);
        }
    }
    private static void updateElement(Integer id,String changedName) throws SQLException {
        Connection connection = JdbcUtils.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE name FROM runs WHERE values = (?,? )");
        statement.setInt(1,id);
        statement.setString(2,changedName);
        statement.executeUpdate(changedName);
        statement.execute();
    }
}