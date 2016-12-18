package ru.rnikonorov.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.rnikonorov.test.TestDB;

import java.util.List;

@Component
public class TestServiceImpl implements TestService {

    private static final Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void reset () {

        log.info("Resetting dataBase");

        jdbcTemplate.execute("DROP TABLE IF EXISTS TESTDB");

        jdbcTemplate.execute("CREATE TABLE TESTDB(" +
                " id int(10) unsigned not null AUTO_INCREMENT, " +
                " name VARCHAR(255)," +
                " primary key (id))");

    }

    @Override
    public List<TestDB> findAll() {
        List<TestDB> result = jdbcTemplate.query("SELECT * FROM TESTDB",
                new TestDbMapper());
        return result;
    }


    @Override
    public List<TestDB> findByName(String name) {
        List<TestDB> result = jdbcTemplate.query("SELECT * FROM TESTDB WHERE NAME LIKE ?",
                new TestDbMapper(), "%" + name + "%");
        return result;
    }

    @Override
    public void save (String name) {
        jdbcTemplate.update("INSERT INTO TESTDB (name) VALUES (?)", name);
    }
}
