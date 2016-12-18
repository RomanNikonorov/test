package ru.rnikonorov.test.service;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS TESTDB");

            jdbcTemplate.execute("CREATE TABLE TESTDB(" +
                    " id int(10) unsigned not null AUTO_INCREMENT, " +
                    " name VARCHAR(255)," +
                    " primary key (id))");
        } catch (DataAccessException exc) {
            log.error(exc.getMessage());
        }
    }

    @Override
    public List<TestDB> findAll() {
        try {
            return jdbcTemplate.query("SELECT * FROM TESTDB",
                    new TestDbMapper());
        } catch (DataAccessException exc) {
            log.error(exc.getMessage());
            return null;
        }
    }


    @Override
    public List<TestDB> findByName(String name) {
        try {
            return jdbcTemplate.query("SELECT * FROM TESTDB WHERE NAME LIKE ?",
                    new TestDbMapper(), "%" + name + "%");
        } catch (DataAccessException exc) {
            log.error(exc.getMessage());
            return null;
        }
    }

    @Override
    public void save (String name) {
        log.info("Inserting ", name);
        try {
            jdbcTemplate.update("INSERT INTO TESTDB (name) VALUES (?)", name);
        } catch (DataAccessException exc) {
            log.error(exc.getMessage());
        }

    }
}
