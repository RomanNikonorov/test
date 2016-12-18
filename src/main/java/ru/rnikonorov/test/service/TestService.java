package ru.rnikonorov.test.service;

import javassist.NotFoundException;
import org.springframework.dao.DataAccessException;
import ru.rnikonorov.test.TestDB;

import java.util.List;

public interface TestService {
    void reset();
    List<TestDB> findAll() throws DataAccessException;
    List<TestDB> findByName(String name) throws DataAccessException;
    void save (String name) throws DataAccessException;
}
