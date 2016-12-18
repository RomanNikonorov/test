package ru.rnikonorov.test.service;


import org.springframework.jdbc.core.RowMapper;
import ru.rnikonorov.test.TestDB;

import java.sql.ResultSet;
import java.sql.SQLException;

final class TestDbMapper implements RowMapper<TestDB> {

    public TestDB mapRow(ResultSet resultSet, int i) throws SQLException {
        TestDB testDB = new TestDB();
        testDB.setId(resultSet.getLong("id"));
        testDB.setName(resultSet.getString("name"));
        return testDB;
    }

}
