package pl.sdacademy.jdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Member implements RunDao{
    private long id;
    private  String name;
    private  String lastName;
    private String place;
    private String startTime;
    private int startNumber;
    private String startDate;

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(int startNumber) {
        this.startNumber = startNumber;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Long getMemberLimit() {
        return memberLimit;
    }

    public void setMemberLimit(Long memberLimit) {
        this.memberLimit = memberLimit;
    }

    private Long memberLimit;

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
        return null;
    }

    public List<Run> findAll() throws SQLException {
        return null;
    }

    public void update(Run run) throws SQLException {

    }

    public void delete(Long id) throws SQLException {

    }
}
